package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            //criando uma conexao
            conn = DB.getConnection();
            //instanciando conexaão statemant
            st = conn.createStatement();
            //executando uma ação em sql. Ação para recuperar o dado
            rs = st.executeQuery("SELECT * FROM department");

            while(rs.next()){
                //delimitando o id e o name para serem adicionados aqui
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
