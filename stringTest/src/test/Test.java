package test;

public class Test {
	public static void main(String[] args) {
		stringConstructorDemo();
		stringCatchDemo();
		stringSubDemo();
		stringJudge();
		stringCompare();
		stringInternDemo();
		String[] s = { "nba", "abc", "cba", "zz", "qq", "haha" };
		stringBubbleSort(s);
		stringSelectSort(s);
		String s1="nbaernbatynbauinbaopnba";
		System.out.println(stringCountSubstring(s1, "nba"));
		System.out.println(stringFindTheLongestSubstring(s1, "nba"));
		String s2 = " A B C D E F G ";
		System.out.println(stringTrim(s2));
	}

	private static void stringConstructorDemo() {
		String s1 = new String();
		String s2 = "";
		System.out.println(s1 == s2);
		byte[] arr = { 65, 66, 67, 68 };
		String s3 = new String(arr);
		System.out.println(s3);
		char[] arr2 = { 'a', 'b', 'c', 'd' };
		String s4 = new String(arr2, 1, 2);
		System.out.println(s4);
	}

	private static void stringCatchDemo() {
		String s1 = "ABcd";
		System.out.println(s1.length());
		char c = s1.charAt(2);
		System.out.println(c);
		int i = s1.indexOf(c, 1);
		int i2 = s1.indexOf("AB", 1);
		System.out.println(i);
		System.out.println(i2);
	}

	private static void stringSubDemo() {
		String s1 = " A B C D E F G �� ";
		System.out.println(s1.substring(0, 1));
		System.out.println(s1.substring(1));
		String[] s = s1.split(" ");
		for (String s3 : s) {
			System.out.println(s3);
		}
		char[] c = s1.toCharArray();
		for (char c1 : c) {
			System.out.println(c1);
		}
		byte[] b = s1.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		System.out.println("Abc".toUpperCase());
		System.out.println("Abc".replace('A', 'c'));
		System.out.println("Abc".replace("A", "c"));
		System.out.println(s1.trim());
		System.out.println("abc".concat("1"));
		System.out.println(String.valueOf(false));
	}

	private static void stringJudge() {
		System.out.println("abc".equals("ABC"));
		System.out.println("abc".equalsIgnoreCase("ABC"));
		System.out.println("abc".contains("d"));
		System.out.println("abc".startsWith("c"));
		System.out.println("ac".endsWith("d"));
	}

	private static void stringCompare() {
		System.out.println("ac".compareTo("AC"));
		System.out.println("ac".compareToIgnoreCase("AC"));
	}

	private static void stringInternDemo() {
		String temp = "abc";
		String s1 = new String(temp);
		System.out.println(temp.intern() == s1.intern());
	}

	private static void stringBubbleSort(String[] s) {
		String temp = "";
		for (int i = 0; i < s.length - 1; i++) {
			int flag = 0;
			for (int j = 0; j < s.length - 1 - i; j++) {
				if (s[j].compareTo(s[j + 1]) > 0) {
					temp = s[j];
					s[j] = s[j + 1];
					s[j + 1] = temp;
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}

		}
		for (String s1 : s) {
			System.out.println(s1);
		}

	}

	private static void stringSelectSort(String[] s) {
		for (int i = 0; i < s.length - 1; i++) {
			int index = 0;
			for (int j = 0; j <= s.length - 1 - i; j++) {
				if (s[index].compareTo(s[j]) < 0) {
					index = j;
				}
			}
			String temp = s[index];
			s[index] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
		for (String s1 : s) {
			System.out.println(s1);
		}
	}
	private static int stringCountSubstring(String s1,String s2) {
		int count=0;
		while(s1.contains(s2)) {
			count++;
			s1=s1.substring(s1.indexOf(s2)+s2.length());
		}
		
		return count;
	}
	private static String stringFindTheLongestSubstring(String s1,String s2) {
		for(int i=s2.length();i>=1;i--) {
			for(int j=0;j+i<=s2.length();j++) {
				String s=s2.substring(j, i);
				if(s1.contains(s))
					return s;
			}
		}
		return null;
		
	}
	private static String stringTrim(String s) {
		int headIndex=0;
		int tailIndex=s.length();
		while(s.charAt(headIndex)==' '&& headIndex<tailIndex) {
			headIndex++;
		}
		while(s.charAt(tailIndex-1)==' '&& headIndex<tailIndex) {
			tailIndex--;
		}
		return s.substring(headIndex,tailIndex);
	}

}
