import java.util.*;
public class PriorityQueue_1{
      /* This is orignal customized made
       PriorityQueue.*/
    public  class MyOrignalPriorityQueue {
        ArrayList<Integer> data;
    
        public MyOrignalPriorityQueue() {
          data = new ArrayList<>();
        }
        public MyOrignalPriorityQueue(int [] arr) {
            // data = new ArrayList<>();
            data = new ArrayList<>();
            for(int val: arr){
                data.add(val);
            }
            for(int i=data.size()/2- 1;i>=0;i--){
                downheapify(i);
            }
          }
    
        public void add(int val) {
          // write your code here
          data.add(val);
          upheapify(data.size()-1);
        }
    public void upheapify(int ci){
    if(ci==0){
      return;
    }
    int pi=(ci-1)/2;
    if(data.get(pi)>data.get(ci)){
      swap(ci,pi);
      upheapify(pi);
    }
    }
    public void swap(int i,int j){
      int ith=data.get(i);
      int jth=data.get(j);
      data.set(i,jth);
      data.set(j,ith);
    }
    
        public int remove() {
          
          if(data.size()==0){
            System.out.println("Underflow");
            return -1;
          }
          // Mayank Solution
          swap(data.size()-1,0);
          // data.set(,null);
          int val=data.remove(data.size()-1);
          downheapify(0);
          return val;
        }
        public void downheapify(int i){
          int min=i;
          int lci=(2*i)+1;
          // if(){
          //   return;
          // }
          if(lci<data.size() && data.get(lci)<data.get(min)){
            min=lci; 
          }
          int rci=(2*i)+2;
          if(rci<data.size() && data.get(rci)<data.get(min)){
            min=rci; 
          }
          if(min!=i){
            swap(min,i);
            downheapify(min);
          }
          
    
        }
    
        public int peek() {
          // write your code here
          if(data.size()==0){
            System.out.println("Underflow");
            return -1;
          }
          else{
            return data.get(0);
          }
          
        }
    
        public int size() {
          // write your code here
          return data.size();
        }
    }
    /* This is customized version of 
    MyPriotiyQueue, This takes any datatype with support of Comparable and Comparator */
    static class MyPriorityQueue<T> {
        ArrayList<T> data;
        Comparator cmptr; 
       
        public MyPriorityQueue() {
            data = new ArrayList<>();
           cmptr=null;
          }
          public MyPriorityQueue( Comparator cmptr) {
            data = new ArrayList<>();
            this.cmptr= cmptr;
          }

    
        public void add(T val) {
          // write your code here
          data.add(val);
          upheapify(data.size()-1);
        }
    public void upheapify(int ci){
    if(ci==0){
      return;
    }
    int pi=(ci-1)/2;
    if(Issamller(ci, pi)==true){
      swap(ci,pi);
      upheapify(pi);
    }
    }
    public void swap(int i,int j){
      T ith=data.get(i);
      T jth=data.get(j);
      data.set(i,jth);
      data.set(j,ith);
    }
    
        public T remove() {
          
          if(data.size()==0){
            System.out.println("Underflow");
            return null;
          }
          // Mayank Solution
          swap(data.size()-1,0);
          // data.set(,null);
          T val=data.remove(data.size()-1);
          downheapify(0);
          return val;
        }
        public void downheapify(int i){
          int min=i;
          int lci=(2*i)+1;
          // if(){
          //   return;
          // }
          if(lci<data.size() && Issamller(lci, min)==true){
            min=lci; 
          }
          int rci=(2*i)+2;
          if(rci<data.size() && Issamller(rci, min)==true){
            min=rci; 
          }
          if(min!=i){
            swap(min,i);
            downheapify(min);
          }
          
    
        }
    
        public T peek() {
          // write your code here
          if(data.size()==0){
            System.out.println("Underflow");
            return null;
          }
          else{
            return data.get(0);
          }
          
        }
    
        public int size() {
          // write your code here
          return data.size();
        }
        public boolean Issamller(int i,int j){
            T ith=data.get(i);
            T jth=data.get(j);
            if(cmptr!=null){
                if(cmptr.compare(ith, jth)<0){
                    return true;
                }
                else{
                    return false;
                }
            }else{
                Comparable cith=(Comparable)ith;
                Comparable cjth=(Comparable)jth;
                if(cith.compareTo(cjth)<0){
                    return true;
                }
                else{
                    return false;
                }

            }

        }
    }
    static class Student implements Comparable<Student>{
        String name;
        int height;
        int weight;
        int marks;
        Student(String name, int height, int weight, int marks){
            this.name=name;
            this.height = height;
            this.weight=weight;
            this.marks=marks;
        }
        public String toString(){
            return this.name+"->"+this.height+"->"+this.weight+"->"+this.marks;
        }
        public int compareTo(Student o){
            return this.height-o.height;
        }
    }
    static class StudentWeightComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.weight - s2.weight;
        }
    }
    static class StudentMArksComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.marks - s2.marks;
        }
    }
    public static void main(String[] args){
        Student[] students=new Student[5];
        students[0]= new Student("A",179,80,100);
        students[1]= new Student("B",160,50,120);
        students[2]= new Student("C",180,49,50);
        students[3]= new Student("D",200,87,60);
        students[4]= new Student("E",150,52,200);
        // System.out.println(s1);
        MyPriorityQueue<Student> pqh=new MyPriorityQueue<>();
        MyPriorityQueue<Student> pqw=new MyPriorityQueue<>(new StudentWeightComparator());
        MyPriorityQueue<Student> pqm=new MyPriorityQueue<>(new StudentMArksComparator());
        for(Student stu : students){
            pqh.add(stu);
            pqw.add(stu);
            pqm.add(stu);
        }
        System.out.println("On the basis of Height");
        while(pqh.size()>0){
            Student s1=pqh.peek();
            pqh.remove();
            System.out.println(s1);
        }
        System.out.println("On the basis of Weight");
        while(pqw.size()>0){
            Student s1=pqw.peek();
            pqw.remove();
            System.out.println(s1);
        }
        System.out.println("On the basis of Marks");
        while(pqm.size()>0){
            Student s1=pqm.peek();
            pqm.remove();
            System.out.println(s1);
        }
    }
}