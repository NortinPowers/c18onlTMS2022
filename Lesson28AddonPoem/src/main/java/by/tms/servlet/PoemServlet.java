package by.tms.servlet;

import by.tms.model.Poem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static by.tms.utils.Constants.PATCH_TO_JSON;
import static by.tms.utils.Constants.ZERO;

@WebServlet("/poem")
public class PoemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getRandomPoemName();
        String poem = getPoemFromFile(name);
        if (poem != null) {
            req.setAttribute("poem", poem);
            forward(req, resp, "/poem.jsp");
        } else {
            forward(req, resp, "/noPoem.jsp");
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
    }

    private String getPoemFromFile(String name) {
        try {
            return new String(getServletContext().getResourceAsStream("/WEB-INF/classes/poems/" + name + ".txt").readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("IOException (getPoem): " + e.getMessage());
        }
        return null;
    }

    private String getRandomPoemName() {
        File file = getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        return getPoemName(file, objectMapper);
    }

    private File getFile() {
        String path = getServletContext().getRealPath(PATCH_TO_JSON);
        return new File(path);
    }

    private String getPoemName(File file, ObjectMapper objectMapper) {
        List<Poem> poems;
        try {
            poems = objectMapper.readValue(file, new TypeReference<ArrayList<Poem>>() {
            });
            Random random = new Random();
            if (Objects.requireNonNull(poems).size() > ZERO) {
                int number = random.nextInt(poems.size());
                return poems.get(number).getName();
            }
        } catch (IOException e) {
            System.out.println("IOException (getRandomPoemName): " + e.getMessage());
        }
        return null;
    }
}