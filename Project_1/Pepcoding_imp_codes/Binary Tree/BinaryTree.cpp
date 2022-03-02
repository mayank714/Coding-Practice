#include <bits/stdc++.h>
using namespace std;
 
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
 
    // val is the key or the value that
    // has to be added to the data part
    Node(int val)
    {
        data = val;
 
        // Left and right child for node
        // will be initialized to null
        left = NULL;
        right = NULL;
    }
};
 void display(Node* node){
     string str ="<---" + to_string(node->data) + "--->";
    if(node->left!=NULL){
        str=to_string(node->left->data)+" "+str;
    } 
    if(node->right!=NULL){
        str+=to_string(node->right->data)+" ";
    }
    str+=".";
    // System.out.println(str);
    std::cout<<str<<std::endl;
    if(node->left!=NULL){
       display(node->left);
    } 
    if(node->right!=NULL){
        display(node->right);
    }
 }
int main()
{
 
    /*create root*/
    struct Node* root = new Node(1);
    /* following is the tree after above statement
 
             1
            / \
          NULL NULL
    */
 
    root->left = new Node(2);
    root->right = new Node(3);
    /* 2 and 3 become left and right children of 1
                    1
                  /    \
                 2       3
               /  \     /  \
            NULL NULL  NULL NULL
    */
 
    root->left->left = new Node(4);
    /* 4 becomes left child of 2
               1
            /     \
           2       3
          / \     / \
         4  NULL NULL NULL
        / \
     NULL NULL
    */
//  std::cout<<root->left->data;
display(root);
    return 0;
}