package aToZStriverSheetJava._004_BinarySearch.On_Answer;

import java.util.Arrays;

//link - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class Capacity_To_Ship_Packages_Within_D_days {

    public int findDaysForCap(int[] wts, int capacity){
        int days = 1;
        int load = 0;
        for(int wt: wts){
            if(load + wt > capacity){
                days++;
                load = wt;
            }else{
                load += wt;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int l = Arrays.stream(weights).max().orElse(1);
        int r = Arrays.stream(weights).sum();
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int daysForCap = findDaysForCap(weights, mid);
            if(daysForCap <= days){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }

}
