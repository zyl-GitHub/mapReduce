package com.zhao.hadoop.rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class RPCServer implements Bizable
{
	public String sayHi(String name)
	{
		return "HI~"+name;
	}
	public static void main(String[] args) throws Exception
	{
		Configuration conf = new Configuration();
		Server server = new RPC.Builder(conf)
							.setProtocol(Bizable.class)
							.setInstance(new RPCServer())
							.setBindAddress("localhost")
							.setPort(9527)
							.build();
		server.start();
	}
}
