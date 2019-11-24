package com.trojans.iwannabe.chatbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
	static List<Record> data;

	public static void main(String[] args) {
		data = new ArrayList<>();
		Map<String, Double> template1 =  new HashMap<>();
		Map<String, Double> template2 =  new HashMap<>();
		Map<String, Double> template3 =  new HashMap<>();
		Map<String, Double> template4 =  new HashMap<>();
		Map<String, Double> template5 =  new HashMap<>();
		Map<String, Double> template6 =  new HashMap<>();
		Map<String, Double> template7 =  new HashMap<>();
		Map<String, Double> template8 =  new HashMap<>();
		Map<String, Double> template9 =  new HashMap<>();
		Map<String, Double> template10 =  new HashMap<>();
		
		// Engineer
		template1.put("Mathematics", 50.d);
		template1.put("Literature", 0.d);
		template1.put("Physics", 40.d);
		template1.put("Programming", 60.d);
		template1.put("Engineering", 80.d);
		template1.put("Acting", 0.d);
		template1.put("Sports", 0.d);
		template1.put("Music", 0.d);
		template1.put("isActive", 0.d);	
		data.add(new Record(template1));
		
		// Actor
		template2.put("Mathematics", 34.d);
		template2.put("Literature", 50.d);
		template2.put("Physics", 20.d);
		template2.put("Programming", 10.d);
		template2.put("Engineering", 0.d);
		template2.put("Acting", 100.d);
		template2.put("Sports", 0.d);
		template2.put("Music", 80.d);
		template2.put("isActive", 40.d);	
		data.add(new Record(template2));
		
		// Actor
		template3.put("Mathematics", 60.d);
		template3.put("Literature", 70.d);
		template3.put("Physics", 60.d);
		template3.put("Programming", 60.d);
		template3.put("Engineering", 40.d);
		template3.put("Acting", 80.d);
		template3.put("Sports", 40.d);
		template3.put("Music", 0.d);
		template3.put("isActive", 70.d);	
		data.add(new Record(template3));
		
		// Engineer
		template4.put("Mathematics", 0.d);
		template4.put("Literature", 0.d);
		template4.put("Physics", 0.d);
		template4.put("Programming", 60.d);
		template4.put("Engineering", 70.d);
		template4.put("Acting", 0.d);
		template4.put("Sports", 0.d);
		template4.put("Music", 0.d);
		template4.put("isActive", 0.d);	
		data.add(new Record(template4));
		
		// Actor
		template5.put("Mathematics", 0.d);
		template5.put("Literature", 60.d);
		template5.put("Physics", 10.d);
		template5.put("Programming", 40.d);
		template5.put("Engineering", 10.d);
		template5.put("Acting", 70.d);
		template5.put("Sports", 20.d);
		template5.put("Music", 40.d);
		template5.put("isActive", 10.d);	
		data.add(new Record(template5));
		
		// Actor
		template6.put("Mathematics", 0.d);
		template6.put("Literature", 0.d);
		template6.put("Physics", 0.d);
		template6.put("Programming", 0.d);
		template6.put("Engineering", 0.d);
		template6.put("Acting", 100.d);
		template6.put("Sports", 60.d);
		template6.put("Music", 90.d);
		template6.put("isActive", 60.d);	
		data.add(new Record(template6));
		
		// Engineer
		template7.put("Mathematics", 100.d);
		template7.put("Literature", 0.d);
		template7.put("Physics", 100.d);
		template7.put("Programming", 0.d);
		template7.put("Engineering", 100.d);
		template7.put("Acting", 0.d);
		template7.put("Sports", 0.d);
		template7.put("Music", 0.d);
		template7.put("isActive", 0.d);	
		data.add(new Record(template7));
		
		// Engineer
		template8.put("Mathematics", 60.d);
		template8.put("Literature", 40.d);
		template8.put("Physics", 80.d);
		template8.put("Programming", 90.d);
		template8.put("Engineering", 100.d);
		template8.put("Acting", 0.d);
		template8.put("Sports", 10.d);
		template8.put("Music", 0.d);
		template8.put("isActive", 20.d);	
		data.add(new Record(template8));
		
		// Engineer
		template9.put("Mathematics", 70.d);
		template9.put("Literature", 50.d);
		template9.put("Physics", 40.d);
		template9.put("Programming", 80.d);
		template9.put("Engineering", 80.d);
		template9.put("Acting", 0.d);
		template9.put("Sports", 40.d);
		template9.put("Music", 0.d);
		template9.put("isActive", 30.d);	
		data.add(new Record(template9));
		
		// Actor
		template10.put("Mathematics", 0.d);
		template10.put("Literature", 30.d);
		template10.put("Physics", 0.d);
		template10.put("Programming", 0.d);
		template10.put("Engineering", 0.d);
		template10.put("Acting", 70.d);
		template10.put("Sports", 20.d);
		template10.put("Music", 60.d);
		template10.put("isActive", 20.d);	
		data.add(new Record(template10));
	}
}
