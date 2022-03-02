import java.util.*;

public class BinaryTreeConstruct {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
public static void DisplayBinaryTree(Node node){
    
    String str ="<---" +node.data + "--->";
    if(node.left!=null){
        str=node.left.data+" "+str;
    } 
    if(node.right!=null){
        str+=node.right.data+" ";
    }
    str+=".";
    System.out.println(str);
    if(node.left!=null){
        DisplayBinaryTree(node.left);
    } 
    if(node.right!=null){
        DisplayBinaryTree(node.right);
    }

}
public static Node ConstructBinaryTree(int[] arr) {
    Node root = new Node(arr[0], null, null);// initialize root's left and right as null
    Stack<Pair> st = new Stack<>();
    Pair rp = new Pair(root, 1);
    st.push(rp);
    int idx = 1;
    while (st.size() > 0) {
        Pair top = st.peek();

        if (top.state == 1) {
            top.state++;
            // pushing the left Node
            if (arr[idx] != -1) {
                // Checking if the array elememt is not equal to NULL
                Node ln = new Node(arr[idx], null, null);
                top.node.left = ln;
                
                Pair lnp = new Pair(ln, 1);
                st.push(lnp);
            }
            idx++;

        } else if (top.state == 2) {
            top.state++;
            // Pushing the right Node
            if (arr[idx] != -1) {
                // Checking if the array elememt is not equal to NULL
                Node rn = new Node(arr[idx], null, null);
                top.node.right = rn;
               
                Pair rnp = new Pair(rn, 1);
                st.push(rnp);
            }
            idx++;
        } else if(top.state==3) {
            st.pop();
        }
    }

    return root;
}

    public static void main(String[] args) {
        int[] arr = new int[] { 50, 25, 12, -1, -1, 37, 30, -1, -1, -1,
                                75, 62, -1, 70, -1, -1, 87, -1, -1 };
        Node root = ConstructBinaryTree(arr);
        DisplayBinaryTree(root);
        System.out.println(root.data);
    }
}
