package week1.day2;

import org.testng.annotations.Test;

import java.util.Arrays;

public class AddConsecutiveElementsinArray {

    @Test
    public void eg1(){
    int[] arr ={1,2,3,4,5};
    addElements(arr);
    }


    public int[] addElements(int[] arr){
        int[] output = new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            output[i]= arr[i]+arr[i+1];
            }
        System.out.println(Arrays.toString(output));
        return output;
    }

}
