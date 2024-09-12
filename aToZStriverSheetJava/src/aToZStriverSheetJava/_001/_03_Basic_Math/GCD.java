package aToZStriverSheetJava._001._03_Basic_Math;

import java.util.Arrays;

//link - https://leetcode.com/problems/find-greatest-common-divisor-of-array/

public class GCD {

    public int findGCD(int[] nums) {
        int gcd = 1;

        // By sorting
        Arrays.sort(nums);
        for(int i=1; i<=nums[0]; i++){
            if(nums[0] % i == 0 && nums[nums.length - 1] % i == 0){
                gcd = i;
            }
        }

        // By Min-Max
        // int min = Arrays.stream(nums).min().getAsInt();
        // int max = Arrays.stream(nums).max().getAsInt();

        // for(int i=1; i<=min; i++){
        //     if(min % i == 0 && max % i == 0){
        //         gcd = i;
        //     }
        // }

        return gcd ;
    }
}
