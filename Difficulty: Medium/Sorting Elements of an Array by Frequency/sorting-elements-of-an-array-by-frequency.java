//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Find the maximum element to determine the size of the frequency array
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        
        // Initialize a frequency array
        int[][] temp = new int[max + 1][2];  // [element, frequency]
        for (int i = 0; i < max + 1; i++) {
            temp[i][0] = i;  // Store the element itself
            temp[i][1] = 0;  // Initialize frequency to 0
        }
        
        // Count frequencies of each element
        for (int e : arr) {
            temp[e][1]++;
        }
        
        // Sort the temp array by frequency, and by element value for ties
        Arrays.sort(temp, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];  // If frequencies are the same, sort by element value
            } else {
                return b[1] - a[1];  // Sort by frequency in descending order
            }
        });
        
        // Create the result array list
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Populate the result list based on sorted frequencies
        for (int i = 0; i < temp.length; i++) {
            int element = temp[i][0];
            int frequency = temp[i][1];
            while (frequency-- > 0) {
                ans.add(element);  // Add the element 'frequency' times
            }
        }
        
        return ans;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends