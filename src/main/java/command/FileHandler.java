package command;

public class FileHandler {
    protected String file;
    public FileHandler(String file){
        this.file = file;
    }
    public String action() {
        return this.file;
    }
}
