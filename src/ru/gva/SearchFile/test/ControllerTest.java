package ru.gva.SearchFile.test;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static ru.gva.SearchFile.SearchFiles.resultTrueFile;
import static ru.gva.SearchFile.SearchFiles.searchFiles;

public class ControllerTest {

    @Test
    public void initialize() {
//        File expected = new File("/home/vadim/Документы/SearchInFile");
//        assertEquals(expected, new File("/home/vadim/Документы/SearchInFile"));
    }

    @Test
    public void start() {
        searchFiles(new File("/home/vadim/Документы/SearchInFile"),"src");
        assertEquals(resultTrueFile.get(0),"/home/vadim/Документы/SearchInFile/src");
    }
}