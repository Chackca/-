package Comparable;


public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public int compareTo(Person another) {
		int i = name.compareTo(another.name); // 使用字符串的比较
	    if(i == 0) { // 如果名字一样,比较年龄, 返回比较年龄结果
	    	return age - another.age;
	    } else {
	    	return i; // 名字不一样, 返回比较名字的结果.
	    }
	}
	
}
