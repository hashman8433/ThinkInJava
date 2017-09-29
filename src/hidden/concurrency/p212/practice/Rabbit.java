package hidden.concurrency.p212.practice;


/*兔子生育问题*/
public class Rabbit {

	private static int count = 0;
	public static int countRabbitNumber(int oneMouthNum, int towMouthNum, 
			int allMouth){
		
		if(allMouth < 0)
			return oneMouthNum + towMouthNum;
		System.out.println("oneMouthNum + "
				+ "towMouthNum = " 
				+ oneMouthNum + " " +towMouthNum + 
				" mouth : " + count++);
		int temp = towMouthNum;
		towMouthNum += oneMouthNum;
		oneMouthNum = temp;
		
		
		return countRabbitNumber(oneMouthNum, towMouthNum, 
				--allMouth);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countRabbitNumber(1,0,7));
	}

}
