import java.util.Scanner;

public class KadaneProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]= in.nextInt();			
		}
		System.out.println(largestSubArray(arr));
	}

	private static int largestSubArray(int[] arr) {
		int maxEndingHere = 0, maxSoFar = 0;
		for(int i=0;i<arr.length;i++){
			maxEndingHere += arr[i];
			if(maxEndingHere<0)
				maxEndingHere =0;
			if(maxSoFar<maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}

}
