//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int prefixSum = 0;
        int maxLength = 0;

        // HashMap to store the first occurrence of prefix sums
        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Update the prefix sum
            prefixSum += arr[i];

            // Case 1: If prefix sum itself is equal to k
            if (prefixSum == k) {
                maxLength = i + 1; // Subarray starts from index 0
            }

            // Case 2: Check if (prefixSum - k) exists in the map
            if (prefixMap.containsKey(prefixSum - k)) {
                int subarrayLength = i - prefixMap.get(prefixSum - k);
                maxLength = Math.max(maxLength, subarrayLength);
            }

            // Case 3: Store the first occurrence of the prefix sum
            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}