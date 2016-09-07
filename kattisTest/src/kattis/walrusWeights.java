package kattis;

import java.util.*;

public class walrusWeights {

	public static boolean checkValue = true;

	public static void checkArray(int num, ArrayList<Integer> array) {
		for (int i : array) {
			if (num == i) {
				checkValue = false;
				break;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> weights = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int distance = 0;
		int distance2 = 0;
		int idx = 0;
		int idz = 0;

		for (int i = input.nextInt(); i > 0; i--) {
			int inputNumber = input.nextInt();
			if (weights.size() > 1) {
				checkArray(inputNumber, weights);
			}
			while (checkValue) {
				weights.add(inputNumber);
				checkValue = false;
			}
			checkValue = true;
			int s = weights.size();
			if (s > 1) {

				for (int x = 0; x < s; x++) {
					int addition = 0;
					int arrayNumber = weights.get(x);
					if (inputNumber != arrayNumber) {
						addition = inputNumber + arrayNumber;
					}

					if (addition <= weights.get(weights.size() - 1)) {
						checkArray(addition, weights);
					}
					while (checkValue) {
						weights.add(addition);
						checkValue = false;
					}
					checkValue = true;
				}

			}

		}
		input.close();
		Collections.sort(weights);
		distance = Math.abs(weights.get(0) - 1000);
		for (int c = 1; c < weights.size(); c++) {
			int cdistance = Math.abs(weights.get(c) - 1000);
			if (cdistance < distance) {
				idx = c;
				distance = cdistance;
			} else if (cdistance == distance) {
				idz = c;
				distance = distance2;
			}

		}
		if (distance == distance2 && weights.get(idz) > weights.get(idx)) {
			System.out.println(weights.get(idz));
		} else {
			System.out.println(weights.get(idx));
		}
	}
}
