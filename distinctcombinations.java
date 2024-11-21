/*There are some cubes, and each cube has an alphabet (from A to Z) 
printed on it. You can construct different, non-empty words using these 
cubes and each of the word length should be 0 < length <= number of cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89
*/

import java.util.*;

public class Solution {

    // Backtracking method to calculate the result
    public static void backtrack(Map<Character, Integer> mp, int[] res) {
        res[0]++; // Increment the result
        
        // Iterate over each entry in the map
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            char x = entry.getKey();
            int y = entry.getValue();
            
            // If the count of the character is not zero
            if (y != 0) {
                mp.put(x, y - 1); // Decrease the count for this character
                backtrack(mp, res); // Recurse
                mp.put(x, y); // Restore the count for backtracking
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); // Input string
        
        // Map to store the frequency of characters
        Map<Character, Integer> mp = new HashMap<>();
        
        // Fill the map with character frequencies
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        
        // Result variable (using an array to pass by reference)
        int[] res = {0};
        
        // Start backtracking
        backtrack(mp, res);
        
        // Print the result (subtracting 1 to exclude the initial state)
        System.out.println(res[0] - 1);
        
        sc.close();
    }
}
