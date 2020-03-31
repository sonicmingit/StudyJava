package sonic.i.inter.compareto;

public class Student implements Comparable<Student> {
	String name;
	int age;

	/*
	 * 重写comparable的方法,用于Array.sort的排序
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Student a) {
		// 当前大于传入返回-1 倒序 ;1正序
		if (this.age > a.age) {
			return -1;
		} else if (this.age < a.age) {
			return 1;
		} else {
			return 0;
		}
	}

	/*
	 * 自动生成重写toString方法
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
