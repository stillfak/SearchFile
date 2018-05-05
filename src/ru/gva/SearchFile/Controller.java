package ru.gva.SearchFile;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

/**
 * Класс отлеживает действие пользователя с графическим интерфейсом.
 *
 * @author Gavrikov V. 15it18
 */
public class Controller {
    private File startDirectory;

    //@FXML
    //private ResourceBundle resources;

    //@FXML
    //private URL location;

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

//            startDirectory.getAbsolutePath();

            path.setText(startDirectory.getAbsolutePath());

        });


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
        ArrayList<String> result = searchFiles(new File(path.getText()), String.valueOf(searchMsg.getCharacters()));
        int y=0;
        for (String label : result) {
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
            gridPane.getChildren().addAll(new Label(label));
//            System.out.println(label.getText());
            gridPane.setVgap(y);
            y=+20;

        }
        System.out.println(result.size());
        resultStage.setScene(new Scene(gridPane, 500, 700));
        resultStage.show();




    }

    /**
     * Метод ищет файл или директорию и выводит абсоютный путь до него
     *
     * @param pathDirectory дирректория для поиска
     * @param searchMsg     запрос пользователя
     */
    public static ArrayList<String> searchFiles(File pathDirectory, String searchMsg) throws NullPointerException {
        File[] files = pathDirectory.listFiles();
        assert files != null;
        ArrayList<String> resultTrueFile = new ArrayList<>();
//        Label addInArray = new Label();
        for (File file : files) {
            if (file.getName().matches(searchMsg + ".{0,4}")) {
//                addInArray = new Label(file.getAbsolutePath());
//                assert addInArray != null;
                resultTrueFile.add(file.getAbsolutePath());

//                resultTrueFile.get(resultTrueFile.size()-1).setText("Открыть");
            }
            if (file.isDirectory()) {
                searchFiles(file, searchMsg);
            }
        }
        return resultTrueFile;

    }




}

