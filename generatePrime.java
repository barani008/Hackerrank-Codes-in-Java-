
public class generatePrime {
	public static void main(String args[]){
		for(long l = 2;l<1538;l++){
			boolean prime = true;
			for(int i=2;i<=l/2;i++){
				if(l%i==0)
					prime = false;
			}
			if(prime==true){
				System.out.print(l+",");
			}
		}
	}
}
