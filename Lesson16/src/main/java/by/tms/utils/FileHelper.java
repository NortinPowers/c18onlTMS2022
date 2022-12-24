package by.tms.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.Objects;

@UtilityClass
public class FileHelper {
    public static final String LESSON16_PATH = "Lesson16";
    public static final int FILE_MARK = 1;
    public static final int DIR_MARK = 0;

    private void fillFileStructure(@NonNull File dir, StringBuilder fileStructure) {
        int structureMark;
        if (dir.isDirectory()) {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                if (file.isDirectory()) {
                    structureMark = DIR_MARK;
                    fileStructure.append(getFileInfo(file, structureMark));
                    fillFileStructure(file, fileStructure);
                } else {
                    structureMark = FILE_MARK;
                    fileStructure.append(getFileInfo(file, structureMark));
                }
            }
        }
    }

    private String getFileInfo(@NonNull File file, int structureMark) {
        String type = structureMark == DIR_MARK ? "dir" : "file";
        return String.format("%-20s|%4s|\n", file.getName(), type);
    }

    public static String getFileStructureByPath(String path) {
        File dir = new File(path);
        StringBuilder fileStructure = new StringBuilder();
        fillFileStructure(dir, fileStructure);
        return fileStructure.toString();
    }
}
