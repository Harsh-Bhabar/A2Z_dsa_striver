package aToZStriverSheetJava._009_StackAndQueue;

//link - https://leetcode.com/problems/trapping-rain-water/

public class Trapping_Rain_Water {

    // with extra space
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int lmax = -1;
        for(int i=0; i<n; i++){
            lmax = Math.max(lmax, height[i]);
            leftMax[i] = lmax;
        }

        int rmax = -1;
        for(int i=n-1; i>=0; i--){
            rmax = Math.max(rmax, height[i]);
            rightMax[i] = rmax;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    // without using extra space

    public int trap2(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int ans = 0;

        while(l < r){
            if(height[l] < height[r]){
                if(leftMax < height[l]){ // we dont have anything to hold our water to left side
                    leftMax = height[l];
                }else{
                    ans += (leftMax-height[l]);
                }
                l++;
            }else{
                if(rightMax < height[r]){ // we dont have a bigger height on right side to hold
                    rightMax = height[r];
                }else{
                    ans += (rightMax-height[r]);
                }
                r--;
            }
        }

        return ans;
    }

}
