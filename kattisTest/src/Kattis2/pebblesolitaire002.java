package Kattis2;

import java.util.Scanner;

public class pebblesolitaire002 {

	public static void main(String[] args) {
		Scanner inpute = new Scanner(System.in);
		int testCases = inpute.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			int count = 0;
			boolean loop = true;
			StringBuilder text = new StringBuilder(inpute.next());
			while (loop) {
				for (int s = 0; s < text.length(); s++) {
					if (s + 2 < text.length() && text.charAt(s) == 'o' && text.charAt(s + 1) == 'o'
							&& text.charAt(s + 2) == '-') {
						text.setCharAt(s, '-');
						text.setCharAt(s + 1, '-');
						text.setCharAt(s + 2, 'o');
						count++;
					} else if(s+2 < text.length() && text.charAt(s) == '-' && text.charAt(s + 1) == 'o'
							&& text.charAt(s + 2) == 'o'){
						text.setCharAt(s, 'o');
						text.setCharAt(s + 1, '-');
						text.setCharAt(s + 2, '-');
						count++;
					} else {
						for (int c = text.length() - 1; c > 0; c--) {
							if (c - 2 > 0 && text.charAt(c) == 'o' && text.charAt(c - 1) == 'o'
									&& text.charAt(c - 2) == '-') {
								text.setCharAt(c, '-');
								text.setCharAt(c - 1, '-');
								text.setCharAt(c - 2, 'o');
								count++;
							}
						}
					}
				}


				if (count == 0) {
					loop = false;
					count = 0;
				} else {
					count = 0;
				}
			}
			for (int x = 0; x < text.length(); x++) {
				if (text.charAt(x) == 'o') {
					count++;
				}
			}
			System.out.println(count);
			
		}
		
		inpute.close();
	}

}
