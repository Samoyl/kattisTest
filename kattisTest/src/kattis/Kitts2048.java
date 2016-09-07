package kattis;

import java.util.Scanner;

public class Kitts2048 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int[][] puzzelArray = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				puzzelArray[i][j] = input.nextInt();
			}
		}
		int direction = input.nextInt();
		if (direction == 0) {
			// go Left
			puzzelArray = goLeft(goLeft(addLeft(goLeft(goLeft(goLeft(puzzelArray))))));
			print(puzzelArray);
		} else if (direction == 1) {
			// Up
			puzzelArray = goUp(goUp(addUp(goUp(goUp(goUp(puzzelArray))))));
			print(puzzelArray);
		} else if (direction == 2) {
			// Right
			puzzelArray = goRight(goRight(addRight(goRight(goRight(goRight(puzzelArray))))));
			print(puzzelArray);
		} else if (direction == 3) {
			// Down
			puzzelArray = goDown(goDown(addDown(goDown(goDown(goDown(puzzelArray))))));
			print(puzzelArray);
		}
	}

	public static void print(int[][] puzzelArray) {
		for (int o[] : puzzelArray) {
			for (int y : o) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
	// move all numbers to the left to fill in space left by 0's
	public static int[][] goLeft(int[][] input) {
		 for (int i = 0; i < 4; i++){
		        for (int j = 0; j < 3; j++){
		          if (input[i][2-j] == 0){
		            input[i][2-j] = input[i][3-j];
		            input[i][3-j] = 0;
		          }
		        }
		      }
		return input;
	}

	 // add all numbers that match when moving to the left
    public static int[][] addLeft(int[][] input){
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 3; j++){
          if (input[i][j] == input[i][j+1]){
            input[i][j] = input[i][j+1]*2;
            input[i][j+1] = 0;
          }
        }
      }
      return input;
    }

	 // move all numbers to the right to fill in space left by 0's
	public static int[][] goRight(int[][] input) {
		 for (int i = 0; i < 4; i++){
		        for (int j = 0; j < 3; j++){
		          if (input[i][j+1] == 0){
		            input[i][j+1] = input[i][j];
		            input[i][j] = 0;
		          }
		        }
		      }
		return input;
	}

	 // add all numbers that match when moving to the right
    public static int[][] addRight(int[][] input){
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 3; j++){
          if (input[i][3-j] == input[i][2-j]){
            input[i][3-j] = input[i][2-j]*2;
            input[i][2-j] = 0;
          }
        }
      }
      return input;
    }

 // move all numbers down to fill in space left by 0's
	public static int[][] goDown(int[][] input) {
		 for (int i = 0; i < 4; i++){
		        for (int j = 0; j < 3; j++){
		          if (input[3-j][i] == 0){
		            input[3-j][i] = input[2-j][i];
		            input[2-j][i] = 0;
		          }
		        }
		      }
		return input;
	}

	 // add all numbers that match when moving down
    public static int[][] addDown(int[][] input){
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 3; j++){
          if (input[2-j][i] == input[3-j][i]){
            input[3-j][i] = input[2-j][i]*2;
            input[2-j][i] = 0;
          }
        }
      }
      return input;
    }


 // move all numbers up to fill in space left by 0's
    public static int[][] goUp(int[][] input){
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 3; j++){
          if (input[2-j][i] == 0){
            input[2-j][i] = input[3-j][i];
            input[3-j][i] = 0;
          }
        }
      }
      return input;
    }

    // add all numbers that match when moving up
    public static int[][] addUp(int[][] input){
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 3; j++){
          if (input[j][i] == input[j+1][i]){
            input[j][i] = input[j+1][i]*2;
            input[j+1][i] = 0;
          }
        }
      }
      return input;
    }
}
