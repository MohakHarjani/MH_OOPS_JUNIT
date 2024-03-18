package dsa.datastructure;


import java.util.*;
class Node   
{  
    Node left;  
    Node right;  
    int value;  
    public Node(int value)   
    {  

        this.value = value; 
        this.left = null;
        this.right = null;
    }  
}  
class BinarySearchTree   
{  
    static Node root = null;
   
    public static void main(String[] args)   
    {  
    	BinarySearchTree bst = new BinarySearchTree();
    	root = new Node(25);
    	insert(root, 11);
    	insert(root, 15);
    	insert(root, 16);
    	insert(root, 23);
    	insert(root, 80);
    	insert(root, 7);
    	insert(root, 10);
    	
    	System.out.println();
    	
    	System.out.println("Complete tree :  ");
    	inOrder(root);
    	System.out.println("\n");
    	
    	System.out.println("After deleting 11  : ");
    	root = deleteNode(root, 11);
    	inOrder(root);
    	System.out.println("\n");
    	
    	System.out.println("After deleting 15  : ");
    	root = deleteNode(root, 15);
    	inOrder(root);
    	System.out.println("\n");
    	
       	System.out.println("After deleting 25  : ");
    	root = deleteNode(root, 25);
    	inOrder(root);
    	System.out.println("\n");
    } 
    //=========================================================================================================
    static int search(Node currNode, int targetValue)
    {
    	if (currNode == null)
    		return -1;
    	if (targetValue == currNode.value)
    		return targetValue;
    	
    	if (targetValue < currNode.value)
    		return search(currNode.left, targetValue);
    	else
    		return search(currNode.right, targetValue);
    }
    //===========================================================================================================
    static void insert(Node node, int value)   
    {  
        if (value < node.value)   
        {  
            if (node.left != null) 
                insert(node.left, value);  
            else  
            {
               System.out.println("  Inserted " + value + " to left of Node " + node.value);  
               node.left = new Node(value);  

            }  

        }   
        else if (value > node.value)   
        {  

            if (node.right != null)   
                insert(node.right, value);  
            else   
            { 
                System.out.println("  Inserted " + value + " to right of Node " + node.value);  

                node.right = new Node(value);  

            } 
        }  

    }
    //=================================================================================================================
    static Node getNewSubtree(Node root) //root is to be deleted
    {
        if (root.left == null && root.right == null) //Both null
            return null;
        if (root.left == null || root.right == null)  //One of them is null
        {
            Node ans = (root.left == null)? root.right : root.left;
            return ans;
        }
        
        //come here when both of them (left and right) are not null
        Node newRoot = root.right;
        Node detachedNode = root.left;
        Node currNode = newRoot;
        while(currNode.left != null)   //go to extreme left
            currNode = currNode.left;
        
        currNode.left = detachedNode;
        return newRoot;
    }
    static Node deleteNode(Node root, int key)
    {
        if (root == null)
            return null;
        if (root.value == key)
            return getNewSubtree(root);

        Node curr = root;
        while(true)
        {
            if (curr == null)
                return root; //nothing deleted
            
            
            if (curr.left != null && curr.left.value == key)
            {
                curr.left = getNewSubtree(curr.left);
                break;
            }
            else if (curr.right != null && curr.right.value == key)
            {
                curr.right = getNewSubtree(curr.right);
                break;
            }
            else if (key < curr.value)
                curr = curr.left;
            else if (key > curr.value)
                curr = curr.right;
        }
        
        return root;
    }
  //============================================================================================================================
    
    static void inOrder(Node root)
    {
    	if (root == null)
    		return;
    	inOrder(root.left);
    	System.out.print(root.value + "=> ");
    	inOrder(root.right);
    }
} 