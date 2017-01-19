import java.util.Scanner;

public class MyQuickSort {

	static void swap(int[] ar, int a, int b){
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }   
    
    static int split(int[] ar, int low, int high){
        int pivot = low;
        int i = low;
        int j = high;       
        while(i<=j){
            System.out.println(i+ " " + j);
            if(ar[i] <= ar[pivot]){
                i++;
                continue;
            }
            if(ar[j] > ar[pivot]){
                j--;
                continue;
            } 
            swap(ar, i++, j--);
            
        }
            if(ar[pivot]>ar[j]){
                swap(ar, pivot, j);
                return j;
        }
                    return pivot;
    }
    
          static void quickSort(int[] ar, int low, int high) {
               if(low>=high)
                    return;
              System.out.println(low);
                int pos=  split(ar, low, high);
              System.out.println(pos);
                printArray(ar, low, pos-1);
                quickSort(ar, low, pos-1);
                printArray(ar, pos+1, high);
                quickSort(ar, pos+1, high);
                    
       }   
 
 static void printArray(int[] ar, int low,int high) {
         for(int n = low;n< high;n++){
            System.out.print(ar[n]+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           int[] ar = {10,32,43,24,-1,3,4,56,54};
           quickSort(ar,0,ar.length-1);
       }    
 }
