package org.example;

public final class Utils {

    private Utils() {
    }

    /**
     * The method returns information from the array in a form that is convenient for perception
     */
    public static String convertsToString(Object[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "";
        }
        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(' ').toString();
            }
            b.append("  ");
        }
    }

}
