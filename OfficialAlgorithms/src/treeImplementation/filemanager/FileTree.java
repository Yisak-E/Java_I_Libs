package treeImplementation.filemanager;

import com.sun.source.tree.Tree;

public class FileTree{
    FileNode root;
    private int size = 0;

    public FileTree(FileNode root) {
        this.root = root;
    }
    public FileTree() {

    }
    public FileNode getRoot() {
        return root;
    }
    public void setRoot(FileNode root) {
        this.root = root;
    }
    public FileTree getFileTree() {
        return this;
    }
    public void setFileTree(FileTree fileTree) {
        this.root = fileTree.getRoot();
    }

    public void add(FileNode fileNode) {
        if (root == null) {
            root = fileNode;
            size++;
        }else{
            add(root, fileNode);
        }
    }
    public void add(FileNode parentNode, FileNode fileNode) {
        int cmt = parentNode.getFileName().compareTo(fileNode.getFileName());
        if (cmt > 0) {
            if(parentNode.leftChild == null) {
                parentNode.leftChild = fileNode;
                size++;
            }
            else {
                add(parentNode.leftChild, fileNode);
            }
        }
        else if (cmt < 0) {
            if(parentNode.rightChild == null) {
                parentNode.rightChild = fileNode;
                size++;
            }
            else {
                add(parentNode.rightChild, fileNode);
            }
        }
        else {
            System.out.println("Can't add the file please change the file name");
        }
    }
    public void add(FileTree fileTree) {
        add(root, fileTree.getRoot());
    }

    public void print(){
        print(root, "");
    }
    public void print(FileNode fileNode, String indent) {
        if(fileNode != null){
            System.out.println(indent + fileNode.getFileName() );
            print(fileNode.leftChild, indent + "  ");
            print(fileNode.rightChild, indent + "  ");
        }
    }


}



