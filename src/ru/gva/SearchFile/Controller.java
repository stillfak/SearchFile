package ru.gva.SearchFile;

import java.io.File;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField searchMsg;

    @FXML
    private Button changeStartDir;

    @FXML
    private Button search;

    @FXML
    private Label path;

    private Stage resultStage = (Stage) root.getScene().getWindow();


    @FXML
    void initialize() {
        search.setOnAction(event -> {
//            try {
//                Parent stageResultSearch = FXMLLoader.load(getClass().getResource("/ru/gva/SearchInFile/res/resultSearch.fxml"));

//                resultStage.setScene(new Scene(stageResultSearch));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });
    }

//    public static void main(String[] args) {
//        Desktop desktop = null;
//        if (desktop.isDesktopSupported()){
//            desktop = Desktop.getDesktop();
//            try{
//                desktop.open(new File("/home/vadim/Документы/MyServer"));
//            } catch (IOException e){
//                System.out.println("gg");
//            }
//        }
//
//    }

    /**
     * Метод ищет файл определеного типа в определенной
     * ветке файловой системы и вызывает создает
     * экземпляр класса(наследник thread) и запускает его
     *
     * @param pathDirectory дирректория для поиска
     * @param searchMsg     запрос пользователя
     */
    private static void searchFiles(File pathDirectory, String searchMsg) {
        File[] files = pathDirectory.listFiles();
        assert files != null;
//        ArrayList<SearchInFiles> searchInFiles = new ArrayList<>();
        try {
            for (File file : files) {
//                assert file != null;
                if (file.isFile() && file.getName().matches(searchMsg)) {
//                    searchInFiles.add(new SearchInFiles(file, searchMsg));
//                    assert searchInFiles.get(searchInFiles.size()-1) != null;
//                    searchInFiles.get(searchInFiles.size() - 1).start();
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {

                    searchFiles(file, searchMsg);
                }
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }finally {
////            return searchInFiles;
        }

    }
}
