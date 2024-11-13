package aToZStriverSheetJava._004_BinarySearch.On_Answer;

//link - https://leetcode.com/problems/magnetic-force-between-two-balls/

import java.util.Arrays;

public class AggresiveCows {

    public boolean isPossible(int[] position, int dist, int balls){
        int n = position.length;
        int cntBall = 1;
        int lastBall = position[0];

        for(int i=1; i<n; i++){
            if(Math.abs(position[i] - lastBall) >= dist ){
                cntBall++;
                lastBall = position[i];
            }
            if(cntBall >= balls){
                return true;
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int n = position.length;
        int l = 1;
        int r = position[n-1] - position[0];
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(isPossible(position, mid, m)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }
}
