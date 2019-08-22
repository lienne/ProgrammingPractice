public class Main{

     public static void main(String []args){
         int [][] grid = {
             {3,0,8,4},
             {2,4,5,7},
             {9,2,6,3},
             {0,3,1,0},
         };

        // Top skyline: 
		// 9 4 8 7
        // Side skyline: 
		// 8 7 9 3

         System.out.println("The grid's length is " + grid.length);
         System.out.println();
         
         for(int i = 0; i < grid.length; i++) {
           for(int j = 0; j < grid.length; j++) {
             System.out.print(grid[i][j] + " ");
           }
           System.out.println();
         }
         
         System.out.println();

         int k = maxIncreaseKeepingSkyline(grid);
     }
     
     public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int [] topSkyLine = new int [grid.length];
        int [] sideSkyLine = new int [grid.length];
        
        int maxInRow = 0;
        int maxInCol = 0;
        
        // Find side skyline
        // Comparisons:
        // grid[0][0] to grid[0][1] to grid[0][2] to grid[0][3]
        // grid[1][0] to grid[1][1] to grid[1][2] to grid[1][3]
        // grid[2][0] to grid[2][1] to grid[2][2] to grid[2][3]
        // grid[3][0] to grid[3][1] to grid[3][2] to grid[3][3]
        // Hold row constant

        // Find top skyline
        // Comparisons:
        // grid[0][0] to grid[1][0] to grid[2][0] to grid[3][0]
        // grid[0][1] to grid[1][1] to grid[2][1] to grid[3][1]
        // grid[0][2] to grid[1][2] to grid[2][2] to grid[3][2]
        // grid[0][3] to grid[1][3] to grid[2][3] to grid[3][3]
        // Hold column constant

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid.length; col++) {
                if(grid[row][col] > maxInRow) {
                    maxInRow = grid[row][col];
                }

                if(grid[col][row] > maxInCol) {
        			maxInCol = grid[col][row];
        		}
            }
            sideSkyLine[row] = maxInRow;
            maxInRow = 0;

            topSkyLine[row] = maxInCol;
        	maxInCol = 0;
        }

        System.out.println("Side skyline: ");
        for(int i = 0; i < sideSkyLine.length; i++) {
          System.out.print(sideSkyLine[i] + " ");
        }
        System.out.println();

        System.out.println("Top skyline: ");
        for(int i = 0; i < topSkyLine.length; i++) {
        	System.out.print(topSkyLine[i] + " ");
        }
        System.out.println();
        System.out.println();

        int maxIncrease = 0;

        // Old grid:
        //
        // 3 0 8 4
        // 2 4 5 7
        // 9 2 6 3
        // 0 3 1 0
        //
        // Side skyline: 
		// 8 7 9 3
        // Top skyline: 
		// 9 4 8 7

        for(int i = 0; i < sideSkyLine.length; i++) {
    		for(int j = 0; j < topSkyLine.length; j++) {
        		if(sideSkyLine[i] < topSkyLine[j]) {
            		// grid[i][j] = sideSkyLine[i];
            		maxIncrease = maxIncrease + (sideSkyLine[i] - grid[i][j]);
            		System.out.println("Max increase at pass [" + i + "][" + j +"] is: " + maxIncrease);
        		}
        		else {
            		// grid[i][j] = topSkyLine[j];
            		maxIncrease += (topSkyLine[j] - grid[i][j]);
            		System.out.println("Max increase at pass [" + i + "][" + j +"] is: " + maxIncrease);
        		}
        	}
		}
		System.out.println();

		// Should print:
		// New grid: 
		// 8 4 8 7 
		// 7 4 7 7 
		// 9 4 8 7 
		// 3 3 3 3 


		System.out.println("New grid: ");
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
            	System.out.print(grid[i][j] + " ");
			}
        	System.out.println();
        }
         
        System.out.println();

        System.out.println("Total increase is: " + maxIncrease);



        return 0;
    }
}