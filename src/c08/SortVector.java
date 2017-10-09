package c08;
// A generic sorting vector

import java.util.*;

public class SortVector extends Vector {
	private Compare compare; // To hold the callback

	public SortVector(Compare comp) {
		compare = comp;
	}

	public void sort() {
		quickSort(0, size() - 1);
	}

	private void quickSort(int left, int right) {
		if (right > left) {
			Object o1 = elementAt(right);
			int i = left - 1;
			int j = right;
			while (true) {
				while (compare.lessThan(elementAt(++i), o1));
				
				while (j > left)
					if (compare.lessThanEqual(elementAt(--j), o1))
						break; // out of while
				
				if (i >= j)
					break;
				swap(i, j);
			}
			swap(i, right);
			quickSort(left, i - 1);
			quickSort(i + 1, right);
		}
	}

	/*public void quickSort(int left, int right) {
		if (left < right) {
			Object o1 = elementAt(right);
			int i = left - 1;
			int j = right + 1;
			while (true) {
				while (j > left && compare.lessThan(elementAt(--j), o1))
					;

				while (i < right && !compare.lessThanEqual(elementAt(++i), o1))
					;

				if (i >= j)
					break;
				swap(i, j);
			}
			quickSort(left, i - 1);
			quickSort(i + 1, right);
		}
	}*/
	
	 
	public void swap(int loc1, int loc2) {
		Object temp = elementAt(loc1);
		setElementAt(elementAt(loc2), loc1);
		setElementAt(temp, loc2);
	}
}
