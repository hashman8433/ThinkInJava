package concurrency.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*斐波那契数列 */
public class FabonacciArray implements Runnable {
	private static int count;
	//记录当前是第几个线程
	private int id = count++;
	
	private int countTimes;
	
	public FabonacciArray(int times){
		countTimes = times;
	}
	//斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
	/**
	 * 若 times 过大则导致内存溢出
	 * @param number
	 * 	number[0] 第 n - 2 个数字
	 * 	number[1] 第 n - 1 个数字
	 * 	number[2] 第 n 个数字
	 * @param countTimes 当前剩余计算次数
	 * @return
	 */
	public void FabonacciCount(int[] number, int times){
		if(number.length < 3)  return;

		//结束递归
		if(times == 0)  return;

		int temp = number[1] + number[2];
		number[0] = number[1];
		number[1] = number[2];
		number[2] = temp;
		
		System.out.print(number[2] + " ");
		FabonacciCount(number, --times);
		
		return;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[] number = {1, 1, 2};
		System.out.print(number[0] + " " + number[1] + " ");
		FabonacciCount(number, countTimes);
	}
	
	public static void main(String[] args){
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		exec.execute(new FabonacciArray(10));
		
		exec.shutdown();
	}

}
