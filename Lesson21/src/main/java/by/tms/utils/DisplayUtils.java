package by.tms.utils;

import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DisplayUtils {

    public static String getEachEntryFromNewLine(@NonNull List<?> list) {
        return list.stream()
                   .map(Object::toString)
                   .collect(Collectors.joining(",\n"));
    }
}