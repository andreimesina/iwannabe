package com.trojans.iwannabe.chatbot;

import java.util.Map;

public class Centroid {
	private final Map<String, Double> coordinates;
	
	@Override
	public String toString() {
		return "CENTROID";
	}
	
	public Centroid(Map<String, Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	public Map<String, Double> getCoordinates() {
		return coordinates;
	}
}
