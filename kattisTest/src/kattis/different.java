package kattis;

import java.util.Scanner;

public class different {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLong()) {
			System.out.println(Math.abs(input.nextLong() - input.nextLong()));
		}
		input.close();
	}

}
