package com.zhao.hadoop.hdfs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSDemo
{
	public static void main(String[] args) throws Exception
	{
		FileSystem fs = FileSystem.get(new URI("hdfs://hadoop:9000"), new Configuration());
		InputStream in = fs.open(new Path("/words.txt"));
		OutputStream out = new FileOutputStream(new File("d:/ws.txt"));
		int len = -1;
		byte[] b = new byte[1024];
		while((len = in.read(b))!=-1)
		{
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}
}
