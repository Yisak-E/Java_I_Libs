package treeImplementation.filemanager;

public class FileNode {
    private  String fileName;
    private boolean isFolder;
    private FileMetaData fileData;

    FileNode leftChild;
    FileNode rightChild;

    public FileNode(String fileName, boolean isFolder, FileMetaData fileData) {
        this.fileName = fileName;
        this.isFolder = isFolder;
        this.fileData = fileData;
        this.leftChild = null;
        this.rightChild = null;
    }
    public FileNode(String fileName, boolean isFolder) {
        this.fileName = fileName;
        this.isFolder = isFolder;
        this.fileData = null;
        this.leftChild = null;
        this.rightChild = null;
    }
    public FileNode(String fileName) {
        this.fileName = fileName;
        this.isFolder = false;
        this.fileData = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public FileMetaData getFileData() {
        return fileData;
    }

    public void setFileData(FileMetaData fileData) {
        this.fileData = fileData;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
