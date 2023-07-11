package Servlets;

import Beans.Empleado;
import Daos.EmpleadoDao;
import Daos.LoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "loginform": request.getParameter("a");
        RequestDispatcher view;

        switch (action){
            case "loginform":
                view = request.getRequestDispatcher("");
                view.forward(request, response);
                break;

            case "logout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/loginServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginDao loginDao = new LoginDao();

        String user = request.getParameter("inputUser");
        String password = request.getParameter("inputPassword");

        Empleado usuario = loginDao.validarNicknamePassword(user, password);

        if(usuario != null){
            HttpSession session = request.getSession();
            session.setAttribute("empleadoSession",usuario);
            response.sendRedirect(request.getContextPath() + "/mainServlet");

        } else {
            response.sendRedirect(request.getContextPath() + "/loginServlet?error");
        }

    }
}
