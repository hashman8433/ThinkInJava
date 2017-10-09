package c10;
// Displays sorted directory listing

import java.io.File;
import java.io.FilenameFilter;

public class SortedDirList {
	private File path;
	private String[] list;
	public SortedDirList(final String afn) {
		path = new File(".");
		if(afn == null) 
			list = path.list();
		else
			list = path.list(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					String f = new File(name).getName();
					return f.indexOf(afn) != -1;
				}
				
			});
		sort();
	}
	void print() {
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
	
	private void sort() {
		//StrSortVector sv = new StrSortVector();
	}
}
