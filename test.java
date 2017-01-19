import java.util.Scanner;


public class test {
	
	public static boolean[][] generateHackonacci(int max){
        boolean[] list = new boolean[(max*max)* (max*max)];
        boolean[][] ret = new boolean[max][max];
        int[] cal = new int[(max*max)* (max*max)];
        cal[0] = 0;
        list[0] = true;
        cal[1] = 1;
        list[1] =false;
        cal[2] = 2;
        list[2] = true;
        cal[3] = 3;
        list[3] = false;
        for(int i = 4;i<(max*max)* (max*max);i++){
        	int val = ((cal[i-3]%10)+((2*cal[i-2])%10)+((3*cal[i-1])%10))%10;
            if(val%2==0)
                list[i] = true;
            else
                list[i] = false;
            cal[i] = val;
            System.out.println(val);
        }
        for(int i = 0;i<max;i++){
            for(int j=0;j<max;j++){
                int index = (i*j)*(i*j);
                ret[i][j] = list[index];
            }
        }
        return ret;
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] val = generateHackonacci(n);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int angle = in.nextInt();
            //System.out.println(rotateMatrix(val, angle, n));
        }
    }
}
