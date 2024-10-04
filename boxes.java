/*A warehouse stores boxes of different weights that need to be transported to 
different distribution centers across multiple cities. The boxes are stored in 
the order in which they were manufactured, and they must be transported in 
this specific order. Each day, a truck is sent to pick up a load of boxes from 
the warehouse. However, the truck has a limited carrying capacity based on its 
maximum weight limit.

You are tasked with determining the minimum weight capacity of the truck that 
will allow all the boxes to be shipped in the given number of days without 
violating the order in which the boxes are loaded. Each day, the truck can load
as many boxes as possible without exceeding its weight capacity.

Input Format:
-------------
line-1: two space separated integers, N boxes, and number of days.
line-2: N space separated integers, weights of boxes.

Sample Input-1: 
---------------
5 2
7 2 5 10 8

Sample Output-1:
----------------
18

Explanation:
-------------
A truck capacity of 18 is the minimum to transport all the boxes 
in 2 days as follows:

1st day: 7, 2, 5 (total weight: 14)
2nd day: 10, 8 (total weight: 18)
With a capacity less than 18, it is impossible to ship all the boxes in 
the given number of days without exceeding the truck's weight capacity.


Sample Input-2: 
---------------
8 4
1 5 6 7 3 2 9 4

Sample Output-2:
----------------
12

Explanation:
------------
A truck capacity of 12 is the minimum to transport all the boxes in 4 days as follows:

1st day: 1, 5, 6 (total weight: 12)
2nd day: 7, 3, 2 (total weight: 12)
3rd day: 9 (total weight: 9)
4th day: 4 (total weight: 4)
*/

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt(); // Number of boxes
        int D = scanner.nextInt(); // Number of days
      
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt(); // Weights of the boxes
        }

        // Calculate and display the minimum truck capacity
        int minCapacity = minimumTruckCapacity(weights, D);
        System.out.println( minCapacity);
    }

    static int minimumTruckCapacity(int[] weights, int D) {
        int left = 0;
        int right = 0;

        // Set the minimum capacity to the maximum weight of a single box
        for (int weight : weights) {
            left = Math.max(left, weight); // No capacity can be less than the heaviest box
            right += weight; // Total weight is the maximum capacity
        }

        // Binary search for the minimum feasible capacity
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShipInDays(weights, mid, D)) {
                right = mid; // Try for a smaller capacity
            } else {
                left = mid + 1; // Increase the capacity
            }
        }
        
        return left; // This is the minimum capacity that can ship the boxes
    }

    static boolean canShipInDays(int[] weights, int capacity, int D) {
        int days = 1; // Start with one day
        int currentWeight = 0; // Current weight loaded on the truck

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                days++; // Need a new day
                currentWeight = weight; // Start loading this box in the new day
                if (days > D) {
                    return false; // Exceeded the number of days allowed
                }
            } else {
                currentWeight += weight; // Add box to the current day's load
            }
        }
        
        return true; // Successfully loaded within D days
    }
}
