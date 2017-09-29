package hidden.concurrency.p212.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * ClassName:FabonacciArray.java
 * Reason:	 
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月26日
 */
/*斐波那契数列 */
public class FabonacciArray implements Runnable {
	private static int count;
	//记录当前是第几个线程
	private int id = count++;
	
	private int fabonacciNumber;
	
	public FabonacciArray(int fabonacciNumber){
		this.fabonacciNumber = fabonacciNumber;
	}
	//斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
	/**
	 * x
	 * 若 times 过大则导致内存溢出
	 * @param number
	 * 	number[0] 第 n - 2 个数字
	 * 	number[1] 第 n - 1 个数字
	 * 	number[2] 第 n 个数字
	 * @param fabonacciNumber 当前剩余计算次数
	 * @return TODO
	 * @return
	 */
	public int fabonacciCaculate(int[] number, int times){
		if(number.length < 3)  return 0;

		//结束递归
		if(times == 0)  return 0;

		int temp = number[1] + number[2];
		number[0] = number[1];
		number[1] = number[2];
		number[2] = temp;
		
		System.out.print(number[2] + " ");
		fabonacciCaculate(number, --times);
		
		return temp;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[] number = {1, 1, 2};
		System.out.print(number[0] + " " + number[1] + " ");
		fabonacciCaculate(number, fabonacciNumber);
		System.out.println();
	}
	
	
	public static void main(String[] args){
		//SingleThread 单线程
		ExecutorService singleExec = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 9; i++)
			singleExec.execute(new FabonacciArray(i));
		
		singleExec.shutdown();
		
		//FixedThreadPool 固定线程 在有限的线程内执行任务
		ExecutorService fixedExec = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 9; i++)
			fixedExec.execute(new FabonacciArray(i));
		fixedExec.shutdown();
		
		//CachedThreadPool 自动为每一个任务创建一个线程
		ExecutorService cachedExec = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 9; i++)
			cachedExec.execute(new FabonacciArray(i));
		cachedExec.shutdown();
		
	}

}
