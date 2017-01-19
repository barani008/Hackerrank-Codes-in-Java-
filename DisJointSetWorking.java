import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class DisJointSet{
    
    Map<Integer, Node> map = new HashMap<Integer,Node>();
    static class Node{
        int data;
        int rank;
        int size;
        Node parent;
    }
    
    public void makeSet(int[] arr){
        for(int n:arr){
            Node node = new Node();
            node.data = n;
            node.rank = 0;
            node.parent = node;
            node.size = 1;
            map.put(n, node);
        }
    }
    
    public Integer findSize(int n){
        Node a = map.get(n);
        Node p = a.parent;
        while(p.parent!=p){
            p = p.parent;
        }
        if(p!=a.parent){
            a.parent = p;
        }
        return p.size;
    }
    
    public void merge(int a1, int b1){
        Node a = map.get(a1);
        Node b = map.get(b1);
        Node p = a.parent;
        //finding the root node of a's group
        while(p.parent!=p){
            p = p.parent;
        }
        //Path Compression
        a.parent = p;
        //doing the same for b
        p = b.parent;
        while(p.parent!=p){
            p = p.parent;
        }
        b.parent = p;
        if(a.parent!=b.parent){
            if(a.parent.rank>b.parent.rank){
                a.parent.size +=b.parent.size;
                b.parent.parent = a.parent;     //assigning b's parent under a's parent
                b.parent = a.parent;            //assigning a's parent as b's parent
            }else if(a.parent.rank<b.parent.rank){
                b.parent.size += a.parent.size;
                a.parent.parent = b.parent;     //assigning a's parent under b's parent
                a.parent = b.parent;            //assigning b's parent as a's parent                 
            }else{
                a.parent.size +=b.parent.size;
                b.parent.parent = a.parent;     //assigning b's parent under a's parent
                b.parent = a.parent;            //assigning a's parent as b's parent
                a.parent.rank++;
            }
        }
    }
}
public class DisJointSetWorking {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        DisJointSet dSet = new DisJointSet();
        dSet.makeSet(arr);
        for(int i=0;i<q;i++){
            String query = in.next();
            if(query.equalsIgnoreCase("Q")){
                System.out.println(dSet.findSize(in.nextInt()));
            }else{
                int a = in.nextInt();
                int b = in.nextInt();
                dSet.merge(a,b);
            }
        }
    }
}