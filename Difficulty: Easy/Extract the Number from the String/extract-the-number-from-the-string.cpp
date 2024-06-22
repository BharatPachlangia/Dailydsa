//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    long long ExtractNumber(string sentence) {
 stringstream ss(sentence);

        string word; // To store each word/token from the stringstream

        long long ans = -1; // To keep track of the maximum valid number found

 

        // Iterate through each word in the sentence

        while (ss >> word) {

            try {

                // Try to convert the word to a long long integer

                long long temp = stoll(word);

                

                bool f = true; // Flag to check if the number contains the digit '9'

                long long n = temp;

                

                // Check each digit of the number

                while (n > 0) {

                    if (n % 10 == 9) {

                        f = false; // Set the flag to false if the digit '9' is found

                        break; // Exit the loop as we found a '9'

                    }

                    n /= 10; // Remove the last digit from the number

                }

                

                

                if (f) ans = max(ans, temp);

            }

            catch (invalid_argument &e) {

                

                continue;

            }

        }

        

        

        return ans;
    }
};

//{ Driver Code Starts.
int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);

        Solution ob;
        cout << ob.ExtractNumber(s) << "\n";
    }

    return 0;
}

// } Driver Code Ends