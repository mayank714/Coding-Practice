// import java.io.*;
import java.util.*;

public  class MyPriorityQueue {
    ArrayList<Integer> data;

    public MyPriorityQueue() {
      data = new ArrayList<>();
    }
    public MyPriorityQueue(int [] arr) {
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
    public static void main(String[] args) {
        int[] arr={235,324,234,43,32,21,12,1,10};
        MyPriorityQueue pq=new MyPriorityQueue(arr);
       
        // pq.add(100);
        // pq.add(10);
        // pq.add(120);
        // pq.add(910);

        // pq.add(1);
        // pq.add(98);
        // System.out.println(pq.peek());
        while(pq.size()>0){
            int val=pq.peek();
            pq.remove();
            System.out.println(val);
        }

    }
  }