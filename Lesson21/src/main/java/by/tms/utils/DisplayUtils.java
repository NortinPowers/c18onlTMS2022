package by.tms.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DisplayUtils {
    public static String getEachEntryFromNewLine(@NonNull List<?> list) {
        return list.stream()
                .map(object -> object + "")
                .collect(Collectors.joining(",\n"));
    }
}