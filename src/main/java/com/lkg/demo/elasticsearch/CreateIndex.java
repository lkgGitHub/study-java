package com.lkg.demo.elasticsearch;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.junit.jupiter.api.Test;

/**
 * Created by lkg on 2018/5/29
 * 创建索引
 */
public class CreateIndex {

	@Test
	public void createIndex() throws InterruptedException {
		RestHighLevelClient client = ESClient.getEsClient();

		CreateIndexRequest request = new CreateIndexRequest("index-aaa");
		request.settings(Settings.builder()
				.put("index.number_of_shards", 3)
				.put("index.number_of_replicas", 2)
		);

		ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
			@Override //执行成功完成时调用
			public void onResponse(CreateIndexResponse createIndexResponse) {
				System.out.println("创建索引成功");
			}

			@Override //执行失败完成时调用
			public void onFailure(Exception e) {
				System.err.println("创建索引Failure");
			}
		};

//		CreateIndexResponse createIndexResponse = client.indices().create(request);
		System.out.println("创建索引开始");
		client.indices().createAsync(request,listener);

		Thread.sleep(8000);
	}
}
