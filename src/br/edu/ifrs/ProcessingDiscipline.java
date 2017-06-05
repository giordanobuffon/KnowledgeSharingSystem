package br.edu.ifrs;

import br.edu.ifrs.bean.Discipline;
import br.edu.ifrs.dao.DisciplineDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessingDiscipline", urlPatterns = "/ProcessingDiscipline")
public class ProcessingDiscipline extends HttpServlet {

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
            Discipline discipline = new Discipline();
            discipline.setDescription(request.getParameter("description"));
            discipline.setSemester(request.getParameter("semester"));

            DisciplineDAO.insert(discipline);

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
            Discipline discipline = new Discipline();
            discipline.setId(Integer.parseInt(request.getParameter("discipline_id")));
            discipline.setDescription(request.getParameter("description"));
            discipline.setSemester(request.getParameter("semester"));

            DisciplineDAO.update(discipline);

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
            Discipline discipline = new Discipline();
            discipline.setDescription(request.getParameter("description"));
            discipline.setSemester(request.getParameter("semester"));

            Discipline disciplines[] = DisciplineDAO.search(discipline);

            request.setAttribute("disciplines", disciplines);
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
            Discipline discipline = new Discipline();
            discipline.setId(Integer.parseInt(request.getParameter("discipline_id")));

            Discipline d = DisciplineDAO.select(discipline);

            request.setAttribute("discipline", d);
            RequestDispatcher r = request.getRequestDispatcher(".jsp"); // TODO <discipline>.jsp
            r.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher r = request.getRequestDispatcher("error.jsp"); // TODO error.jsp
            r.forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Discipline discipline = new Discipline();
            discipline.setId(Integer.parseInt(request.getParameter("discipline_id")));

            DisciplineDAO.delete(discipline);

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
