package kattis;

import java.io.IOException;
import java.util.Scanner;

public class pebblesolitaire2 {

	static int Max = 1 << 23;
	static int TestCases;
	static int[] DPMemo = new int[Max];
	static Scanner Input = new Scanner(System.in);
	static int Counter;
	static String Text;

	public static void main(String args[]) throws IOException {
		TestCases = Input.nextInt();
		while (TestCases-- > 0) {
			Counter = 0;
			Text = Input.next();
			for (int i = 0; i < Text.length(); i++) {
				if (Text.charAt(i) == 'o') {
					Counter |= (1 << i);
				}
			}
			System.out.printf("\n" + Solve(Counter));
		}
		Input.close();
	}

	private static int Solve(int Mask) {

		int counter = 0;

		for (int i = 0; i < 23; i++) {
			if ((Mask & (1 << i)) != 0)
				counter++;
		}
		for (int i = 0; i < 23; i++) {
			if (i >= 2 && ((Mask ^ (3 << (i - 2))) & (7 << (i - 2))) == 0)
				counter = Math.min(counter, Solve(Mask ^ (7 << (i - 2))));
			if (i <= 9 && ((Mask ^ (6 << (i))) & (7 << (i))) == 0)
				counter = Math.min(counter, Solve(Mask ^ (7 << i)));
		}
		return DPMemo[Mask] = counter;
	}

}