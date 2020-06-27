package sample;

public class File implements AbstractFile {
    private String name;

    @Override
    public void ls() {
        Controller.contentBuffer.append(Controller.spaceBuffer + name + "\n");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public File(String name) {
        this.name = name;
    }
}
