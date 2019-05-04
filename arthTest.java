
public class arthTest {
	static int a = 20;
	static double b = 100;

	static int returnFive() {
		return 5;
	}

	static int returnTen() {
		return 10;
	}

	static int returnPercent() {
		int nominator = returnFive();
		int denominator = returnTen();

		return (int) ((nominator / (double) denominator) * 100);
	}

	public static void main(String[] args) {
		int testRet = returnPercent();
		System.out.println("------result is:-------");
		System.out.println(testRet);
		System.out.println("------result ^^-------");

		System.out.println((int) ((10 / (double) 100) * 100));
		System.out.println(((double) a / b) * 100);

		// System.out.println(d);

	}

}
