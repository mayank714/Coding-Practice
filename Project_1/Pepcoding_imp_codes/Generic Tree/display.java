import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class display{
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
            // str+=child.data+",";
            displaying(child);
        }

    }
    public static int size(Node node){
        int s=0;
        for(Node child:node.children){
            int cs=size(child);
            s=s+cs;
        }
        
        // System.out.println(sizee);
        return s+1;
    }
    public static int Maximum(Node node){
        int m=node.data;
        for(Node child:node.children){
            if(m<child.data){
                m=child.data;
            }
            Maximum(child);
            
        }
        return m;
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
public static void main(String[] args) {
    int[] array={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    int DataF=110;
    Node root = construct(array);
    displaying(root);
    int s=size(root);
    System.out.println(s);
    int r=Maximum(root);
    System.out.println("Max is "+r);
    ArrayList<Integer> Ntr=Nodetoroot(root,DataF);
    System.out.println(Ntr);
}
}