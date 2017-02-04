import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tCases = in.nextInt();
        for(int t=0;t<tCases;t++){
            int n = in.nextInt();
            long [] arr = new long[n];
            for(int i=n-1;i>=0;i--){
                arr[i] = in.nextLong();
            }
            long[] preSum = new long[n];
            long[] dp = new long[n];
            preSum[0] = arr[0];
            for(int i=1;i<n;i++){
                preSum[i]+= preSum[i-1]+arr[i];
            }
            dp[0]=arr[0];
            dp[1]=arr[1]+dp[0];
            dp[2]=arr[2]+dp[1];
            for(int i=3;i<n;i++){
                long x = preSum[i-1]-dp[i-1]+arr[i];
                long y = preSum[i-2]+arr[i]+arr[i-1]-dp[i-2];
                long z = preSum[i-3]+arr[i]+arr[i-1]+arr[i-2]-dp[i-3];
                dp[i]=max(max(x,y),z);
            }
            System.out.println(dp[n-1]);
        }    
    }
     public static long max(long x, long y){
         if(x>y)
             return x;
         else
             return y;
     }
}
