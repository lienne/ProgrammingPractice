import java.util.*;

public class MaxSubarray {

    // First, try to return the max sum alone - O(n^2)
    public static int maxSum(int[] array) {
        if (array.length == 1)
            return array[0];

        int maxSum = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            int currSum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                currSum = currSum + array[j];

                if (array[i] > array[j] && array[i] > maxSum) {
                    maxSum = array[i];
                }

                if (array[j] > array[i] && array[j] > maxSum) {
                    maxSum = array[j];
                }

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    // Then return the actual subarray - O(n^2)
    public static int[] maxSubarraySum(int[] array) {
        if (array.length == 1)
            return array;

        int maxSum = array[0];

        int firstIndex = 0, lastIndex = 0, len = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int currSum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                currSum = currSum + array[j];

                if (currSum > maxSum) {
                    maxSum = currSum;
                    firstIndex = i;
                    lastIndex = j;
                    len = lastIndex - firstIndex + 1;
                }
            }
        }

        int[] maxSubarray = new int[len];

        for (int k = 0; k < len; k++) {
            maxSubarray[k] = array[firstIndex];
            firstIndex++;
        }

        return maxSubarray;
    }

    // Recursive approach - Divide and Conquer
    // Complexity: O(nlogn)
    public static int divideAndConquer(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        // Array contains only one element, so return that element
        if (left == right)
            return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private static int crossSum(int[] nums, int left, int right, int p) {
        if (left == right)
            return nums[left];

        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum, currSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;

        for (int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum, currSum);
        }

        return leftSubSum + rightSubSum;
    }

    // Greedy approach - O(n)
    public static int greedy(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static int greedyExplained(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];

        // currSum keeps track of the start of the subarray.
        // If the current element is greater than the currSum, set
        // currSum equal to that element, which marks the start of
        // a new subarray.
        // Then it keeps adding the next elements to the currSum,
        // until it either finds an element bigger than currSum,
        // or finishes iterating thru the array.
        for (int i = 1; i < nums.length; i++) {

            // You are comparing nums[i] to currSum + nums[i]
            // You are NOT comparing currSum to something at all!
            // You are ALWAYS replacing currSum.
            // currSum = nums[i] > (currSum + nums[i]) ? nums[i] : (currSum + nums[i]);
            currSum = (currSum < 0) ? nums[i] : (currSum + nums[i]);

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] testCase1 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] testCase2 = new int[] { -2, 1, 2 };
        int[] testCase3 = new int[] { -2, -1 };

        // int[] maxSubarray = maxSubarraySum(testCase1);

        // should return [4, -1, 2, 1]
        // System.out.print("[ ");
        // for (int i = 0; i < maxSubarray.length - 1; i++) {
        // System.out.print(maxSubarray[i] + ", ");
        // }
        // System.out.println(maxSubarray[maxSubarray.length - 1] + " ]");

        // should return 6
        int maxSum0 = greedyExplained(testCase1);
        System.out.println(maxSum0);

        // should return 3
        int maxSum = greedyExplained(testCase2);
        System.out.println(maxSum);

        // should print out -1
        int maxSum2 = greedyExplained(testCase3);
        System.out.println(maxSum2);
    }

    /*
     * Test Case 1: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
     * 
     */
}