public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(20);
        bt.insert(30);
        bt.insert(40);
        bt.insert(15);
        bt.insert(25);
        bt.insert(35);
        bt.insert(3);
        bt.insert(5);
        bt.insert(7);
       bt.printInorder();

    }
}
class TNode {
    int data;
    TNode left;
    TNode right;

    public TNode(int data) {
        this.data = data;
    }
}

class BinaryTree{
    TNode root;

    public void insert(int data) {
        root = recInsertion(root, data);
    }


    public TNode recInsertion(TNode root, int data) {
        if (root == null) {
            return new TNode(data);
        }
        else if (data < root.data) {
            root.left = recInsertion(root.left, data);
        }
        else if (data > root.data) {
            root.right = recInsertion(root.right, data);
        }


        return root;
    }

    public void printInorder() {
        printInorderRec(root);
    }

    public void printInorderRec(TNode root) {
        if (root != null) {
            printInorderRec(root.left);
            System.out.print(root.data + " ");
            printInorderRec(root.right);
        }
    }

}

