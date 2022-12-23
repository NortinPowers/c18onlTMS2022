package by.tms;

import java.io.File;

import static by.tms.utils.FileHelper.LESSON_FILE_PATCH;
import static by.tms.utils.FileHelper.printFileStructureInfo;

public class MainTask1 {
    public static void main(String[] args) {
        File dir = new File(LESSON_FILE_PATCH);
        printFileStructureInfo(dir);
    }
}
