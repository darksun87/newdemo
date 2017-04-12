package com.crm.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class MultiDataSource extends AbstractRoutingDataSource {

	private final static Logger LOGGER = Logger.getLogger(MultiDataSource.class);

	private volatile int pre = -1;
	private int count;
	private Map<Integer, Object> indexedLookupKey = new HashMap<Integer, Object>();

	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		count = targetDataSources.size();
		Set<Object> keys = targetDataSources.keySet();
		int index = 1;
		for (Object object : keys) {
			indexedLookupKey.put(index, object);
			index++;
		}
	}

	@Override
	protected Object determineCurrentLookupKey() {
		int i = pre, j = pre;
		do {
			j = (j + 1) % count;
		} while (i == j);
		pre = j;
		return indexedLookupKey.get(j);
	}
}
