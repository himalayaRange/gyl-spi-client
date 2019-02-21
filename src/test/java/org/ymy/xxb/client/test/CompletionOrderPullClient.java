package org.ymy.xxb.client.test;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.ymy.xxb.client.factory.SpiClient;
import org.ymy.xxb.client.factory.YmySpiClientFactory;
import com.alibaba.fastjson.JSON;
/**
 * 中台推送SCM客户端单元测试
 * 
 * created by wangyi.
 */
public class CompletionOrderPullClient {
	/**
	 * 完工单撤下URL
	 */
	private static final String completionOrderPullCancleURL = "http://localhost:11000/spi/e3/completionOrder/pull/cancle";
	@Test
	public void cancle() throws InstantiationException, IllegalAccessException {
		String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjoiYmVhcmVyIiwiaWF0IjoxNTUwNDczNTIyLCJzdWIiOiJ7XCJyb2xlSWRcIjpcIjFcIixcInJvbGVOYW1lXCI6XCJzdXBBZG1pblwiLFwiYXR0cmlidXRlc1wiOnt9LFwidXNlck5hbWVcIjpcInlteS54eGIuZGV2bG9wZXJcIixcInVzZXJJZFwiOlwiMVwifSIsImlzcyI6IjE2MTA2NTE3MTdAcXEuY29tIiwiYXVkIjoiUkVTVEFQSUBzdXBBZG1pbiIsImV4cCI6MTU1MDQ3NTMyMiwibmJmIjoxNTUwNDczNTIyfQ.1hyY4BMhymZYZw6uOLsoL4XvQqAi45V-RXyDrQYHaUk";
		YmySpiClientFactory factory = YmySpiClientFactory.class.newInstance();
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("wgNo", "WGD20190115006");
		SpiClient spiClient = factory.configuration(completionOrderPullCancleURL, requestMap, accessToken);
		String resultJson = spiClient.execute();
		Map<String,Object> parseObject = JSON.parseObject(resultJson , Map.class);
		System.out.println(parseObject.get("message"));
	}
}
