/**
 * 
 */
package chapter04;

/**
 * @author Siva
 *
 */
public class Person {
	private int age;
	public String email;
	
	public void setAge(int age) {
		if(age <0 || age > 100){
			throw new IllegalArgumentException("Age should be between 0 and 100");
		}
		this.age = age;
	}
	public int getAge() {
		return age;
	}

}
