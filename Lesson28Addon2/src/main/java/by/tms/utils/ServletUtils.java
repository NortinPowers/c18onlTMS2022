package by.tms.utils;

import by.tms.model.Poem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static by.tms.utils.Constant.ZERO;

@UtilityClass
public class ServletUtils {

    public static void setConfig(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
    }

    public static String getPoemName(File file, ObjectMapper objectMapper) {
        int maxValue = ZERO;
        List<Poem> poems = null;
        try {
            poems = objectMapper.readValue(file, new TypeReference<ArrayList<Poem>>() {
            });
            maxValue = poems.size();
        } catch (IOException e) {
            System.out.println("IOException (getRandomPoemName): " + e.getMessage());
        }
        return getRandomPoemName(maxValue, poems);
    }

    private String getRandomPoemName(int maxValue, List<Poem> poems) {
        Random random = new Random();
        if (maxValue > ZERO) {
            int number = random.nextInt(maxValue);
            return Objects.requireNonNull(poems).get(number).getName();
        } else {
            return null;
        }
    }
}