package week1.day2;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SortArrayWithoutUsingFunction {



    @Test
    public void eg1(){
        int[] nums ={ 6, 8, 7, -4, 312, 78, 54, 9, 12, 100, 89, 74 };
        System.out.println(Arrays.toString(sortArray(nums)));
    }


    private int[] sortArray(int[] nums){

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int temp;
                if(nums[i]>nums[j]){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }

        return nums;
    }
}
