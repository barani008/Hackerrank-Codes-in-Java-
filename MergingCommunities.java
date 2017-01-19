import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MergingCommunities {

	public static void main(String[] args) {
		 /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[N+1];
        List<Set<Integer>> listOfSets = new ArrayList<Set<Integer>>();
        Set<Integer> nullSet = new HashSet<Integer>();
        listOfSets.add(nullSet);
        for(int i=1;i<N+1;i++){
            arr[i] = i;
            Set<Integer> set = new HashSet<Integer>();
            set.add(i);
            listOfSets.add(set);
        }
        for(int i=0;i<q;i++){
            String query = in.next();
            if(query.equalsIgnoreCase("Q")){
                int person = in.nextInt();
                System.out.println(listOfSets.get(arr[person]).size());
            }else{
                int p1 = in.nextInt();
                int p2 = in.nextInt();
                if(arr[p1]!=arr[p2]){
                   Set<Integer> set1 = listOfSets.get(arr[p1]);
                   Set<Integer> set2 = listOfSets.get(arr[p2]);
                   for(Integer j:set2){
                       arr[j]=arr[p1];
                   } 
                   set1.addAll(set2);
                   set2.clear();
                }                
            }
        }

	}

}
