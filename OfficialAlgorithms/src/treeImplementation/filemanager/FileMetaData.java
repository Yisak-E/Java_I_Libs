package treeImplementation.filemanager;

import java.util.Date;

public class FileMetaData {
    private Date creationDate;
    private double size;

    public FileMetaData() {

    }
    public FileMetaData(Date creationDate, double size) {
        this.creationDate = creationDate;
        this.size = size;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }

}
