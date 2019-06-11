/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

//import for Scanner and other utility classes
import java.io.*;
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Node {
    int data;
    Node left, right;

    // constructor for Node class
    Node(int data) {
        this.data = data;
    }
}

public class BstHeight {
    private Node root; // starts off as null

    // calls private overloaded method
    public void insert(int data) {
        root = insert(root, data);
    }

    // does actual insertion of data into tree, returns a new Node
    private Node insert(Node root, int data) {
        if(root == null)
            return new Node(data); // constructor for Node class
        else if(data < root.data)
            root.left = insert(root.left, data);
        else if(data > root.data)
            root.right = insert(root.right, data);
        else {
            ; // disallow insertion of duplicate values
        }

        return root;
    }

    // Print the BST to check
    public void inorder()
  	{
  		System.out.print("In-order Traversal:");
  		inorder(root);
  		System.out.println();
  	}

  	private void inorder(Node root)
  	{
  		if (root == null)
  			return;

  		inorder(root.left);
  		System.out.print(" " + root.data);
  		inorder(root.right);
  	}

  	public void preorder()
  	{
  		System.out.print("Pre-order Traversal:");
  		preorder(root);
  		System.out.println();
  	}

  	private void preorder(Node root)
  	{
  		if (root == null)
  			return;

  		System.out.print(" " + root.data);
  		preorder(root.left);
  		preorder(root.right);
  	}

  	public void postorder()
  	{
  		System.out.print("Post-order Traversal:");
  		postorder(root);
  		System.out.println();
  	}

  	private void postorder(Node root)
  	{
  		if (root == null)
  			return;

  		postorder(root.left);
  		postorder(root.right);
  		System.out.print(" " + root.data);
  	}

    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        // You HAVE to give a size for a primitive int array
        int [] dataArray = new int [N];

        for(int i = 0; i < N; i++) {
            dataArray[i] = s.nextInt();
        }

        System.out.println(N);
        System.out.println(Arrays.toString(dataArray));

        // Write your code here
        BstHeight myTree = new BstHeight();

        for(int i = 0; i < N; i++) {
          myTree.insert(dataArray[i]);
        }

        myTree.inorder();
    		myTree.preorder();
    		myTree.postorder();
    }
}
