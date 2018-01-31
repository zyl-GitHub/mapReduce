package com.zhao.hadoop.dc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DataCount
{
	public static void main(String[] args) throws Exception
	{
		//实例化交作业
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(DataCount.class);
		//配置mapper
		job.setMapperClass(DCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DataBean.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		//配置reducer
		job.setReducerClass(DCReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DataBean.class);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//配置分区
		job.setPartitionerClass(ProviderPartitioner.class);
		job.setNumReduceTasks(Integer.parseInt(args[2]));
		//提交作业
		job.waitForCompletion(true);
	}
	/**
	 * mapper
	 * @author zhao
	 *
	 */
	public static class DCMapper extends Mapper<LongWritable, Text, Text, DataBean>
	{
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException
		{
			String line = value.toString();
			String[] data = line.split("\t");
			String telNo = data[1];
			long up = Long.parseLong(data[8]);
			long down = Long.parseLong(data[9]);
			DataBean dataBean = new DataBean(telNo, up, down);
			context.write(new Text(telNo), dataBean);
		}
		
	}
	/**
	 * reducer
	 * @author zhao
	 *
	 */
	public static class DCReducer extends Reducer<Text, DataBean, Text, DataBean>
	{

		@Override
		protected void reduce(Text key, Iterable<DataBean> data,Context context)
				throws IOException, InterruptedException
		{
			long up_sum = 0;
			long down_sum = 0;
			for(DataBean dataBean : data)
			{
				up_sum += dataBean.getUpPayLoad();
				down_sum += dataBean.getDownPayLoad();
			}
			DataBean bean = new DataBean("",up_sum,down_sum);
			context.write(key, bean);
		}
		
	}
	/**
	 * partitioner
	 * @author zhao
	 *
	 */
	public static class ProviderPartitioner extends Partitioner<Text, DataBean>
	{
		private static Map<String, Integer> providerMap = new HashMap<String, Integer>();
		static
		{
			providerMap.put("135", 1);
			providerMap.put("136", 2);
			providerMap.put("137", 3);
		}
		@Override
		public int getPartition(Text key, DataBean value, int num)
		{
			String account = key.toString();
			String sub_acc = account.substring(0,3);
			Integer code = providerMap.get(sub_acc);
			if(code == null)
			{
				code = 0;
			}
			return code;
		}
		
	}
}
