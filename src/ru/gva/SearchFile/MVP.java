package ru.gva.SearchFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * В класссе реализован MVP для проекта Поиск файла в файловой системе
 * MVP
 * интерфейс - консольный
 * Ввод - с клавиатуры
 * алгоритм поиска файла или директории с искомым именем и + до 4 любых символов.
 *
 * @author Gavrikov V. 15it18.
 */

public class MVP {
    private static BufferedReader readline = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь откуда начать поиск");
        String startDirectory = readline.readLine();
        System.out.println("Введите что искать");
        String searchFile = readline.readLine();
        searchFiles(new File(startDirectory), searchFile);


    }

    /**
     * Метод ищет файл или директорию и выводит абсоютный путь до него
     *
     * @param pathDirectory дирректория для поиска
     * @param searchMsg     запрос пользователя
     */
    private static void searchFiles(File pathDirectory, String searchMsg) {
        File[] files = pathDirectory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.getName().matches(searchMsg + ".{0,4}")) {
                System.out.println(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                searchFiles(file, searchMsg);
            }
        }


    }
}
