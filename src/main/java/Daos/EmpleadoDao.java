package Daos;

import Beans.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDao extends BaseDao {
    public Empleado obtenerEmpleado(int idEmpleado){

        Empleado empleado = null;

        String sql = "SELECT * FROM trabajadores WHERE idTrabajador = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, idEmpleado);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt(1));
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setDni(rs.getString(4));
                empleado.setSalario(rs.getBigDecimal(5));
                empleado.setFechaContrato(rs.getString(6));
                empleado.setNombreUsuario(rs.getString(7));
                empleado.setEdad(rs.getInt(8));

            }

        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        return empleado;
    }
}
