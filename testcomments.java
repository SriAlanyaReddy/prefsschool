
/*Imagine you're a lead developer working on a highly sensitive code analysis tool
for a large software development company. One of the core responsibilities of 
this tool is to ensure that code written by the developers is syntactically 
correct before it gets deployed.

One of the most common errors you need to catch involves mismatched or 
incorrectly nested comments in the code, where developers use /* */, //, or */ 
/*block comments using {}. These comments must always be properly closed, and 
block comments cannot overlap in an incorrect order.

Your task is to write a validation function that checks whether the comments 
in the code are properly opened and closed.

/*The rules for valid comments are:
 - A comment started by /* must be closed with */.
 /*- A block comment opened by { must be closed with }.
 - If a comment or block is opened, it must be properly closed before another 
   of the same type is opened (no overlapping).*/

/*Given a string s that represents a piece of code containing only comment 
delimiters /* */, //, and { }, determine if the string has valid comments.
/*Print true if all the comments and block statements in the code are valid, 
and false otherwise.*/

/*Input Format:
-------------
/*A string S, containing only the characters representing comments and blocks: 
              /* /*, */, /*{, }, and any additional surrounding code.*/

/*Output Format:
--------------
Boolean value.*/


/*Sample Input-1:
---------------
{ /* comment */ // Single line comment }*/

Sample Output-1:
----------------
true


Sample Input-2:
---------------
{ /* Start of comment block } */

Sample Output-2:
----------------
false

'''
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(testparenthesis(s));
    }
    public static boolean  testparenthesis(String s){
        Stack<String>st=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='{'){
                st.push("{");
                i++;
            }
            else if(s.charAt(i)=='}'){
                if(st.isEmpty() || !st.peek().equals("{")){
                    return false;
                }
                st.pop();
                i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='/' && s.charAt(i+1)=='*'){
                st.push("/*");
                i++;
            }
            else if(s.charAt(i)=='*' && s.charAt(i+1)=='/' && i<s.length()-1){
                    if(st.isEmpty() || !st.peek().equals("/*")){
                        return false;
                    }
                    st.pop();
                    i+=2;
            }
            else if(s.charAt(i)=='/' && s.charAt(i+1)=='/' && i<s.length()-1){
                i+=2;
                
            }
            else{
                i++;
            }
        }
        return st.isEmpty();
    }
}
