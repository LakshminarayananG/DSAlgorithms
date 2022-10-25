package week2.day1;

import org.testng.annotations.Test;

public class MaxConsecutiveSum {


    /*

    Given an integer array, find the max sum of consecutive K arrays

    Input => 1,5,2,3,7,1
    Target K => 3

    Note: K will always be greater than 1 and less than the size of the array

     */


    @Test
    public void eg1(){
        int[] input = {1,5,2,3,7,1};
        int k =3;
        System.out.println("Output Value for Eg1 using 2 pointer is: "+maxSumUsing2Ptr(input,k));
    }

    @Test
    public void eg2(){
        int[] input = {2};
        int k = 3;
        System.out.println("Output Value for Eg2 using 2 pointer is: "+maxSumUsing2Ptr(input,k));
    }

    @Test
    public void eg3(){
        int[] input = {};
        int k =0;
        System.out.println("Output Value for Eg3 using 2 pointer is: "+maxSumUsing2Ptr(input,k));
    }

    @Test
    public void eg4(){
        int[] input ={};
        int k=0;
        System.out.println("Output Value for Eg4 using 2 pointer is: "+maxSumUsing2Ptr(input,k));
    }

    @Test
    public void eg5(){
        int[] input = {1,5,2,3,7,1,4};
        int k =3;
        System.out.println("Output Value for Eg5 using 2 pointer is: "+maxSumUsing2Ptr(input,k));
    }



    // Two Pointer Approach

    /*

    1. Declare 2 pointers left =0, right=> left+k-1;
    2. Find the sum of consecutive elements in the sub array
    3. Iterate until the end of the array
    4. Compare & Return max sum
     */


    private int maxSumUsing2Ptr(int[] input, int k){
        int maxsum=Integer.MIN_VALUE;

        if(k==0 || k>input.length || input.length==0) return 0;

        int left=0,right=left+k-1;

        while(right<input.length){
            maxsum=Math.max(maxsum,findConsecutiveSum(input,left,right));
            left++;
            right++;
        }
         return maxsum;
    }


    private int findConsecutiveSum(int[] input, int left,int right){
        int tempsum=0;

        while(left<=right){
            if(left!=right) tempsum+=input[left++]+input[right--];
            else {
                tempsum+=input[left++];
                right--;
            }
        }

        return tempsum;
    }

}
