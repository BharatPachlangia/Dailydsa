//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
   // code here
        int large = arr[0];
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(int i = 0; i<arr.length ; i++){
            if(arr[i]>large)
                large = arr[i];
        }
        
        int arr2[] = new int[large + 1];
        
        for(int i = 0; i<arr.length ; i++){
            arr2[arr[i]]++ ; 
        }

        for(int i =0; i<arr2.length; i++){
             if(arr2[i] > 1){
                al.add(i);
            }
        }
        
        if(al.isEmpty())
            al.add(-1);
        
        return al;
    }
}