//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int count=0;
        int sum=0;
        int len=arr.length;
        for(int i=0;i<len-2;i++)
        {
            for(int j=i+1;j<len-1;j++)
            {
                int s=j;
                int e=len-1;
                while(e>s)
                {
                 sum=arr[i]+arr[s];
                    if(sum>arr[e])
                    {// Since Array is sorted you get the first triangle the you can simple add the difference
                    // beacuse you get only small integer after that
                     count+=e-j;
                     break;
                    }
                    else if(arr[e]>=sum)
                    {
                     e--;
                    }
                }
            }
        }
        return count;
    }
}