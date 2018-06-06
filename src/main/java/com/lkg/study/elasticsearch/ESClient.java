package com.lkg.study.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by lkg on 2018/5/29
 */
public class ESClient implements Closeable{
	private volatile static ESClient esClient;
	private static RestHighLevelClient client;
	private ESClient(){
		client = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("192.168.8.128",9200,"http")
				)
		);
	}

	public static RestHighLevelClient getEsClient(){
		if (esClient == null){
			synchronized (ESClient.class){
				if (esClient == null){
					esClient = new ESClient();
				}
			}
		}
		return client;
	}

	@Override
	public void close() throws IOException {
		client.close();
	}
}
