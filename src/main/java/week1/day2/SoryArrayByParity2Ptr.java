package week1.day2;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SoryArrayByParity2Ptr {


    @Test
    public void eg1(){
        int[] nums = {3,1,2,4};
        soryByParity(nums);
    }

    private int[] soryByParity(int[] nums){


        int i = 0, j = nums.length-1;
        while(i < j){
            if(nums[i] % 2 == 0) i++;
            else {
                if(nums[j] % 2 != 0) j--;
                if(nums[j] % 2 == 0){
                    swap(nums,i,j);
                    i++;j--;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
