package Servlets;

import Beans.Empleado;
import Daos.EmpleadoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "principal" : request.getParameter("a");
        RequestDispatcher view;

        EmpleadoDao empleadoDao = new EmpleadoDao();
        HttpSession session = request.getSession();
        Empleado empleado = (Empleado) session.getAttribute("empleadoSession");

        switch (action){
            case "principal":
                /* Cambiar según la lista requerida:
                request.setAttribute("listaViajes", viajeDao.listarViaje(empleado.getIdEmpleado()));
                 */
                request.setAttribute("usuarioActual", empleadoDao.obtenerEmpleado(empleado.getIdEmpleado()));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("principal.jsp");
                requestDispatcher.forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
