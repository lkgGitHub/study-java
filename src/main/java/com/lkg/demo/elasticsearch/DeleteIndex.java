package com.lkg.demo.elasticsearch;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created by lkg on 2018/5/30
 */
public class DeleteIndex {

	@Test
	public void deleteIndex() throws IOException {
		String index = "index-aaa";
		RestHighLevelClient client = ESClient.getEsClient();

		DeleteIndexRequest request = new DeleteIndexRequest(index);

	}
}
