/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductoServicios {
   
    public void guardarProducto(Producto pro) throws SQLException{
      try{
         Connection conexion = Conexion.obtener();
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("INSERT INTO producto (codigo, nombre, precio, cantidad) "
                 + "VALUES(?, ?, ?,?)");        
         consulta.setString(1, pro.getCodigo());
         consulta.setString(2, pro.getNombre());
         consulta.setDouble(3, pro.getPrecio());
         consulta.setInt(4, pro.getCantidad());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
     public void modificarProducto(Connection conexion, Producto pro) throws SQLException{
      try{
          
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("UPDATE producto SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?");
                  
         consulta.setString(1, pro.getCodigo());
         consulta.setString(2, pro.getNombre());
         consulta.setDouble(3, pro.getPrecio());
         consulta.setInt(4, pro.getCantidad());
         consulta.setInt(5, pro.getId());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   
     public void eliminarProducto(Connection conexion, Producto pro) throws SQLException{
      try{
          
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("DELETE FROM producto WHERE id=?");
                  
        consulta.setInt(1, pro.getId());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
     
        public Boolean buscarProducto(Connection conexion, Producto pro) throws SQLException{
      try{
          
         PreparedStatement consulta;
         ResultSet rs=null;
         consulta = conexion.prepareStatement("SELECT * FROM producto WHERE cod=?");
           
         consulta.setString(1, pro.getCodigo());
         rs=consulta.executeQuery();
          
         if(rs.next()){
         pro.setId(Integer.parseInt(rs.getString("id")));
         pro.setCodigo(rs.getString("codigo"));
         pro.setCodigo(rs.getString("nombre"));
         pro.setPrecio(Double.parseDouble(rs.getString("precio")));
         pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
         return true;
         }
      
         return false;
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
}
