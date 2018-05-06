package ru.gva.SearchFile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene root = new Scene(FXMLLoader.load(getClass().getResource("/ru/gva/SearchFile/res/root.fxml")));
        primaryStage.setTitle("Поиск");

        primaryStage.setScene(root);

//        primaryStage.setScene();
        primaryStage.show();

//        Thread.sleep(10000);
//        root.setRoot(FXMLLoader.load(getClass().getResource("/ru/gva/SearchFile/res/resultSearch.fxml")));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
