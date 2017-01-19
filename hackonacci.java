	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;
public class hackonacci {



	    static int result[] = new int[3];
	    
	    public static boolean[][] generateHackonacci(int max){
	        boolean[] list = new boolean[(max*max)+1];
	        boolean[][] ret = new boolean[max+1][max+1];
	        int[] cal = new int[(max*max)+1];
	        cal[0] = 0;
	        list[0] = true;
	        cal[1] = 1;
	        list[1] =false;
	        cal[2] = 2;
	        list[2] = true;
	        cal[3] = 3;
	        list[3] = true;
	        for(int i = 4;i<=(max*max);i++){
	        	int val = ((cal[i-3]%10)+((2*cal[i-2])%10)+((3*cal[i-1])%10))%10;
	            if(val%2==0)
	                list[i] = true;
	            else
	                list[i] = false;
	            cal[i] = val;
	        }
	        for(int i = 1;i<=max;i++){
	            for(int j=1;j<=max;j++){
	                int index = (i*j);
	                ret[i][j] = list[index];
	            }
	        }
	        //System.out.println(cal[max*max]+ ", "+cal[max*max*max*max]);
	        return ret;
	    }
	    
	    public static int rotateMatrix(boolean[][] mat, int angle, int max){
	        int ret = 0;
	        if(angle>360){
	        	angle = angle%360;
	        }
	        if(angle==90){
	        	if(result[0] != -1){
	        		return result[0];
	        	}
	            for(int i=1;i<=max;i++){
	                for(int j=1;j<=max;j++){
	                    if(mat[i][j] != mat[max-i+1][j])
	                        ret++;
	                }
	            }
	            result[0] = ret;
	        }else if(angle == 180){
	        	if(result[1] != -1){
	        		return result[0];
	        	}
	            for(int i=1;i<=max;i++){
	                for(int j=1;j<=max;j++){
	                    if(mat[i][j] != mat[max-i+1][max-j+1])
	                        ret++;
	                }
	            }
	            result[1] = ret;
	        }else if(angle == 270){
	        	if(result[2] != -1){
	        		return result[0];
	        	}
	            for(int i=1;i<=max;i++){
	                for(int j=1;j<=max;j++){
	                    if(mat[i][j] != mat[i][max-j+1])
	                        ret++;
	                }
	            }
	            result[2] = ret;
	        }else{
	        	return 0;
	        }
	        return ret;
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        Arrays.fill(result, -1);
	        int n = in.nextInt();
	        boolean[][] val = generateHackonacci(n);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int angle = in.nextInt();
	            System.out.println(rotateMatrix(val, angle, n));
	        }
	    }
	}
