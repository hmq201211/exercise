package test;

import bean.CostomizedAlgorithms;

public class Test {
	public static void main(String[] args) {
		String s = "4 5 7 2 + - *";
		String s1 = "5 3 7 9 + + -";
		System.out.println(CostomizedAlgorithms.calculate(s));
	}
}
