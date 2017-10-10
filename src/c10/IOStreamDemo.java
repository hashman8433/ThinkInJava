package c10;
// Typical IO Stream Configurations

import java.io.*;

/**
 * ClassName:IOStreamDemo.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年10月9日
 */
public class IOStreamDemo {
	public static void main(String[] args) {
		try {
			// 1. Buffered input file
			DataInputStream in = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(args[0])));
			String s, s2 = new String();
			while((s = in.readLine()) != null)
				s2 += s + "\n";
			in.close();
			
			// 2. Input from memory
			StringBufferInputStream in2 = 
					new StringBufferInputStream(s2);
			int c;
			while((c = in2.read()) != -1)
				System.out.println((char)c);
			
			// 3. Formatted memory input
			DataInputStream in3 = new DataInputStream(
					new StringBufferInputStream(s2));
			while(true) 
				System.out.println((char)in3.readByte());
			
			// 4. Line numbering & file output
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			// 5. Storing & recovering data
			DataOutputStream out2 = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("Data.txt")));
			out2.writeBytes(
					"Here's the value of pi: \n");
			out2.writeDouble(3.14159);
			out2.close();
			DataInputStream in5 = 
					new DataInputStream(
							new BufferedInputStream(
									new FileInputStream("Data.txt")));
			System.out.println(in5.readLine());
			System.out.println(in5.readDouble());
		} catch (Exception e) {
			System.out.println(
					"End of stream encountered");
		}
		
		// 6. Reading/writing random access files
		try {
			RandomAccessFile rf = new RandomAccessFile("rtest.dat","rw");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
