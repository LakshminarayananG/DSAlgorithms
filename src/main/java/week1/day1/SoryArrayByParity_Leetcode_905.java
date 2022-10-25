package week1.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoryArrayByParity_Leetcode_905 {

    //https://leetcode.com/problems/sort-array-by-parity/

    /*
    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
     */

    @Test
    public void eg1() {
        int[] arr = {3, 1, 2, 4};  //Exp. output = {2,4,3,1}
        Assert.assertEquals(new int[]{2, 4, 3, 1}, soryByParity(arr));
    }

    @Test
    public void eg2() {
        int[] arr = {0};
        Assert.assertEquals(new int[]{0}, soryByParity(arr));
    }


    // Pseudo code
    /*

    1. Declare an output array of the same size as input array
    2. Declare counter variable
    3. User 2 for loops, first for loop to add even integers and 2nd loop to add odd integers
    4. Return resultant array

    Time complexity => O(n)+O(n) => O(n)
     */

    private int[] soryByParity(int[] arr) {
        int[] output = new int[arr.length];
        int count = 0;

        for (int i = 0; i < output.length; i++) {
            if (arr[i] % 2 == 0) output[count++] = arr[i];
        }

        for (int j = 0; j < output.length; j++) {
            if (arr[j] % 2 == 1) output[count++] = arr[j];
        }

        return output;

    }
}
