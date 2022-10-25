package algorithms.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoSum {

    // I/p as an array, find whether sum of any two items in an array that matches the target input

    @Test
    public void eg1(){
        // Positive Input
        int[] arr = {2,4,5,8,3,6,7};
        int target = 7;
        Assert.assertEquals(new int[]{0,2},twoSumBruteForce(arr,target));
    }

    @Test
    public void eg2()
    { // No matching input
        int[] arr = {2,4,5,8,3,6,7};
        int target = 16;
        Assert.assertEquals(new int[]{-1,-1},twoSumBruteForce(arr,target));
    }

    @Test
    public void eg3(){
        // Invalid array length
        int[] arr = {2};
        int target = 7;
        Assert.assertEquals(new int[]{},twoSumBruteForce(arr,target));
    }



    //Brute Force Approach

    /*

    1. Declare 2 for loops, one outer loop & one inner loop
    2. Iterate the outer & inner for loop from 0 to n-1
    3. Check if indices of outer & inner for loop doesn't match
        Yes => Add the two indices and return if it matches target
        No => Proceed to next iteration
    4. Return the two indices if there are any matches
    5. Return -1 if there is no match

     */


    public int[] twoSumBruteForce(int[] input, int target){

        if (input.length<2) return new int[]{};
        for (int i=0;i<input.length;i++)
        {
            int sum =0;
            for (int j=0;j<input.length;j++)
            {
                if(i!=j && input[i]+input[j] == target) return new int[] {i,j};
            }
        }
    return new int[]{-1,-1};
    }

}
