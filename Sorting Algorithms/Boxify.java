
public class Boxify {

	/** constructor */
	public Boxify() {

	}

	// takes in size of array and prints out dashes for each index
	public static void dashPrint(int size) {
		if (size == 0)
			;
		else {
			System.out.print("---------");
			dashPrint(size - 1);
		}
	}

	public static void arrayPrinter(int[] arr) {
		dashPrint(arr.length);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print("  " + arr[i] + "   | ");
		}
		System.out.println();
		dashPrint(arr.length);
		System.out.println();

	}

	public static void main(String[] args) {

		Boxify testBox = new Boxify();
		// testBox.boxify(12);
		// testBox.boxify(12);
		dashPrint(3);

	}

}
