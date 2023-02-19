package by.tms.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static by.tms.utils.Constant.PATCH_TO_JSON;
import static by.tms.utils.ServletUtils.getPoemName;
import static by.tms.utils.ServletUtils.setConfig;

@WebServlet("/poem")
public class PoemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setConfig(req, resp);
        String name = getRandomPoemName();
        String poem = getPoem(name);
        req.setAttribute("poem", poem);
        req.getServletContext().getRequestDispatcher("/poem.jsp").forward(req, resp);
    }

    private String getPoem(String name) {
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
}