package by.tms.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.Objects;

@UtilityClass
public class FileHelper {
    public static final String LESSON_FILE_PATH = "Lesson16";

    private static void printFileStructureInfo(@NonNull File dir) {
        if (dir.isDirectory()) {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                if (file.isDirectory()) {
                    System.out.println(getFileInfo(file));
                    printFileStructureInfo(file);
                } else {
                    System.out.println(getFileInfo(file));
                }
            }
        }
    }

    public String getFileInfo(@NonNull File file) {
        String type = file.isDirectory() ? "dir" : "file";
        return String.format("%-20s|%4s|", file.getName(), type);
    }

    public static void printFileStructureByPath(String path) {
        File dir = new File(path);
        printFileStructureInfo(dir);
    }
}
