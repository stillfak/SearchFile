package ru.gva.SearchFile;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

import static ru.gva.SearchFile.SearchFiles.resultTrueFile;
import static ru.gva.SearchFile.SearchFiles.searchFiles;

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
    private TextField searchMsg;//  поле ввода запроса

    @FXML
    private Button changeStartDir;// кнопка изменение стартовой папки по умолчанию /home/vadim

    @FXML
    static Button search;// кнопка запуска поиска

    @FXML
    private Label path;// кнопка выведет путь к стартовой папки


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
        FlowPane flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
//        gridPane.setAlignment(Pos.TOP_CENTER);
        File startDir;
        if (path.getText().equals("")){
            startDir = new File("/home/vadim");
        }else {
            startDir = new File(path.getText());
        }
        searchFiles(startDir, String.valueOf(searchMsg.getCharacters()));
//        flowPane.getChildren().add(new GridPane().add(new ButtonOpenDesktop("asd"),0,0));
        for (String str : resultTrueFile) {
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
//

//            label = new Label(str);
//            label.setLayoutY(y);
//            borderPane.getChildren().addAll(label);
            flowPane.getChildren().add(new Label(str));
//            System.out.println(label.getText());
//            gridPane.setHgap(y);
//            y = -20;

        }

//        label1.setAlignment(Pos.CENTER);
//        gridPane.getChildren().addAll(label1);
//        System.out.println(resultTrueFile.size());
        resultStage.setScene(new Scene(flowPane, 500, 700));
        resultStage.show();


    }




}

