//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long total=1;
        boolean flag=false;
        int zeroc=0;
        for(int i:nums){
            if(i==0){
                flag=true;
                zeroc++;
                continue;
            }
            total*=i;
        }
        long[] arr=new long[nums.length];
        int ind=0;
        if(flag==false){
        for(int i:nums){
            arr[ind++]=total/i;
        }
        return arr;
        }
        else{
            for(int i:nums){
                if(i==0){
                    if(zeroc==1){
                        // System.out.println(total +" "+nums.length-1);
                        arr[ind++]=total;
                    }
                    else{
                        arr[ind++]=0;
                    }
                        
                }
                else{
                    arr[ind++]=0;
                }
            }
        }
        return arr;
    }
}
