import java.io.*;
import java.util.*;

class Node<E> {
    E value;
    Node<E> left;
    Node<E> right;
    public Node(E value) {
        this.value = value;
    }
}
class Tree<E> {
    public Node<E> root;
    public void createNode(E value, E left, E right){
        if(root == null){
            root = new Node<>(value);
            root.left = left.equals('.') ? null : new Node<>(left);
            root.right = right.equals('.') ? null : new Node<>(right);
        } else {
            searchNode(root, value, left, right);
        }
    }
    private void searchNode(Node<E> root, E value, E left, E right) {
        if(root == null){
            return;
        } else if(root.value == value) {
            root.left = left.equals('.') ? null : new Node<>(left);
            root.right = right.equals('.') ? null : new Node<>(right);
        } else {
            searchNode(root.left, value, left, right);
            searchNode(root.right, value, left, right);
        }
    }
    public void preOrder(Node<E> node){
        if(node != null){
            System.out.print(node.value);
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }
    public void inOrder(Node<E> node){
        if(node != null){
            if(node.left != null) inOrder(node.left);
            System.out.print(node.value);
            if(node.right != null) inOrder(node.right);
        }
    }
    public void postOrder(Node<E> node){
        if(node != null){
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.value);
        }
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Tree<Character> tree = new Tree<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.createNode(root,left,right);
        }

        tree.preOrder(tree.root);
        System.out.println();

        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
        System.out.println();
    }
}