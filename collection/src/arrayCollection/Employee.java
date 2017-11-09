package arrayCollection;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;

	public Employee() {

	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "arrayCollection.Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if (this.id == o.id)
			return 0;
		else
			return this.id - o.id;
	}

}
