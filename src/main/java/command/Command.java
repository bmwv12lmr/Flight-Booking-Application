package command;

abstract public class Command{
    protected FileHandler fileHandler;

    public Command(FileHandler fileHandler){
        this.fileHandler = fileHandler;
    }
    public abstract void execute();
}
