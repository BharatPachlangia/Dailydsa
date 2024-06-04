//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
         // code here.
        char ch[]=s.toCharArray();
        int carry=1;
        for(int idx=ch.length-1;idx>=0;idx--){
            int sum=ch[idx]-'0'+carry;
            ch[idx]=(char)(sum%2+'0');
            carry=sum/2;
        }
        String ans=new String(ch);
        if(carry==1){
            ans="1"+ans;
        }
        while(ans.charAt(0)=='0'){
            ans=ans.substring(1);
        }
        return ans;
    }
}