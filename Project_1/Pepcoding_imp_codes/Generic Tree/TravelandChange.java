import java.util.*;


public class TravelandChange{
    static private class Node{
        int data;
        ArrayList<Node> children =new ArrayList<>();
    }

    public static void displaying(Node root){

        String str=root.data+"-->";
        for(Node child:root.children){
            str+=child.data+",";
            
        }
        str+=".";
        System.out.println(str);
        for(Node child:root.children){
    
            displaying(child);
        }

    }
  
    public static ArrayList<Integer> Nodetoroot(Node node,int target){
      ArrayList<Integer> al= new ArrayList<>();
      if(node.data == target){
        ArrayList<Integer> list= new ArrayList<>();
        list.add(node.data);
        return list;
      }
      for(Node child:node.children){
        ArrayList<Integer> ptc= Nodetoroot(child, target);
        if(ptc.size()>0){
          ptc.add(node.data);
          return ptc;
        } 
      }
      

      return al;
    }
    public static Node construct(int[] arr) {
        
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }   
      static int size;
      static int min;
      static int max;
      static int height;
      public static void multisolver(Node root,int depth){
          size++;
          min=Math.min(min, root.data);
          max=Math.max(max,root.data);
          height=Math.max(height,depth);
          for(Node child:root.children){
            multisolver(child,depth+1);
          }

      }
public static void main(String[] args) {
    int[] array={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
  
    Node root = construct(array);
    displaying(root);
    size= 0;
    min=Integer.MAX_VALUE;
    max=Integer.MIN_VALUE;
    height=0;
    multisolver(root,0);
    System.out.println("SIZE : "+size);
    System.out.println("MIN : "+min);
    System.out.println("MAX : "+max);
    System.out.println("HEIGHT : "+height);
    
}
}