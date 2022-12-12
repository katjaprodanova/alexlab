package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateStudentServlet", value = "/CreateStudent")
public class CreateStudentServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;

    public CreateStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request,response,request.getServletContext());
        context.setVariable("creationMode",1);
        this.springTemplateEngine.process("listStudents.html",context,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentUserName = (String)request.getParameter("username");
        String studentName = (String)request.getParameter("name");
        String studentSurname = (String)request.getParameter("surname");
        String studentPassword = (String)request.getParameter("password");
        this.studentService.save(studentUserName,studentPassword,studentName,studentSurname);
        response.sendRedirect("/AddStudent");

    }
}
