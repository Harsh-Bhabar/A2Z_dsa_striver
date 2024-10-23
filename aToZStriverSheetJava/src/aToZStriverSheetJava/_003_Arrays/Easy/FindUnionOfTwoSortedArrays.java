package aToZStriverSheetJava._003_Arrays.Easy;

import java.util.ArrayList;

//link - https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays

public class FindUnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                }
                i++; j++;
            }
            else if(a[i] < b[j] ){
                if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                }
                i++;
            }
            else {
                if(ans.isEmpty() || ans.get(ans.size()-1) != b[j]){
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while(i < a.length){
            if(ans.isEmpty() || ans.get(ans.size()-1) != a[i]){
                ans.add(a[i]);
            }
            i++;
        }
        while(j < b.length){
            if(ans.isEmpty() || ans.get(ans.size()-1) != b[j]){
                ans.add(b[j]);
            }
            j++;
        }

        // System.out.println(ans.toString());
        return ans;
    }
}
