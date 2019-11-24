package com.trojans.iwannabe.chatbot;

import java.util.Map;

public class Record {
	private final Map<String, Double> features;
	
	@Override
	public String toString() {
		String res = "";
		for (String key : features.keySet()) {
			res += (key + ": " + features.get(key) + ", ");
		}
		return res;
	}
	
	public Record(Map<String, Double> features) {
		this.features = features;
	}
	
	public Map<String, Double> getFeatures() {
		return features;
	}
}
