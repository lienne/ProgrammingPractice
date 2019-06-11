// Binary Search Tree

import java.io.*;
import java.util.*;

class Node {
  int data;
  Node left, right;

  // constructor that sets the data for each node
  Node(int data) {
    this.data = data;
  }
}

public class BST {
  private Node root;

  public void insert(int data) {
    root = insert(root, data); // calls overloaded method
  }

  // This method is overloaded
  private Node insert(Node root, int data) {
    if(root == null)
      return new Node(data);
    else if(data < root.data)
      root.left = insert(root.left, data);
    else if(data > root.data)
      root.right = insert(root.right, data);
    else
      ; // disallowing insertion of duplicate values

    return root;
    } // end of insert method

    public void delete(int data) {

    }

    private Node delete(Node root, int data) {

    }

    private int findMax(Node root) {

    }

    public boolean contains(int data) {

    }

    private boolean contains(Node root, int data) {

    }

    public void inorder() {

    }

    private void inorder(Node root) {

    }

    public void preorder() {

    }

    private void preoder(Node root) {

    }

    public void postorder() {

    }

    private void postorder(Node root) {

    }

    public static void main(String [] args) {

    }

  } // end of BST class
