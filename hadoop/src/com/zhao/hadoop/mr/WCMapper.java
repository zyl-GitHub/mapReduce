package com.zhao.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable>
{

	@Override
	protected void map(LongWritable key, Text value,Context context)throws IOException, InterruptedException
	{
		String line = value.toString();
		String[] words = line.split(" ");
		for(String w : words)
		{
			context.write(new Text(w), new LongWritable(1));
		}
	}

}
