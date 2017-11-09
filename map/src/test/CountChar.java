package test;

import java.util.TreeMap;

public class CountChar {
	private static TreeMap<Character,Integer> countChar(String s){
		TreeMap<Character, Integer> tm= new TreeMap<Character,Integer>();
		char[] arr= s.toCharArray();
		for(char c:arr) {
			if(tm.containsKey(c)) {
				tm.put(c, tm.get(c)+1);
			}
			else {
				tm.put(c, 1);
			}
		}
		return tm;
	}
	public static void main(String[] args) {
		String s="fdgavdcbsdacdfs";
		System.out.println(countChar(s));
	}

}
