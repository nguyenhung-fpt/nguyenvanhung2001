package com.example.nguyenvanhung_t2009a.servlet;

import com.example.nguyenvanhung_t2009a.dao.Phonedao;
import com.example.nguyenvanhung_t2009a.model.Phone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class PhoneServlet {
    private static final long serialVersionUID = 1;
    private Phonedao phoneDao;

    public void init() {
        Phonedao Phonedao = new Phonedao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertPhone(request, response);
                    break;
                default:
                    listPhones(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addphone.jsp");
        dispatcher.forward(request, response);
    }

    private void listPhones(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Phone> listPhone = Phonedao.selectAllPhones();
        request.setAttribute("listPhone", listPhone);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listphones.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPhone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        Phone newPhone = new Phone(name, brand, price, description);
        Phonedao.insertPhone(newPhone);
        response.sendRedirect("list");
    }
}
