package aToZStriverSheetJava._004_BinarySearch.On_Answer;

//link - https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m

public class NthRootOfNum {

    public int checkForRoot(int num, int n, int target){
        long ans = 1;
        for(int i=1; i<=n; i++){
            ans *= num;
            if(ans > target){
                return 2;
            }
        }
        if(ans == target){
            return 1;
        }
        return 0;
    }

    public int NthRoot(int n, int m)
    {
        int l = 1;
        int r = m;

        while(l <= r){
            int mid = l + (r-l)/2;
            int check = checkForRoot(mid, n, m);
            if(check == 1){
                return mid;
            }
            else if(check == 0){ // check is smaller
                l = mid+1;
            }
            else{ // check is bigger
                r = mid-1;
            }
        }

        return -1;
    }
}
