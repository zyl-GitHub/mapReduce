package com.zhao.hadoop.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient implements Bizable
{

	@Override
	public String sayHi(String name)
	{
		
		return null;
	}
	public static void main(String[] args) throws IOException
	{
		Bizable proxy = RPC.getProxy(Bizable.class, 10010, new InetSocketAddress("localhost", 9527), new Configuration());
		String result = proxy.sayHi("tom");
		System.out.println(result);
		RPC.stopProxy(proxy);
	}
}
