package c09.practice;

public class Practice1 {
	public static void main(String[] args) {
		try {
			throw new Exception("have a Exception");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally println");
		}
	}
}
