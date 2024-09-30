/**You are developing a customer management system for an international
telecom company. The system accepts phone numbers from users in 
specific formats based on their location. The system must validate 
whether the phone numbers entered conform to the required formats 
before they can be stored in the company's database.

The company operates in two regions with different phone number 
conventions:

	- India: Phone numbers must follow the format +91 xxxxx xxxxx, 
	where: The phone number starts with the country code +91.
		   The next part consists of two groups of 5 digits each, 
		   separated by a space.
	- Other regions: For certain regions, phone numbers must follow 
	the format 0xx-xxxx-xxxx, where: The phone number starts with a 0, 
	followed by a 3-digit area code. The next part consists of two 
	groups of 4 digits each, separated by hyphens.

The user can enter N phone numbers, and the system will validate 
each one according to the rules for the two formats mentioned above. 
If a phone number is valid, it will be added to the list; 
if it is invalid, it will be ignored.

Input Format:
-------------
Line-1: An integer N, number of phone numbers.
Next N lines: a phone number, per line.

Output Format:
--------------
List of valid phone numbers.


Sample Input:
-------------
+91 98765 43210
+91 9876543210
012-3456-7890
01-2345-67890
+91 321 456 7890

Sample Output:
--------------
[+91 98765 43210, 012-3456-7890]**/
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int N = Integer.parseInt(sc.nextLine());
        
        // Define regex for Indian and other region formats
        String regexForIndian = "^\\+91\\s[0-9]{5}\\s[0-9]{5}$";
        String regexForOthers = "^0[0-9]{2}-[0-9]{4}-[0-9]{4}$";
    
        Pattern patternIndian = Pattern.compile(regexForIndian);
        Pattern patternOthers = Pattern.compile(regexForOthers);
       
        List<String> validNumbers = new ArrayList<>();
        
       
        for (int i = 0; i < N; i++) {
            String phoneNumber = sc.nextLine();
            
            Matcher matcherIndian = patternIndian.matcher(phoneNumber);
            Matcher matcherOthers = patternOthers.matcher(phoneNumber);
           
            if (matcherIndian.matches() || matcherOthers.matches()) {
                validNumbers.add(phoneNumber);
            }
        }
        
      
        System.out.println(validNumbers);
    }
}
