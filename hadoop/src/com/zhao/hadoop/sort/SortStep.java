package com.zhao.hadoop.sort;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SortStep
{

	public static void main(String[] args) throws Exception
	{
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(SortStep.class);
		//mapper
		job.setMapperClass(SortMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(InfoBean.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		//reducer
		job.setReducerClass(SortReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(InfoBean.class);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//commit
		job.waitForCompletion(true);
	}
	//mapper
	public static class SortMapper extends Mapper<LongWritable, Text, InfoBean, NullWritable>
	{
		private InfoBean bean = new InfoBean();
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException
		{
			String line = value.toString();
			String[] fields = line.split("\t");
			String account = fields[0];
			double income = Double.parseDouble(fields[1]);
			double expenses = Double.parseDouble(fields[2]);
			bean.set(account, income, expenses);
			context.write(bean, NullWritable.get());
		}
	}
	//reducer
	public static class SortReducer extends Reducer<InfoBean, NullWritable, Text, InfoBean>
	{
		private Text k = new Text();
		@Override
		protected void reduce(InfoBean bean, Iterable<NullWritable> values,Context context)
				throws IOException, InterruptedException
		{
			k.set(bean.getAccount());
			context.write(k, bean);
		}
		
	}
}
