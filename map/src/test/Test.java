package test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>(new Comparator<Integer>() {
			{
			}

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(1, "2123");
		lhm.put(3, "222");
		lhm.put(4, "233");
		lhm.put(2, "2444");
		tm.put(1, "2123");
		tm.put(3, "222");
		tm.put(4, "233");
		tm.put(2, "2444");
		System.out.println(tm);
		System.out.println(lhm);
	}

}
