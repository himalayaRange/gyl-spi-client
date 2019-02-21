package org.ymy.xxb.client.support;

import org.ymy.xxb.client.bean.FactoryBean;
import org.ymy.xxb.client.factory.SpiClient;

public class SpiClientSupport implements SpiClient{
	
	private FactoryBean factoryBean;
	
	public FactoryBean getFactoryBean() {
		return factoryBean;
	}

	public void setFactoryBean(FactoryBean factoryBean) {
		this.factoryBean = factoryBean;
	}

	public SpiClientSupport(FactoryBean factoryBean) {
		super();
		this.factoryBean = factoryBean;
	}

	@Override
	public String execute() {
		String exec = OkHttp3Client.post(factoryBean.getRequestURL(), factoryBean.getParams(), factoryBean.getAccessToken());
		return exec;
	}

}
