package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FilePaths {
    public static final String INPUT_T1 = "Lesson15/src/main/resources/files/task1/input.txt";
    public static final String INPUT_T1_NAME = INPUT_T1.substring(INPUT_T1.lastIndexOf("i"));
    public static final String OUTPUT_T1 = "Lesson15/src/main/resources/files/task1/output.txt";
    public static final String OUTPUT_T1_NAME = OUTPUT_T1.substring(OUTPUT_T1.lastIndexOf("o"));
    public static final String TASK1_PACKAGE = "Lesson15/src/main/resources/files/task1";
}
