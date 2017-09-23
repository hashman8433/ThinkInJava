/**
 * 
 */
package annotions;

/**
 * ClassName:Testable.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月23日
 */
public class Testable {
	public void execute(){
		System.out.println("Executing..");
	}
	
	@Test
	void testExcute(){ execute();}
}
