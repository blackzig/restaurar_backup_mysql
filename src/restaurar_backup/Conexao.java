/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurar_backup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author michel
 */
public class Conexao {

    static Connection con=null;

 public static Connection conectar(){
    try {

        con = DriverManager.getConnection("jdbc:mysql://localhost/esporte","root","");
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return con;
    }

}
