package by.tms;

import static by.tms.utils.DBUtils.SCRIPT_FILE_ADDRESS;
import static by.tms.utils.DBUtils.initScript;

public class Main {
    public static void main(String[] args) {
        initScript(SCRIPT_FILE_ADDRESS);
    }
}