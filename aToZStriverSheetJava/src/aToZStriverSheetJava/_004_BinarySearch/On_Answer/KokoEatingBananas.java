package aToZStriverSheetJava._004_BinarySearch.On_Answer;

import java.util.Arrays;

//link - https://leetcode.com/problems/koko-eating-bananas/

public class KokoEatingBananas {
    public int findBananasEaten(int[] piles, int speed){
        int totalSum = 0;
        for(int pile: piles){
            totalSum += Math.ceil( (double) pile / speed);
        }
        return totalSum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = Arrays.stream(piles).max().orElse(1);
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int withThisRate = findBananasEaten(piles, mid);
            if(withThisRate <= h){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return ans;
    }
}
