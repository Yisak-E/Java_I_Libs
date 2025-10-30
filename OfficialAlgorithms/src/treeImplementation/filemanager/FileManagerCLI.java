package treeImplementation.filemanager;

import java.util.Date;

public class FileManagerCLI {
    public static void main(String[] args) {
        Date date = new Date();
        FileMetaData data1 = new FileMetaData(date, 234.3);
        FileNode file1 = new FileNode("Downloads",  true, data1);

        FileTree folderC = new FileTree();
        folderC.add(file1);
        folderC.add(new FileNode("Photos",  true, new FileMetaData(date ,34.45)));
        folderC.add(new FileNode("Documents",  true, new FileMetaData(date ,24.3)));
        folderC.add(new FileNode("Videos",  true, new FileMetaData(date ,2500.3)));

        folderC.print();

    }
}
