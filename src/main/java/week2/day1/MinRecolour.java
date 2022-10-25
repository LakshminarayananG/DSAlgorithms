package week2.day1;

import org.testng.annotations.Test;

public class MinRecolour {

    @Test
    public void eg1(){
        String blocks ="WBWBBBW";
        int k=2;
        System.out.println("Output of Eg1 is: "+minimumRecolors(blocks,k));
    }


    private int minimumRecolors(String blocks, int k) {

        int left=0,right=0;
        int whiteBlocks=0,minBlock = Integer.MAX_VALUE;
        while(right<k){
            if(blocks.charAt(right++)=='W') whiteBlocks++;
        }
        minBlock = whiteBlocks;
        while(right<blocks.length()){
            if(blocks.charAt(right++)=='W') whiteBlocks++;
            if(blocks.charAt(left++)=='W') whiteBlocks--;
            minBlock = Math.min(minBlock,whiteBlocks);
        }
        return minBlock;
    }



    private int minimumRecolorsalt(String blocks, int k) {

        int b = 0;

        for(int i = 0; i != k; i++)
            if(blocks.charAt(i) == 'B') b++;


        int mini = k - b;

        for(int i = k; i < blocks.length() && mini != 0; i++){
            if(blocks.charAt(i-k) == 'B') b--;
            if(blocks.charAt(i) == 'B') b++;
            mini = Math.min(mini, k-b);
        }

        return mini;

    }
}
