package ru.gva.SearchFile;

import java.io.File;
import java.util.ArrayList;

/**
 * В классе реализован поиск в файловой системе и сохранение результата поиска в array list
 *
 * @author Gavrikov V. 15it18.
 */

public class SearchFiles {
    public static ArrayList<String> resultTrueFile = new ArrayList<>();

    /**
     * Метод ищет файл или директорию и выводит абсоютный путь до него
     *
     * @param pathDirectory дирректория для поиска
     * @param searchMsg     запрос пользователя
     */
    public static void searchFiles(File pathDirectory, String searchMsg) throws NullPointerException {
        File[] files = pathDirectory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.getName().matches(searchMsg + ".{0,4}")) {
                resultTrueFile.add(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                searchFiles(file, searchMsg);
            }
        }
    }
}
