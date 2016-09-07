package kattis;
import java.util.Scanner;

public class reversebinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder binary = new StringBuilder();
		binary.append(Integer.toBinaryString(input.nextInt()));
		binary.reverse();
		String newBinary = binary.toString();
		input.close();
		System.out.println(Integer.parseInt(newBinary, 2));
	}

}