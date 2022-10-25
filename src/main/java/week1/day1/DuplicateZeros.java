package week1.day1;

import org.testng.annotations.Test;

import java.util.Arrays;

public class DuplicateZeros {

    //https://leetcode.com/problems/duplicate-zeros/


    /**
     * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
     *
     * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [1,0,2,3,0,4,5,0]
     * Output: [1,0,0,2,3,0,0,4]
     * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
     * Example 2:
     *
     * Input: arr = [1,2,3]
     * Output: [1,2,3]
     * Explanation: After calling your function, the input array is modified to: [1,2,3]
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 104
     * 0 <= arr[i] <= 9
     * @param arr
     */

    @Test
    public void eg1(){
        int[] arr = {1,0,2,3,0,4,5,0};
        //duplicateZerosBruteForce(arr);
        duplicateZerosInPlace(arr);
    }

    //Brute Force Solution
    /*
    1. Create a new array with the same size as that of the input array
    2. Create a counter variable and initialize it as 0
    3. Iterate through the input array
    4. Check if counter is > length of array, if yes, break
    5. Check for current element in the array
        Non Zero => Add element to the output array and iterate
        Zero     => Increment counter,
                    check if counter > len, if yes break, if not increment counter to fill curr & next position with zero
    6. Reset counter to 0, iterate through output array and fill input array with output array values
     */


    /**
     *
     * @param arr
     * @return => void
     */
    private void duplicateZerosBruteForce(int[] arr){
        int[] output = new int[arr.length];
        int counter=0;

        for (int i=0;i<arr.length;i++){
            if(counter==arr.length) break;
            if(arr[i]==0){
                counter++;
                if(counter==arr.length) break;
                counter++;
            }
            else if(arr[i]!=0) output[counter++]=arr[i];
        }

        counter=0;
        for (int val: output) {
            arr[counter++]=val;
        }

        System.out.println(Arrays.toString(arr));
    }



    public void duplicateZerosInPlace(int[] A) {

        int n = A.length, count = 0;

        for (int num : A) if (num == 0) count++;
        int i = n - 1;
        int write = n + count - 1;

        while (i >= 0 && write >= 0)  {

            if (A[i] != 0) { // Non-zero, just write it in
                if (write < n) A[write] = A[i];

            } else { // Zero found, write it in twice if we can
                if (write < n) A[write] = A[i];
                write--;
                if (write < n) A[write] = A[i];
            }

            i--;
            write--;
        }

        System.out.println(Arrays.toString(A));
    }
}
