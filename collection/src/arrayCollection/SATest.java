package arrayCollection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SATest {
	public static void main(String[] args) {
		SortedArrayCollection<Employee> sac = new SortedArrayCollection<Employee>();
		for (String s1 : readFile()) {
			String[] s2 = s1.split(" ");
			int id = Integer.parseInt(s2[1]);
			String name = s2[0];
			Employee e = new Employee(id, name);
			sac.add(e);
		}
		System.out.println(sac.toString());
		System.out.println(sac.size());
		System.out.println(sac.remove(new Employee(1316863505,"Daniele")));
		System.out.println(sac.size());
		System.out.println(sac.toString());
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
