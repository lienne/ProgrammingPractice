public class MatrixTransform {

	public static int[][] rotate90(int [][] originalMatrix) {
		int rowLen = originalMatrix.length;
		int colLen = originalMatrix[0].length;
		int [][] newMatrix = new int[colLen][rowLen]; // switch rows and columns to transform it 90 degrees

		for(int i = 0; i < colLen; i++) {
			for(int j = rowLen - 1; j >= 0; j--) {
				newMatrix[i][rowLen - (j+1)] = originalMatrix[j][i];
			}
		}

		return newMatrix;
	}

	public static void main(String [] args) {

		int [][] test1 = new int [][] {
			new int [] {0, 1, 2, 3},
			new int [] {4, 5, 6, 7},
		};

		int [][] test2 = new int [][] {
			new int [] {0, 1, 2, 3},
			new int [] {4, 5, 6, 7},
			new int [] {8, 9, 10, 11},
			new int [] {12, 13, 14, 15},
		};

		System.out.println("Test 1: ");
		for(int i = 0; i < test1.length; i++) {
			for(int j = 0; j < test1[0].length; j++) {
				System.out.print(test1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		int [][] rotatedTest1 = rotate90(test1);

		System.out.println("Rotated test 1: ");
		for(int i = 0; i < rotatedTest1.length; i++) {
			for(int j = 0; j < rotatedTest1[0].length; j++) {
				System.out.print(rotatedTest1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Test 2: ");
		for(int i = 0; i < test2.length; i++) {
			for(int j = 0; j < test2[0].length; j++) {
				System.out.print(test2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		int [][] rotatedTest2 = rotate90(test2);

		System.out.println("Rotated test 2: ");
		for(int i = 0; i < rotatedTest2.length; i++) {
			for(int j = 0; j < rotatedTest2[0].length; j++) {
				System.out.print(rotatedTest2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}