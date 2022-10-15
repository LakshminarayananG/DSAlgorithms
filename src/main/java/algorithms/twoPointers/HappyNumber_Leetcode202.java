package algorithms.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_Leetcode202 {

    // https://leetcode.com/problems/happy-number/

    /*
     *
     *
     * Write an algorithm to determine if a number n is happy.
     *
     * A happy number is a number defined by the following process:
     *
     * Starting with any positive integer, replace the number by the sum of the
     * squares of its digits. Repeat the process until the number equals 1 (where it
     * will stay), or it loops endlessly in a cycle which does not include 1. Those
     * numbers for which this process ends in 1 are happy. Return true if n is a
     * happy number, and false if not.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82 =
     * 100 12 + 02 + 02 = 1 Example 2:
     *
     * Input: n = 2 Output: false
     */



    @Test
    public void example1() {
        int n =2;
        Assert.assertEquals(false, isHappyNumCycleApproach(n));
        Assert.assertEquals(false, isHappyTwoPointer(n));

    }

    @Test
    public void example2() {
        int n =19;
        Assert.assertEquals(true, isHappyNumCycleApproach(n));
        Assert.assertEquals(true, isHappyTwoPointer(n));
    }

    @Test
    public void example3() {
        int n =0;
        Assert.assertEquals(false, isHappyNumCycleApproach(n));
        Assert.assertEquals(false, isHappyTwoPointer(n));
    }

    @Test
    public void example4() {
        int n =-21;
        Assert.assertEquals(false, isHappyNumCycleApproach(n));
        Assert.assertEquals(false, isHappyTwoPointer(n));
    }



    //Brute force approach
    /*
     * Use Hashset & Cyclic approach => Refer to the happynum.png image after reading pseudocode
     *
     * 1. Since we would need to add the individual digits of a number and find if the total sum
     *    equals 1, it is a happy number.
     * 2. Add the total sum of digits to a hashset
     * 3. Keep iterating as long as the sum is not equal to 1
     * 4. For every iteration, reset sum to 0 & reassign the sum value to the total of individual digits
     *
     * 	  If Sum Equals 1 => The number is a happy number, return true
     *    If Sum equals to a number already present in set, => The cycle is going to repeat on loop,
     *    No use in iterating further, so return false
     *
     * Time Complexity  => O(log n)
     * Space Complexiyy => O(log n)
     *
     */

    private boolean isHappyNumCycleApproach(int n) {

        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)) {
            int sum =0;
            set.add(n);

            while(n!=0) {
                int temp = n%10;
                sum += temp*temp;
                n=n/10;
            }
            n=sum;
        }

        return n==1;
    }



    // Two pointer Approach

    /*
     *
     * 1. Similar to the above approach but with 2 variables
     * 2. The slow variable increments by 1 position each time (calculate sum of digits)
     * 3. The fast variable increments by +1 position compared to the previous iteration
     * 		(Calculate sum of digits)
     * 4. If the fast variable equals slow variable (forms a cycle & not a happy num)
     * 5. If either of slow or fast variable equals 1, it is a happy num
     *
     *
     * Sample Iteration (refer happynum Image)
     * Input 2
     *
     * Iteration 1:
     * Slow => 4
     * Fast => 16
     *
     * Iteration 2:
     * Slow => 16
     * Fast => 58
     *
     * Iteration 3:
     * Slow => 37
     * Fast => 145
     *
     * Iteration 4:
     * Slow => 58
     * Fast => 20
     *
     * Iteration 5:
     * Slow => 89
     * Fast => 16
     *
     * Iteration 6:
     * Slow => 145
     * Fast => 58
     *
     * Iteration 7:
     * Slow => 42
     * Fast => 145
     *
     * Iteration 8:
     * Slow => 20
     * Fast => 20
     *
     *
     * Time Complexity => O(log n)
     * Space Complexity => O(1)
     *
     *
     */


    public boolean isHappyTwoPointer(int n) {
        int slow = n, fast = n;

        while(fast != 1){
            slow = getNextNumber(slow);
            int temp = getNextNumber(fast);
            fast = getNextNumber(temp);

            if (slow == fast) break;
        }
        return fast == 1;
    }

    private int getNextNumber (int n){
        int sum = 0;
        while (n != 0){
            sum += Math.pow(n % 10, 2);
            n = n/10;
        }
        return sum;
    }



}
