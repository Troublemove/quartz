package com.itstyle.quartz.othertest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10,33,56,78,98};
		int target = 10;
		
//		long t1 = System.currentTimeMillis();
//		long t2 = System.currentTimeMillis();
//		System.out.println("time:  "+(t2-t1));
		
		for(int i=10;i<Integer.MAX_VALUE;i*=10)
            test(i);
	}
	
	public static void cal1(int[] a, int target) {
		for (int i = 0; i < a.length; i++) {
			
		}
	}
	public static void cal2(int[] a, int target) {
		int mid = target / 2;// 奇数
		if (target % 2 == 0) {// 偶数
			mid = mid - 1 ;
		}
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i <= mid; i++) {
			map.put(i, target-i);
		}
		for (Integer key : map.keySet()) {
			Integer value = map.get(key);
			
			int pos1 = Arrays.binarySearch(a, key);
			int pos2 = Arrays.binarySearch(a, value);
			
			if (-8 != pos1 && -8 != pos2 && -1 != pos1 && -1 != pos2) {
				System.out.println(pos1 + ","+ pos2);
			}
		}
	}
	static void test(long limit){
        Random rand = new Random();
        IntStream stream = rand.ints(limit);
        int[] arr = stream.toArray();
        int[] arr1 = Arrays.copyOf(arr, arr.length);

        long t1 = System.currentTimeMillis();
        Arrays.parallelSort(arr);
        long t2 = System.currentTimeMillis();
        Arrays.sort(arr1);
        long t3 = System.currentTimeMillis();
        System.out.println("limit:"+limit+"\t parallelSort: "+(t2-t1)+"ms\tserialSort: "+(t3-t2)+"ms");
    }
}
