import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TodoApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Main Container (The "Phone" Screen)
        VBox root = new VBox(20);
        root.getStyleClass().add("main-container");

        // Header
        Label header = new Label("Today");
        header.getStyleClass().add("header-text");

        // Task List (mimicking a TableView or ListView)
        ListView<String> todoList = new ListView<>();
        todoList.getItems().addAll("Buy groceries", "Finish Java project", "Call Mom");

        // Input Area
        HBox inputArea = new HBox(10);
        TextField taskInput = new TextField();
        Button addButton = new Button("+");
        addButton.setOnAction(e -> {
            if(!taskInput.getText().isEmpty()) todoList.getItems().add(taskInput.getText());
        });
        inputArea.getChildren().addAll(taskInput, addButton);

        root.getChildren().addAll(header, todoList, inputArea);

        Scene scene = new Scene(root, 350, 600);
        scene.getStylesheets().add("style.css"); // Where the magic happens
        
        primaryStage.setTitle("iTodo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}