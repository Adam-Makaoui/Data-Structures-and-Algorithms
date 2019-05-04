import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileReading {

	public static void main(String[] args) throws IOException {

		// Openong the file contents and allowing for reading
		// FileReader file = new FileReader(args[0]);
		BufferedReader input = new BufferedReader(new FileReader(args[0]));

		// Reads an entire line in a text file
		String digitHolderLine = input.readLine();
		// digitHolderLine.
		System.out.println("Below is the contents of the file :");
		System.out.println(digitHolderLine);

		// regex '\\W' matches and splits any non word character
		String[] digitArray = digitHolderLine.split("\\W");

		System.out.print("Printing first 5 index of the (array of the file) --> ");
		System.out.print(digitArray[0]);
		System.out.print(digitArray[1]);
		System.out.print(digitArray[2]);
		System.out.print(digitArray[3]);
		System.out.println(digitArray[4]);

		int i;
		int result = 0;
		for (i = 0; i < digitArray.length; i++) {
			result = result + Integer.parseInt(digitArray[i]);
		}
		System.out.printf("The result of the summation of the lenth is %d\n", result);

		System.out.print("The length (number of stuff) of the file :");
		System.out.println(digitArray.length);

	}
}
