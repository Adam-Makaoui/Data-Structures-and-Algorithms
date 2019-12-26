/**
 * Code for selection Sort, Procedure: 1) go through all items in big loop -1
 * (expect last one). 2) set min to be the current i index of big loop. 3)go
 * through all items in a second nested loop, start 1 ahead of i in big loop. 4)
 * compare our min to each index, update min accordingly. 5) swap min with i.
 * 
 * @author Attar
 *
 */
public class selectionSort extends Boxify {

	/** switch array locations min <-- i & vice versa */
	public static void swap(int min, int i, int[] arr) {
		int temp = arr[min]; // ref to smallest
		arr[min] = arr[i]; // smallest value to front
		arr[i] = temp; // smallest value to ex-location of smallest
	}

	public static void selSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				} // end of "if"

			} // end of "nested for"
			if (min != arr[i]) // saves memory, no need to swap
				swap(min, i, arr);
			arrayPrinter(arr);
		} // end of "for"
	}// end of "method"

	public static void main(String[] args) {

		int[] testArray = { 5, 1, 3, 20, 100, 3, 1 };
		selSort(testArray);
		// arrayPrinter(testArray);
	}

}
