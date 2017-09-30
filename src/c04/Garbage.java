package c04;

//Demonstration of the garbage
// collector and finalization

class Chair {
	static boolean gcrun = false;
	static boolean f = false;
	static int created = 0;
	static int finalized = 0;
	int i;
	Chair() {
		i = ++created;
		if(created == 47){
			System.out.println("Created 47");
		}
	}
	protected void finalize() {
		System.out.println("#" + i + " already finalize");
		if(!gcrun) {
			gcrun = true;
			System.out.println(
					"Beginngin to finalize after " +
					created + " Chairs have bean created");
		}
		if(i >= 47) {
			System.out.println(
					"Finalizing Chair #47, " +
					"Setting flag to stop Chair creation");
			f = true;
		}
		finalized++;;
		if(finalized >= created)
			System.out.println(
					"All " + finalized + " finalized");
	}
}
/**
 * ClassName:Garbage.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月30日
 */
public class Garbage {
	public static void main(String[] args) {
		/*if(args.length == 0) {
			System.err.println("Usage:\n" +
					"java Garbage before\n or:\n" +
					"java Garbage after");
			return;
		}*/
		String[] a = {"before"};
		args = a;
		while(!Chair.f){
			new Chair();
			new String("To take up space");
		}
		System.out.println(
				"After all Chairs have been created:\n" + 
				"total created =" + Chair.created +
				", total finalized = " + Chair.created +
				", total finalized = " + Chair.finalized);
		if(args[0].equals("before")) {
			System.out.println("gc():");
			System.gc();
			System.out.println("runFinalietion():");
			System.runFinalization();
		}
		System.out.println("bye!");
		if(args[0].equals("after"))
			System.runFinalizersOnExit(true);
	}
}
