package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="SubResourceServlet",
        urlPatterns = "/resource/*"
)
public class SubResourceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String pathInfo = req.getPathInfo(); // /{value}/test
        String[] pathParts = pathInfo.split("/");

        String part1 = null;
        try{
            if(pathParts[1] != null) {
                part1 = pathParts[1]; // {value}
            }
        } catch (Exception e) {
            part1 = null;
        }

        String part2 = null;
        try{
            if(pathParts[2] != null) {
                part2 = pathParts[2]; // {value}
            }
        } catch (Exception e) {
            part2 = null;
        }

        String part3 = null;
        try{
            if(pathParts[3] != null) {
                part3 = pathParts[3]; // {value}
            }
        } catch (Exception e) {
            part3 = null;
        }


        res.setContentType("text/html; charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = res.getWriter();

        // Write the response message, in an HTML page
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>SubResource Servlet</title></head>");
            out.println("<body><h2>You have entered</h2>");
            if(part1==null || part1.trim()==""){
                out.println("<p>ResourceId: MISSING</p>");
            } else {
                out.println("<p> Resource Id: " + part1 + "</p>");
                if(part2==null || part2.trim()=="") {
                    out.println("<p>SubResource Requested: MISSING </p>");
                } else {
                    out.println("<p> SubResource Requested: " + part2 + "</p>");
                    if(part3==null || part3.trim()=="") {
                        out.println("<p>SubResource Id: MISSING </p>");
                    } else {
                        out.println("<p> SubResource Id is: " + part3 + "</p>");
                    }
                }
            }
            out.println("</body></html>");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            out.close();
        }

    }
}
