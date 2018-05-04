package ru.gva.SearchFile;

import java.awt.*;
import java.io.File;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {
    File startDirectory;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField searchMsg;

    @FXML
    private Button changeStartDir;

    @FXML
    static Button search;

    @FXML
    private Label path;


    @FXML
    void initialize() {

        changeStartDir.setOnAction(event -> {
            DirectoryChooser directory = new DirectoryChooser();
            directory.setTitle("Select directory for changeStartDir");
            startDirectory = new File(String.valueOf(directory.showDialog(new Stage())));

            if (startDirectory.getAbsolutePath() != null) {

                path.setText(startDirectory.getAbsolutePath());
            } else {
                path.setText("");
            }

        });

//        Stage st = FXMLLoader.load(location);
//        Stage resultStage =
//        Stage resultStage = FXMLLoader.load(location,resources);

//        search.setOnAction(event -> {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            Scene resultScene = null;
//            try {
//                resultScene = new Scene(FXMLLoader.load(getClass().getResource("/ru/gva/SearchFile/res/resultSearch.fxml")));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


//                Main.resultStage.setScene(new Scene(stageResultSearch));
//                Main.resultStage.show();
//            st.setScene(stageResultSearch);
//            resultStage.setScene(new Scene(stageResultSearch));


    }


    @FXML
    public void start() throws NullPointerException {

//        Scene resultScene = null;
//        try {
//            resultScene = new Scene(FXMLLoader.load(getClass().getResource("/ru/gva/SearchFile/res/resultSearch.fxml")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        resultController = new ResultController(String.valueOf(searchMsg.getCharacters()), startDirectory);

        Stage resultStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        ArrayList<Label> result = searchFiles(new File(path.getText()), String.valueOf(searchMsg.getCharacters()));
        int y=0;
        for (Label label : result) {
//            button.setOnAction(event -> {
//                Desktop desktop = null;
//                if (desktop.isDesktopSupported()) {
//                    desktop = Desktop.getDesktop();
//                    try {
//                        desktop.open(new File(button.getPath()));
//                    } catch (IOException e) {
//                        e.getStackTrace();
//                    }
//                }
//            });
            gridPane.getChildren().addAll(label);
            System.out.println(label.getText());
            gridPane.setVgap(y);
            y=+20;

        }
        System.out.println(result.size());
        resultStage.setScene(new Scene(gridPane, 500, 700));
        resultStage.show();


//        resultController.setTitle("Результат");
//        resultController.setScene(resultScene);
//        resultController.setAlwaysOnTop(true);
//        resultController.show();
//        resultController.initialize();

    }

    /**
     * Метод ищет файл или директорию и выводит абсоютный путь до него
     *
     * @param pathDirectory дирректория для поиска
     * @param searchMsg     запрос пользователя
     */
    private static ArrayList searchFiles(File pathDirectory, String searchMsg) throws NullPointerException {
        File[] files = pathDirectory.listFiles();
        assert files != null;
        ArrayList<Label> resultTrueFile = new ArrayList<>();

        for (File file : files) {
            if (file.getName().matches(searchMsg + ".{0,4}")) {

                resultTrueFile.add(new Label(file.getAbsolutePath()));

//                resultTrueFile.get(resultTrueFile.size()-1).setText("Открыть");
            }
            if (file.isDirectory()) {
                searchFiles(file, searchMsg);
            }
        }
        return resultTrueFile;

    }

//    public static void main(String[] args) {

//
//    }


}

