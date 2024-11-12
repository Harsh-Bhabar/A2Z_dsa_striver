package aToZStriverSheetJava._004_BinarySearch.On_Answer;

import java.util.Arrays;

//link - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

public class MinimumNumOfDaysToMakeKBouquets {
    public int countBouquets(int[] bloomDay, int bloomed, int adjFlowers){
        int cnt = 0;
        int canMade = 0;
        for(int b: bloomDay){
            if(b <= bloomed){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == adjFlowers){
                canMade++;
                cnt = 0;
            }
        }
        // System.out.println("bloomed CAn - " + bloomed + " " + canMade);
        return canMade;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int l = Arrays.stream(bloomDay).min().orElse(1);
        int r = Arrays.stream(bloomDay).max().orElse(1);
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int cnt = countBouquets(bloomDay, mid, k);
            if(cnt >= m){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }
}
