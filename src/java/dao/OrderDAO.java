/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Order;

/**
 *
 * @author Nết
 */
public class OrderDAO extends DBContext {

    public void insertOrderByAid(Order o) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([aid]\n"
                + "           ,[date]\n"
                + "           ,[totalmoney]\n"
                + "           ,[address]\n"
                + "           ,[phone]\n"
                + "           ,[note]\n"
                + "           ,[name])\n"
                + "     VALUES\n"
                + "           (?,GETDATE(),?,?,?,?,?)";
        try {
             PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, o.getAid());
            st.setDouble(2, o.getTotalmoney());
            st.setString(3, o.getAddress());
            st.setString(4, o.getPhone());
            st.setString(5, o.getNote());
            st.setString(6, o.getName());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
      public int getLastOrderId(){
        String sql="SELECT MAX( [id])\n" +
            "  FROM [Order]";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException e){
        }
        return 0;
    }
}
