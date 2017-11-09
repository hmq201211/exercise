package test;

public class Test {
	public static void main(String[] args) {
		bufferCostructor();
	}
	private static void bufferCostructor() {
		StringBuffer sb= new StringBuffer();
		sb.append(4);
		sb.append(true);
		sb.append('1');
		sb.insert(2, false);
		sb.delete(1,2);
		sb.deleteCharAt(0);
		System.out.println(sb);
		System.out.println(sb.charAt(0));
		sb.replace(1, 3, "nba");
		System.out.println(sb);
		sb.setCharAt(0, '0');
		System.out.println(sb);
		sb.setLength(0);
		System.out.println(sb);
	}

}
