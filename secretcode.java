/*In a futuristic virtual reality (VR) game world, players are provided with custom VR keypads that are similar to modern American keyboards but have some restrictions. The keypad is divided into three distinct zones, and each zone contains specific letters that the player can use for a task.
	- Zone 1: Letters on the top row: "qwertyuiop"
	- Zone 2: Letters on the middle row: "asdfghjkl"
	- Zone 3: Letters on the bottom row: "zxcvbnm"

Players are given a set of secret codes (words), and they must type these codes using only letters from one zone at a time. If a word uses letters from more than one zone, it will be considered invalid and cannot be typed.

Your task is to help the players by filtering out the valid secret codes (words) that can be typed using letters from only one zone.

Given a list of secret codes (words), return the codes that can be typed using letters from only one zone of the VR keypad.

Constraints:
------------
1 ≤ secretCodes.length ≤ 20
1 ≤ secretCodes[i].length ≤ 100
secretCodes[i] consists of English letters (both lowercase and uppercase).

Input Format:
-------------
Space separated words, secretCodes[]

Output Format:
--------------
A list of codes that can be typed using letters from only one zone.


Sample Input-1:
---------------
Galaxy Mars Venus Sky

Sample Output-1:
----------------
["Mars", "Sky"]

Explanation:
------------
"Mars" can be typed using only Zone 2.
"Sky" can be typed using only Zone 3.
"Galaxy" and "Venus" use letters from multiple zones and are thus invalid.


Sample Input-2:
---------------
keyboard monkey

Sample Output-2:
----------------
[]

Explanation:
------------
None of the words can be typed using letters from only one zone.


Sample Input-3:
---------------
qw er ty

Sample Output-3:
----------------
["qw", "er", "ty"]

Explanation:
------------
All the codes can be typed using only letters from Zone 1.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        String[] secretCodes = sc.nextLine().split(" ");
        String[] ans = codetesting(secretCodes); 
        
       
        System.out.println(Arrays.toString(ans));
        
    }
    public static String[] codetesting(String[] s){
        String s1="qwertyuiop";
        String s2= "asdfghjkl";
	    String s3="zxcvbnm";
	    List<String>ans=new ArrayList<>();
	    int n=s.length;
	    
	    for(int i=0;i<n;i++){
	        String req=s[i].toLowerCase();
	        int fc=0,sc=0,tc=0;
	        for(int j=0;j<req.length();j++){
	            char ch=req.charAt(j);
	        if(s1.contains(Character.toString(ch))){
	            fc++;
	        }
	        if(s2.contains(Character.toString(ch))){
	            sc++;
	        }
	        if(s3.contains(Character.toString(ch))){
	            tc++;
	        }
	    }
	    if(fc==req.length() || sc==req.length() || tc==req.length()){
	        ans.add(req);
	    }
	    }
	    return ans.toArray(new String[0]);
	    }
    
}
