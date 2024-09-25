package DataStructures.Graph.LeetCodes;

import java.util.Arrays;

/*https://leetcode.com/problems/number-of-islands/description/*/
public class Islands {

    public static int numIslands(char[][] grid) throws InterruptedException {
       int noOfIslands = 0, m = grid.length, n= grid[0].length;

       for (int i=0;i< m;i++){
           for (int j=0;j<n;j++) {
               if (grid[i][j] == '1'){
                   noOfIslands++;
                   mapIsland(grid,i,j,m,n);
               }
           }
       }

       return noOfIslands;
    }

    private static void mapIsland(char[][] grid,int i, int j, int m, int n) throws InterruptedException {
        if (i<m && j<n && grid[i][j] == '1') {
            grid[i][j] = 'X';
            for(int k=0;k<m;k++) {
                System.out.println(Arrays.toString(grid[k]));
            }
            System.out.println("-----------------");
            Thread.sleep(1000);
            mapIsland(grid,i,j+1,m,n);
            System.out.println("i "+ i+" j "+ j);
            mapIsland(grid,i+1,j,m,n);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};

        System.out.println("no of islands "+ numIslands(grid));

        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println("no of islands "+ numIslands(grid1));
    }
}
