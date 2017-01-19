import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {

	 public static void main(String[] args)  throws Exception {
	       Scanner in = new Scanner(System.in);
	        int N = in.nextInt();
	        int K = in.nextInt();
	        long minSum = Long.MAX_VALUE;
	        int[] arr = new int[N];
	        for(int i =0;i<N;i++){
	            arr[i] = in.nextInt();
	        }
	        Arrays.sort(arr);
	        for(int i=0;i<=N-K;i++){
	             long sum = 0l;
	             long curr=0l;
	             for(int j=i+1;j<i+K;j++){
	                 long unfair =arr[j]-arr[j-1];
	                 curr = curr+(j-i)*unfair;
	                 sum+= curr;
	                 //System.out.print(unfair+" "+(j-i)+" ");
	             }
	            //System.out.println();
	             if(sum<minSum)
	                 minSum = sum;
	         }
	         System.out.println(minSum);
	    }

}
