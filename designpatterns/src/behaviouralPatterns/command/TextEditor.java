package behaviouralPatterns.command;

import java.util.Stack;

public class TextEditor {
    public static void main(String[] args) {

        Document doc = new Document();
        Editor editor = new Editor();
        editor.executeCommand(new AddTextCommand(doc, "Holla", 0));
        System.out.println(doc.getContent());
        editor.executeCommand(new AddTextCommand(doc, "Holla", 4));
        System.out.println(doc.getContent());
        editor.undo();
        System.out.println(doc.getContent());
        editor.undo();
        System.out.println(doc.getContent());
        editor.redo();
        System.out.println(doc.getContent());


    }


}




// command interface
interface Command{
    void execute();
}

interface UndoableCommand extends Command{
    void undo();
}


// Receiver
class Document{
    private StringBuilder content = new StringBuilder();

    public void insert(int position, String text){
        content.insert(position, text);
    }

    public void delete(int start, int end){
        content.delete(start, end);
    }
    public void replace(int start, int end, String text){
        content.replace(start, end, text);
    }

    public void append(String text){
        content.append(text);
    }

    public void clear(){
        content.setLength(0);
    }

    public String getContent(){
        return content.toString();
    }
}



//concrete command
class AddTextCommand implements UndoableCommand {
    private Document document;
    private String addedText;
    private int position;

    public AddTextCommand(Document document, String addedText, int position){
        this.document = document;
        this.addedText = addedText;
        this.position = position;
    }

    @Override
    public void execute() {
        document.insert(position, addedText);
    }

    @Override
    public void undo() {
        document.delete(position, position+addedText.length());
    }

}

class DeleteTextCommand implements UndoableCommand {
    private Document document;
    private int start, end;
    private String deletedText;
    public DeleteTextCommand(Document document, int start, int end){
        this.document = document;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        deletedText =  document.getContent().substring(start, end);
        document.delete(start, end);
    }
    @Override
    public void undo() {
        document.insert(start, deletedText);
    }
}

class ReplaceTextCommand implements UndoableCommand {
    private Document document;
    private int start, end;
    private String newText;
    private String  oldText;
    public ReplaceTextCommand (Document document, int start, int end, String newText){
        this.document = document;
        this.start = start;
        this.end = end;
        this.newText = newText;
    }
    @Override
    public void execute() {
        oldText = document.getContent().substring(start, end);
        document.replace(start, end, newText);
    }

    @Override
    public void undo() {
        document.replace(start, start+newText.length(), oldText);
    }
}

class AppendTextCommand implements UndoableCommand {
    private Document document;
    private String newText;
    public AppendTextCommand(Document document, String newText){
        this.document = document;
        this.newText = newText;
    }
    @Override
    public void execute() {
        document.append(newText);
    }
    @Override
    public void undo() {
        int start = document.getContent().length()-newText.length();
        document.delete(start, start+newText.length());
    }
}


// Invoker

class Editor{
   private Stack<UndoableCommand> undoStack = new Stack<>();
   private Stack<UndoableCommand> redoStack = new Stack<>();
   public Editor(){

   }

   public void executeCommand(UndoableCommand command){
       command.execute();
       undoStack.push(command);
       redoStack.clear();
   }

   public void undo(){
       if(!undoStack.isEmpty()){
           UndoableCommand command = undoStack.pop();
           command.undo();
           redoStack.push(command);
       }else{
           System.out.println("Nothing to undo");
       }
   }

   public void redo(){
       if(!redoStack.isEmpty()){
           UndoableCommand command = redoStack.pop();
           command.execute();
           undoStack.push(command);
       }else{
           System.out.println("Nothing to redo");
       }
   }

}

