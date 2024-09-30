/**Given a m x n matrix temperatureGrid representing the recorded 
temperatures in a region over several days. The matrix is sorted 
in non-increasing order both row-wise and column-wise, meaning 
the temperatures are getting colder as you move right or down. 
Each temperature is recorded in degrees Celsius.

You are tasked with determining the number of freezing temperature 
readings in the grid. In this case, a freezing temperature is 
defined as any temperature less than 0°C.

Constraints:
------------
m == temperatureGrid.length
n == temperatureGrid[i].length
1 <= m, n <= 100
-100 <= temperatureGrid[i][j] <= 100


Input Format:
-------------
Line-1: two space separated integers, M and N
Next M lines : N space separated integers, temperatures grid.

Output Format:
-------------
An integer, number of freezing temperatures


Sample Input-1:
---------------
4 4
10 5 2 -1
7 3 0 -2
5 2 -2 -4
2 -1 -3 -6

Sample Output-1:
----------------
7

Explanation:
------------
There are 7 freezing temperatures (< 0°C) in the matrix: 
-1, -2, -2, -4, -1, -3, -6.

Sample Input-2:
---------------
1 3
12 95 4

Sample Output-2: 
----------------
0

Explanation:
------------
There are no freezing temperatures in the matrix.
**/

import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
      
        int[][] temperatureGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temperatureGrid[i][j] = sc.nextInt();
            }
        }
        
       
        int result = countTemperatures(temperatureGrid);
        Sytem.out.println(result);
    }
    public static int countTemperatures(int[][] b){
        int m=b.length;
        int n=b[0].length;
        int c=0;
        int row=0;
        int col=b[0].length-1;
        while(row<=m && col>=0){
            if(b[row][col]<0){
                c+=m-row;
                col--;
                
            }
            else{
                row++;
            }
        }
        return c;
    }
}
