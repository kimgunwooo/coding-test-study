import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
}

class Tree {
    Node root;
    public void InsertNode(int value){
        if(root == null){
            root = new Node(value);
        } else{
            searchNode(root, value);
        }
    }
    private void searchNode(Node root, int value) {
        if(value < root.value ){
            if(root.left == null) {
                root.left = new Node(value);
            }
            else{
                searchNode(root.left,value);
            }
        }
        else if(value > root.value){
            if(root.right == null){
                root.right = new Node(value);
            }
            else{
                searchNode(root.right,value);
            }
        }
    }
    public void postOrder(Node node) {
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();

        while(true){
            String str = br.readLine();
            if(str == null || str.equals("")) break;
            int n = Integer.parseInt(str);
            tree.InsertNode(n);
        }

        tree.postOrder(tree.root);
    }
}