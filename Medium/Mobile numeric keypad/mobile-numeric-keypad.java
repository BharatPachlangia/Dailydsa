//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
       int k=1;
        int a[][]=new int[4][3];
        long dp[][]=new long[10][n+1];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                
                if(i!=3){a[i][j]=k;
                    k++;
                }else if(i==3&&j==1){a[i][j]=0;}
                else{
                    a[i][j]=-1;
                }
            }
        }
        long ans=0;
        for(int i=0;i<10;i++){
            Arrays.fill(dp[i],-1);
        }
       for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
              //  System.out.print(a[i][j]);
            ans+=trav(a,i,j,dp,n);
            }
            // System.out.println("");
       }
            return ans;
        
        
    }
    public long trav(int a[][],int i,int j,long dp[][],int k){
    if(i<0||j<0||i>=4||j>=3||a[i][j]==-1)return 0;
        if(k==1)return 1;
        
        if(dp[a[i][j]][k]!=-1)return dp[a[i][j]][k];
      long ans=trav(a,i,j,dp,k-1);
        
        ans+=trav(a,i+1,j,dp,k-1);
         ans+=trav(a,i-1,j,dp,k-1);
          ans+=trav(a,i,j+1,dp,k-1);
           ans+=trav(a,i,j-1,dp,k-1);
           
           return dp[a[i][j]][k]=ans;
    }
}