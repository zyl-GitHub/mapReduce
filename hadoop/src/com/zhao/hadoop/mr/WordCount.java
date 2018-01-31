package com.zhao.hadoop.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount
{
	public static void main(String[] args) throws Exception
	{
		//实例化一个交作业的类
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(WordCount.class);
		//设置mapper类
		job.setMapperClass(WCMapper.class);
		//设置mapper的输出
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		//设置文件输入的路径
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		//设置reducer类
		job.setReducerClass(WCReducer.class);
		//设置reducer的输出
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		//设置文件的输出路径
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//combiner
		job.setCombinerClass(WCReducer.class);
		//提交作业
		job.waitForCompletion(true);
	}
}
