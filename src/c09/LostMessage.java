package c09;

// How an exception can be lost

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trival exception";
	} 
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	public static void main(String[] args) throws HoHumException {
		LostMessage lm = new LostMessage();
	
		try {
			lm.f();
		} catch (VeryImportantException e) {
			lm.dispose();
			e.printStackTrace();
		}
	}
}
