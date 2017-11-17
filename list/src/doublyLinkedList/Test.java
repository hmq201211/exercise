package doublyLinkedList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<Employee> dll = new DoublyLinkedList<Employee>();
		for (String s1 : readFile()) {
			String[] s2 = s1.split(" ");
			int id = Integer.parseInt(s2[1]);
			String name = s2[0];
			dll.add(new Employee(id, name));
		}
		dll.add(Where.MIDDLE, 29, new Employee());
		dll.remove(28);
		System.out.println();
		dll.print_from_beginning();
		System.out.println();
		dll.print_from_end();
	}

	private static String[] readFile() {
		String[] s = new String[30];
		int index = 0;
		try {
			InputStream is = new FileInputStream("lab4Example.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String str = null;
			while (true) {
				str = reader.readLine();
				if (str != null)
					s[index++] = str;
				else
					break;
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
