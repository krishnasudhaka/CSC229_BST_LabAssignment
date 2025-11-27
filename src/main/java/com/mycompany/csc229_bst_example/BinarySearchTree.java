package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {

        // ToDo 1: complete InOrder Traversal 
        // base case below - terminates recursion when node is empty
        if(root == null){
		return ;
        }
        //first, traverse left subtree or left  side of current node
        doInOrder(root.getLeft());

        // then, visit the current node
        System.out.println(root.getData() +"");

        //lastly,traverse right subtree or right  side of current node
        doInOrder(root.getRight());

    }
        public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal . 
    }

     private void doPreOrder(BstNode root){
		if(root != null){
		    // first, visit the current node
          System.out.println(root.getData() +"");
            
         //then, traverse left subtree or left  side of current node
          doPreOrder(root.getLeft());


         //lastly,traverse right subtree or right  side of current node
         doPreOrder(root.getRight());   
            }
    }

    public Integer findHeight() {

        // ToDo 3: Find the height of a tree
        return doFindHeight(this.root);
    }

     private Integer doFindHeight(BstNode root){
	// when node is null, height is -1 
	if(root == null){
         return -1; 
      }


	// recursively finding height of left and right subtrees
	int leftHeight = doFindHeight(root.getLeft());
      int rightHeight = doFindHeight(root.getRight());


	//current node height: 1 plus maximum height of the subtrees
      return 1+Math.max(leftHeight,rightHeight);
   }


    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node 
        if(node == null){
		return -1;
        }
        return findDepth(this.root,node,0);

    }

    private int findDepth(BstNode current,BstNode node,int depth){
      if(current == null){ // node is not present
           return -1; // -1 is returned
      }
      
      if(current == node){ // node is present
           return depth; // current depth is returned
      }


	//recursive action below
	// Suppose below if condition is true, then 
      if(node.getData() < current.getData()){
		return findDepth(current.getLeft(), node, depth + 1);
		// search continues in left subtree; increments in depth observed
      }
	else{ // if (node.getData() > current.getData() ), then
		return findDepth(current.getRight(),node,depth + 1);
           // search continues in right subtree; increments in depth observed
    }
   }

    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
       printSideways(root,0 );
    }

      private void printSideways(BstNode node, int depth) {
        if (node == null) {
            return;
        }
        // print right subtree first 
        printSideways(node.getRight(), depth + 1);


        // print current node, with indentation depending on depth
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");  // 4 spaces per level
        }
        System.out.println(node.getData());


        // then print left subtree 
        printSideways(node.getLeft(), depth + 1);
    }


    // find a node by value to use getDepth by value
    public BstNode findNode(Integer value) {
        return findNodeRec(root, value);
    }


    private BstNode findNodeRec(BstNode current, Integer value) {
        if (current == null) {
            return null;
        }
        if (value.equals(current.getData())) {
            return current;
        } else if (value < current.getData()) {
            return findNodeRec(current.getLeft(), value);
        } else {
            return findNodeRec(current.getRight(), value);
        }
    }
}


}
