package concurrency.p212.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ClassName:FabonacciArrayCallable.java
 * Reason:	 21 并发 练习5
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月26日
 */
public class FabonacciArrayCallable implements Callable<String> {
	
	private final int arraySize;
	
	public FabonacciArrayCallable(int size){
		this.arraySize = size;
	}
	
	//创建斐波那契 数列  
	public void buildFabonacciNumber(List<Integer> arrayList, int times){
		
		while(times-- > 0 && arrayList.size() >= 2){
			int index = arrayList.size();
			arrayList.add(arrayList.get(index -1) + arrayList.get(index -2));
		}
	}
	
	//计算数组所有元素相加的和
	public int countIntegerArrayList(List<Integer> arrayList){
		int total = 0;
		int index = arraySize;
		while(index-- > 0)
			total += arrayList.get(index);
		return total;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		List<Integer> arrayList = new ArrayList<Integer>(arraySize);
		arrayList.add(1);
		arrayList.add(1);
		buildFabonacciNumber(arrayList, arraySize - 2);
		return "arraySize : " + arraySize + arrayList + 
				"  total : " + countIntegerArrayList(arrayList);
	}
	
	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			List<Future<String>> result = new ArrayList<Future<String>>();
			for(int i = 0; i < 9; i++)
				result.add(exec.submit(new FabonacciArrayCallable(i)));
			for(Future<String> f : result)
				System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
