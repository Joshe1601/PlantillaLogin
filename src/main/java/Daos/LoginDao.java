package Daos;

import Beans.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends BaseDao {
    public Empleado validarNicknamePassword(String nickname, String password){
        Empleado empleado = null;
        EmpleadoDao empleadoDao = new EmpleadoDao();

        /*Cambiar el String según conveniencia*/
        String sql = "SELECT * FROM Empleado WHERE dni = ?";
        /*Cambiar el String según conveniencia*/
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nickname);

            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    int idEmpleado = rs.getInt(1);
                    empleado = empleadoDao.obtenerEmpleado(idEmpleado);
                    float validacion = (float) Float.parseFloat(empleado.getDni());

                    if(validacion != Float.parseFloat(password)){

                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la búsqueda");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return empleado;
    }
}
