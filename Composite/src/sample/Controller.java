package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    public TextArea folderTree;
    public TextField directoryName;
    public TextField fileName;
    public Label errorLabel;

    private ArrayList<Directory> directories = new ArrayList<Directory>();
    public static StringBuffer spaceBuffer = new StringBuffer();
    public static StringBuffer contentBuffer = new StringBuffer();

    Directory rootDirectory;

    public void initialize() {
        errorLabel.setVisible(false);
        rootDirectory = new Directory("MUSIC");
        directories.add(rootDirectory);

        updateTextArea();
    }

    //1 - добавляем файл в директорию, 2 - добавляем директорию в директорию
    private boolean addNewFileIntoDirectory(String directory, String file, int fileOrDirectory) {
        for (Directory d : directories) {
            if (d.getName().equals(directory)) {
                if (fileOrDirectory == 1) {
                    File newFile = new File(file);
                    d.add(newFile);
                    return true;
                } else if (fileOrDirectory == 2) {
                    Directory newDirectory = new Directory(file);
                    d.add(newDirectory);
                    directories.add(newDirectory);
                    return true;
                }
            }
        }
        return false;
    }

    private void showError() {
        errorLabel.setVisible(true);
        errorLabel.setText("Такой дирерктории не существует!");
    }

    public void addFile(ActionEvent actionEvent) {
        errorLabel.setVisible(false);
        if (!addNewFileIntoDirectory(directoryName.getText(), fileName.getText(), 1)) {
            showError();
        }
        updateTextArea();
    }

    public void addDirectory(ActionEvent actionEvent) {
        errorLabel.setVisible(false);
        if (!addNewFileIntoDirectory(directoryName.getText(), fileName.getText(), 2)) {
            showError();
        }
        updateTextArea();
    }

    private void updateTextArea() {
        contentBuffer.setLength(0);
        rootDirectory.ls();
        folderTree.clear();
        folderTree.appendText(contentBuffer.toString());
    }
}
