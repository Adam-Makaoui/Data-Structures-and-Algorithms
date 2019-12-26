/**
 * Always insert at beginning area (by continous swapping of ajacent pairs) 1)
 * start from 1st index and reference it with a variable j (since we check left,
 * else AOB) 2) loop while variable j is < j-1 (j's left) and keep doing so
 * until it's not OR!! if is not J<=0 since we can't check j's left (j-1)
 * 
 * ANALYSIS : Comparisons: Worst-case: O(N^2) reverse order Best-case: O (N)
 * already sorted since we skip each adj cmp of j. Average-case: O(N^2) O(n)
 * space
 * 
 * Swaps: Worst-case: O(N^2) Best-case: O(n)
 *
 * Note: Efficent for small data, adaptive relatively, like natural human
 * sorting.
 * 
 * @author Attar
 *
 */
public class insertionSort extends Boxify {

	public static void swap(int a, int b, int[] arr) {
		int temp = arr[a]; // ref to smallest
		arr[a] = arr[b]; // smallest value to front
		arr[b] = temp; // smallest value to ex-location of smallest
	}

	public static void insSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { // start at 2nd index
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {// im less then my left
				// ---------SWAP------------------------------
				int temp = arr[j]; // ref to smallest
				arr[j] = arr[j - 1]; // smallest value to front
				arr[j - 1] = temp; // smallest value to ex-location of smallest
				// ---------SWAP END -------------------------
				j--; // for each iter move j back and check back's left, break if sorted
			}
			arrayPrinter(arr);
		}
	}

	public static void main(String[] args) {

		int[] testArray = { 5, 1, 3, 20, 100, 3, 1 };
		insSort(testArray);
		System.out.println("Is the array sorted? : " + isSorted(testArray));

	}

}
