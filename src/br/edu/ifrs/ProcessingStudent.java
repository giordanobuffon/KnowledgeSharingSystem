package br.edu.ifrs;

import br.edu.ifrs.bean.Student;
import br.edu.ifrs.dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessingStudent", urlPatterns = "/ProcessingStudent")
public class ProcessingStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("operation");

        if (op.equalsIgnoreCase("INSERT")) insert(request, response);
        else if (op.equalsIgnoreCase("SEARCH")) search(request, response);
        else if (op.equalsIgnoreCase("DELETE")) delete(request, response);
        else if (op.equalsIgnoreCase("SELECT")) select(request, response);
        else if (op.equalsIgnoreCase("UPDATE")) update(request, response);
        else {
            request.setAttribute("msg", "Operação Inválida!!!");
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setEmail(request.getParameter("email"));
            student.setRegistration(Integer.parseInt(request.getParameter("registration")));
            student.setCourse(request.getParameter("course"));
            student.setSemester(request.getParameter("semester"));
            student.setCourse(request.getParameter("password"));


            StudentDAO.insert(student);

            RequestDispatcher r = request.getRequestDispatcher("success.jsp");
            r.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("student_id")));
            student.setName(request.getParameter("name"));
            student.setEmail(request.getParameter("email"));
            student.setRegistration(Integer.parseInt(request.getParameter("registration")));
            student.setCourse(request.getParameter("course"));
            student.setSemester(request.getParameter("semester"));
            student.setPassword(request.getParameter("password"));

            StudentDAO.update(student);

            RequestDispatcher r = request.getRequestDispatcher("success.jsp");
            r.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setRegistration(Integer.parseInt(request.getParameter("registration")));
            student.setPassword(request.getParameter("password"));

            Student students[] = StudentDAO.search(student);

            request.setAttribute("students", students);
            RequestDispatcher r = request.getRequestDispatcher(""); // TODO return of profile validation
            r.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("student_id")));

            Student s = StudentDAO.select(student);

            request.setAttribute("student", s);
            RequestDispatcher r = request.getRequestDispatcher("editProfile.jsp"); // TODO editProfile.jsp
            r.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("student_id")));

            StudentDAO.delete(student);

            RequestDispatcher r = request.getRequestDispatcher("success.jsp"); // TODO success.jsp
            r.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
