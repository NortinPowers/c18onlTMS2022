package by.tms.utils;

import java.util.Collection;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}