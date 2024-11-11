package aToZStriverSheetJava._004_BinarySearch.On_Answer;

//link - https://leetcode.com/problems/sqrtx/

public class Sqrt_x {
    public int mySqrt(int x) {
        if(x <= 1){
            return x;
        }

        int l = 1;
        int r = x;
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            long prod = (long) mid * mid;
            if(prod <= x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }
}
