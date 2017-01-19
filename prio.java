
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student implements Comparable{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
   public int compareTo(Object obj2){
       int ret = 0;
        Student s2 = (Student)obj2;
       Double s2Cgpa = s2.getCgpa();
        ret = s2Cgpa.compareTo(this.cgpa);
        if(ret == 0){
            ret = this.getFname().compareTo(s2.getFname());
            if(ret == 0){
                ret = this.getToken()-s2.getToken();
            }
        }
        return ret;
    }
}

public class prio {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      PriorityQueue<Student> pr = new PriorityQueue<Student>();
      while(totalEvents>0){
         String event = in.next();
         if(event.equals("ENTER")){
             String fn = in.next();
             double cgpa = in.nextDouble();
             int token = in.nextInt();
            Student s = new Student(token, fn, cgpa); 
             pr.add(s);
         }else{
             pr.poll();             
         }
          for(Student s1: pr){
             System.out.println(s1.getFname());
            }
             System.out.println();
         totalEvents--;
      }
    }
}
