// Convert sorted array into a BST and print the above tree level by level.

// Solution:
// 1. Find middle of the array and make it root.
// 2. Recursively do the same for left half and right half of the array.
//    a) Get the middle of left half and make it left child of root.
//    b) Get the middle of right half and make it right child of root.

class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

public class BinaryTree {
  static Node root;

  // Function to construct a Balanced BST from a sorted array
  Node sortedArrayToBST(int arr[], int start, int end) {
    // Base case
    if(start > end) {
      return null;
    }

    // Get middle element and make it root
    int mid = (start+end)/2;
    Node node = new Node(arr[mid]);

    // Recursively construct the left subtree and make it left child of root
    node.left = sortedArrayToBST(arr, start, mid-1);

    // Recursively construct the right subtree and make it right child of root
    node.right = sortedArrayToBST(arr, mid+1, end);

    return node;
  }

  // Utility function to print pre-order traversal of BST
  void preOrder(Node node) {
    if(node == null) {
      return;
    }

    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void main(String [] args) {
    BinaryTree tree = new BinaryTree();

    int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int n = arr.length;
    root = tree.sortedArrayToBST(arr, 0, n-1);
    System.out.println("Preorder traversal of constructed BST:");
    tree.preOrder(root);
    System.out.println();
  }
}
