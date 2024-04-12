package com.example.plant;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List; // Ensure this import is present

public class HelloController {
    @FXML
    private Label plantNameLabel;
    @FXML
    private ListView<String> tasksList;
    @FXML
    private TextField taskInput;
    @FXML
    private Button addTaskButton;
    @FXML
    private VBox imagesBox; // VBox to hold multiple images

    @FXML
    protected void onAddTaskButtonClick() {
        if (!taskInput.getText().isEmpty()) {
            tasksList.getItems().add(taskInput.getText());
            taskInput.clear();
        }
    }

    @FXML
    protected void onUploadImageButtonClick() {
        FileChooser fileChooser = new FileChooser();
        // Set extension filters for images
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);

        // Allow multiple selections
        List<File> files = fileChooser.showOpenMultipleDialog(null);
        if (files != null) {
            for (File file : files) {
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100); // Set the width of the image view
                imageView.setPreserveRatio(true); // Preserve image ratio
                imagesBox.getChildren().add(imageView); // Add to the VBox
            }
        }
    }
}
