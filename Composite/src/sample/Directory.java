package sample;

import java.util.ArrayList;

public class Directory implements AbstractFile {
    private String name;
    private ArrayList includedFiles = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Object obj) {
        includedFiles.add(obj);
    }

    public void ls() {
        Controller.contentBuffer.append(Controller.spaceBuffer + name + "\n");

        Controller.spaceBuffer.append("   ");
        for (Object includedFile : includedFiles) {
            AbstractFile obj = (AbstractFile) includedFile;
            obj.ls();
        }
        Controller.spaceBuffer.setLength(Controller.spaceBuffer.length() - 3);
    }
}
