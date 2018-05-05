package ru.gva.SearchFile.test;

import org.junit.Test;
import ru.gva.SearchFile.Controller;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    @Test
    public void initialize() {
//        File expected = new File("/home/vadim/Документы/SearchInFile");

//        assertEquals(expected, new File("/home/vadim/Документы/SearchInFile"));
    }

    @Test
    public void start() {
        assertEquals(Controller.searchFiles(new File("/home/vadim/Документы/SearchInFile"),"src").get(0),"/home/vadim/Документы/SearchInFile/src");
    }
}