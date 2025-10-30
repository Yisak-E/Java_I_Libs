package treeImplementation.binary;

public class BinaryTree<K  extends Comparable<K>> {
    TreeNode<K> root;
    private int size = 0;
    K rootKey;
    public BinaryTree() {

    }
    public BinaryTree(K key) {
        this.rootKey = key;
    }
    public void add(K key){
        if(root == null){
            root = new TreeNode<>(key);
        }
        else{
            add(root, key);
        }
        size++;
    }
    public void add(TreeNode<K> prevRoot , K key ){
      if(prevRoot.key.compareTo(key) > 0){
          if(prevRoot.left == null){
            prevRoot.left = new TreeNode<>(key);
          }else{
              add(prevRoot.left, key);
          }
      }
      else {
          if(prevRoot.right == null){
              prevRoot.right = new TreeNode<>(key);
          }
          else{
              add(prevRoot.right, key);
          }
      }
    }

    public void print(){
        print(root);

    }

    public void print( TreeNode<K> prevRoot){
        if(prevRoot != null){
            print(prevRoot.left);
            System.out.println(prevRoot.key);
            print(prevRoot.right);
        }

    }
    public int size(){
        return size;
    }



    /**
     *     public boolean isSymmetric(TreeNode<K> node){
     *         if(node == null){
     *             return true;
     *         }
     *         return isSymmetric(node.left, node.right);
     *     }
     *   public boolean isSymmetric(TreeNode<K> node1, TreeNode<K> node2){
     *         if(node1 == null && node2 == null){
     *             return true;
     *         }
     *         if(node1 == null || node2 == null){
     *             return false;
     *         }
     *         return node1.key.compareTo(node2.key) == 0 && isSymmetric(node1.left, node2.right) && isSymmetric(node2.left, node1.right);
     *     }
     */

}

class demo{
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        bt.add(1);
        bt.add(3);
        bt.add(3);
        bt.add(2);
        bt.add(4);
        bt.add(4);
        bt.add(2);
        bt.print();
        System.out.println(bt.size());
    }
}
