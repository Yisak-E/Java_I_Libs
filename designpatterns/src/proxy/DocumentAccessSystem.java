package proxy;

public class DocumentAccessSystem {
    public static void main(String[] args) {
        System.out.println("Proxy document view system");
        Document proxyUser = new SecureDocumentProxy("secret_plan.pdf", "unknown");
        proxyUser.displayContent();

        Document proxyUser2 = new SecureDocumentProxy("secret_plan.pdf", "President Thomson");
        proxyUser2.displayContent();
    }
}

interface Document{
    void displayContent();
    String getTitle();
}

class RealDocument implements Document{
    private String title;
    private String content;

    public RealDocument(String title){
        this.title = title;
       loadFromDatabase();
    }

    public void loadFromDatabase(){
        System.out.println("Loading "+title+" from database");
        this.content = "Content of "+ title;
    }
    @Override
    public void displayContent() {
        System.out.println("📄" + title +": "+  content);
    }
    @Override
    public String getTitle() {
        return title;
    }
}

class SecureDocumentProxy implements Document{
    private Document document;
    private String fileName;
    private String currentUser;
    public SecureDocumentProxy(String fileName, String currentUser){
        this.currentUser = currentUser;
        this.fileName = fileName;
    }
    @Override
    public void displayContent() {
        if(document==null){
           document = new RealDocument(fileName);
        }
        if(currentUser.equalsIgnoreCase("unknown")){
            System.out.println("Un Authorized user");
            return;
        }
        document.displayContent();
    }
    @Override
    public String getTitle() {
        return document.getTitle();
    }
}