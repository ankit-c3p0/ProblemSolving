package leetcode;

public class KingsMarch {
	
    public int count(String [][] arrA, int row, int col){
        //base case
        //check if last cell is reached since after that only one path
        if(row==0 && col==0){
            return 1;
        }
        int left =0;
        int up = 0;
        int diagonal=0;
        
        
        if(col!=0 && !arrA[row][col-1].equals("x")){
            left = count(arrA, row, col-1);
        }
        if(row!=0 && !arrA[row-1][col].equals("x")){
            up = count(arrA, row-1, col);
        }
        if(row!=0 && col!=0 && !arrA[row-1][col-1].equals("x")) {
        	diagonal=count(arrA, row-1, col-1);
        }
        return left+up+diagonal;
    }
    
	public static void findBestPath(int [][] matrix)
	{
		int n= matrix[0].length;
		int [][] cost = new int[matrix.length][matrix[0].length];
		int [][][] parent = new int[matrix.length][matrix[0].length][2];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				cost[i][j] = Integer.MIN_VALUE;
				parent[i][j] = new int[2];
			}
		}
		cost[n-1][n-1] = matrix[n-1][n-1];
		
		for(int i = n-1; i > 0; i--)
		{
			for(int j = n-1; j > 0; j--)
			{
				if(i-1 > 0 && cost[i][j] + matrix[i-1][j] > cost[i-1][j])
				{
					cost[i-1][j] = cost[i][j] + matrix[i-1][j] ;
					parent[i-1][j][0] = i;
					parent[i-1][j][1] = j;					
				}
				if(j-1 > 0 && cost[i][j] + matrix[i][j-1] > cost[i][j-1])
				{
					cost[i][j-1] = cost[i][j] + matrix[i][j-1] ;
					parent[i][j-1][0] = i;
					parent[i][j-1][1] = j;					
				}
			}
		}

		System.out.println("Max is " + cost[matrix.length-1][matrix[0].length-1]);
		/*int [] at = parent[matrix.length-1][matrix[0].length-1];
		System.out.print((matrix.length-1) + ":" + (matrix[0].length-1) + "(" + matrix[matrix.length-1][matrix[0].length-1] + "), ");
		while(!(at[0] == 0 && at[1] == 0))
		{
			System.out.print(at[0] + ":" + at[1] + "(" + matrix[at[0]][at[1]] + "), ");
			at = parent[at[0]][at[1]];
		}
		System.out.print(at[0] + ":" + at[1] + "(" + matrix[at[0]][at[1]] + "), ");*/
	}



    public static void main(String[] args) {
		
    	KingsMarch km = new KingsMarch();
    	String[][] arrA = {{"0","2","3"},{"2","0","2"},{"1","2","0"}};
    	int[][] matrix= {{0,2,3},{2,0,2},{1,2,0}};
//    	System.out.println("Total paths:" + km.count(arrA, arrA.length-1, arrA.length-1));
    	findBestPath(matrix);
	}
}
