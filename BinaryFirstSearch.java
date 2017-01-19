import java.util.Scanner;

public class BinaryFirstSearch {

	public static int divide(int n){
        int sq = (int)Math.floor(Math.sqrt(n));
        while(sq>1){
            if(n%sq==0){
                return n/sq;
            }
            sq--;
        }
        return n;
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		divide(n);
	}

}
