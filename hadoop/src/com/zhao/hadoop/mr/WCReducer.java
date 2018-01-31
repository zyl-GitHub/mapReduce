package com.zhao.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable>
{

	@Override
	protected void reduce(Text key, Iterable<LongWritable> value,Context context)
			throws IOException, InterruptedException
	{
		long counter = 0;
		for(LongWritable i : value)
		{
			counter += i.get();
		}
		context.write(key, new LongWritable(counter));
	}

}
