package com.trojans.iwannabe.chatbot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	public static void main(String[] args) {
		Data data = new Data();
		data.main(null);
		Map<Centroid, List<Record>> res = KMeans.fit(data.data, 2, new EuclideanDistance(), 10);
		for (Centroid key: res.keySet()) {
			System.out.println(key + ": "+ res.get(key));
		}
		Map<String, Double> user =  new HashMap<>();
		user.put("Mathematics", 90.d);
		user.put("Literature", 60.d);
		user.put("Physics", 90.d);
		user.put("Programming", 90.d);
		user.put("Engineering", 80.d);
		user.put("Acting", 70.d);
		user.put("Sports", 20.d);
		user.put("Music", 40.d);
		user.put("isActive", 10.d);
		Distance distance = new EuclideanDistance();
		double fitSum = 0;
		double[] fit = new double[res.size()];
		int j = 0;
		for (Centroid key : res.keySet()) {
			fit[j] = distance.calculate(key.getCoordinates(), user);
			fitSum += fit[j++];
		}
		for (int i = 0; i < fit.length; ++i) {
			fit[i] = round((fitSum - fit[i]) / fitSum, 2);
			System.out.println(fit[i]);
		}
	}
}

