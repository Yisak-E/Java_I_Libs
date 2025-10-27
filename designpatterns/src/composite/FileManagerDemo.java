package composite;

import java.util.ArrayList;
import java.util.List;

public class FileManagerDemo {
    public static void main(String[] args) {
        FileManager root = new Folder("Root");
        FileManager file1 = new File("wonder.java");
        FileManager folder1 = new Folder("Downloads");
        FileManager file2 = new File("index.html");
        folder1.addFile(file2);
        root.addFile(folder1);
        root.addFile(file1);
        root.showFiles();
    }

}

interface FileManager{
    void addFile(FileManager file);
    void removeFile(FileManager file);
    void showFiles();
}

class File implements FileManager{
    FileManager file;
    String fileName;
    public File(String file){
        this.fileName = file;
    }
    @Override
    public void addFile(FileManager fileManager) {
        System.out.println(fileManager.toString());
    }
    @Override
    public void removeFile(FileManager fileName) {
        System.out.println(fileName);
    }
    @Override
    public void showFiles() {

        System.out.println("File name: " + fileName);
    }
    @Override
    public String toString() {
        return fileName;
    }
}

class Folder implements FileManager{
    String folderName;
    List<FileManager> _children ;
    public Folder(String folderName){
        this.folderName = folderName;
        _children = new ArrayList<>();
    }

    @Override
    public void addFile(FileManager fileOrFolder) {
        _children.add(fileOrFolder);
    }
    @Override
    public void removeFile(FileManager fileOrFolder) {
        _children.remove(fileOrFolder);
    }
    @Override
    public void showFiles() {
        System.out.println("Current Directory: " + folderName);
        for(FileManager file : _children){
            if(file instanceof Folder){
                System.out.println("|- [D]- "+ file.toString());
            }
            else{
                System.out.println("|- [f]- "+file.toString());
            }
        }
    }
    @Override
    public String toString() {
        return folderName;
    }
}
