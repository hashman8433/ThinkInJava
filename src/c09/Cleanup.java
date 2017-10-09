package c09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Paying attentiont to exceptions
// in coustructors
class InputFile {
	private BufferedReader in;
	InputFile(String fname) throws Exception {
		try {
			in = 
				new BufferedReader(
						new FileReader(fname));
			// Other code that might throw exceptions
		} catch (FileNotFoundException e) {
			System.out.println(
					"Could not open " + fname);
			// Wasn't open, so don't close if
			throw e;
		} catch(Exception e) {
			// All other exceptions must close it
			try {
				in.close();
			} catch (Exception e1) {
				System.out.println(
						"in.close() unsuccessful");
			}
			throw e;
		} finally {
			// Don't close if here!!!
		}
	}
	String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			System.out.println(
					"readLine() unsuccessful");
			s = "failed";
		}
		return s;
	}
	void cleanup() {
		try {
			in.close();
		} catch (IOException e) {
			System.out.println(
					"in.close() unsuccessful");
		}
	}
}


public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			String s;
			int i = 1;
			while((s = in.getLine()) != null)
				System.out.println("" + i++ + ": " + s);
			in.cleanup();
		} catch (Exception e) {
			System.out.println(
					"Caught in main, e.printStackTrace()");
			e.printStackTrace();
		}
	}
}
