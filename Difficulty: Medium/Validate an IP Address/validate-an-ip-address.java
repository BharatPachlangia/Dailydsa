//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
         int i=0;int n=str.length();int dotcount=0;
        if(str.charAt(0)=='.')return false;
        
        while(i<n){
            String temp="";
            while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9'){
                // digit=digit*10+str.charAt(i)-'0';
                temp+=str.charAt(i);
                i++;
            }
            
            if(temp.length()>1 && temp.charAt(0)=='0')return false; // case for leading 0's like 01.01.01.01
            int digit=Integer.parseInt(temp);  
            if(digit>255)return false;
            
            if(i<n && i+1<n){
                if(str.charAt(i)=='.' && str.charAt(i+1)=='.'){ // case for consecutive dots eg: 234...94
                    return false;
                }else if(str.charAt(i)=='.'){
                    dotcount++;
                }
            }
            i++;
        }
        
        return dotcount==3?true:false;
    }
}