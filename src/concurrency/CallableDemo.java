package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String> {

	private int id;
	
	public TaskWithResult(int id){
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of TaskWithResult " + id;
	}

}

public class CallableDemo {
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> result = 
				new ArrayList<Future<String>>();
		
		for(int i = 0; i < 5; i++)
			result.add(exec.submit(new TaskWithResult(i)));
		int number = 0;
		try {
			for(Future<String> fs : result){
				System.out.println(fs.get());
				System.out.println(number++);
			}
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exec.shutdown();
		}
		
	}
}
