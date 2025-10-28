package treeImplementation.binary;

public class BinaryTree<K  extends Comparable<K>> {
    TreeNode<K> root;
    private int size = 0;
    K rootKey;
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
}

class demo{
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>(5);
        bt.add(5);
        bt.add(4);
        bt.add(6);
        bt.add(8);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.print();
        System.out.println(bt.size());
    }
}
