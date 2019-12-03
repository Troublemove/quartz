package com.itstyle.quartz.othertest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestInterface {
//	Formula formula = new Formula() {
//		
//		@Override
//		public double calculate(int a) {
//			return 0;
//		}
//	};
	public static void main(String[] args) {
//		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//		Collections.sort(names, new Comparator<String>() {
//
//			@Override
//			public int compare(String a, String b) {
//				return a.compareTo(b);
//			}
//		});
//		
//		Collections.sort(names, (String a, String b) -> {
//			return b.compareTo(a);
//		});
//		Collections.sort(names, (String a, String b) -> b.compareTo(a));
//		Collections.sort(names, (a, b) -> b.compareTo(a));
		
//		Formula formula = Double :: new;
//		double a = formula.sqrt(123);
//		System.out.println(a);
//		names
//			.stream()
//			.sorted()
//			.filter((s) -> s.contains("a") || s.contains("t"))
//			.map(String :: toUpperCase)
//			.forEach(System.out::println);
//		
//		Optional<String> reduced = names
//			        				.stream()
//			        				.sorted()
//			        				.reduce((s1, s2) -> s1 + "#" + s2);
//		reduced.ifPresent(System.out::println);
		
		Map<Integer, String> map = new HashMap();
		map.computeIfPresent(3, (num, val) -> val + num);
		
		System.out.println(map.get(23));
		System.out.println(map.getOrDefault(23, "xxx"));
		System.out.println(map.get(23));
		
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9concat
	}
	
	
}
interface Formula {
	double calculate(double a);
	default double getA(int a) {
		return 0;
	}

    default double sqrt(double a) {
        return Math.sqrt(a);
    }
    
}
