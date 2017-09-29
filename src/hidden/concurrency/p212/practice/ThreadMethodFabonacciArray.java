package hidden.concurrency.p212.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ClassName:ThreadMethodFabonacciArray.java
 * Reason:	 21 并发 练习10
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月26日
 */
public class ThreadMethodFabonacciArray {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	private final int arraySize;
	public ThreadMethodFabonacciArray(int size){
		arraySize = size;
	}
	
	
	public static ExecutorService getExec() {
		return exec;
	}


	public Future<String> runTask(){
		
		// 斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
		Future<String> f = exec.submit(new Callable<String>(){
			public String call(){
				int index = 1;
				int total = 0;
				List<Integer> fabonacciArray = new ArrayList<Integer>();
				fabonacciArray.add(1);
				fabonacciArray.add(1);
				
				// 生成 数组      
				while(++index < arraySize && arraySize > 2)
					// F(n) = F(n-1) + F(n-2)
					fabonacciArray.add(fabonacciArray.get(index - 1) + 
							fabonacciArray.get(index - 2));
				
				// 计算数组 总和
				for(int i = 0; i < arraySize; i++)
					total += fabonacciArray.get(i);
				
				return String.valueOf(total);
			}
		});
		
		return f;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Future<String>> result = new ArrayList<Future<String>>();
		
		for(int i = 0; i < 8; i++){
			ThreadMethodFabonacciArray threadMethod = 
					new ThreadMethodFabonacciArray(i);
			result.add(threadMethod.runTask());
		}
		
		for(Future<String> f : result)
			System.out.println(f.get());
		
		ThreadMethodFabonacciArray.getExec().shutdown();
	}
}
