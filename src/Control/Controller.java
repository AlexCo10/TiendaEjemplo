/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionListener;

import Modelo.Producto;
import Servicios.Conexion;
import Servicios.ProductoServicios;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Controller implements ActionListener{
    
    private Producto prod;
    private ProductoServicios ps;
    private frmProducto f;
    

    public Controller(Producto prod, ProductoServicios ps, frmProducto f) {
        this.prod = prod;
        this.ps = ps;
        this.f = f;
        this.f.btnGuardar.addActionListener(this);
        this.f.btnModificar.addActionListener(this);
        this.f.btnEliminar.addActionListener(this);
        this.f.btnLimpiar.addActionListener(this);
        this.f.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
    
    f.setTitle("Productos");
    f.setLocationRelativeTo(null);
    f.txtId.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==f.btnGuardar){
            
            System.out.println("estoy guardando");
            prod.setCodigo(f.txtCodigo.getText());
            prod.setNombre(f.txtNombre.getText());
            prod.setPrecio(Double.parseDouble(f.txtPrecio.getText()));
            prod.setCantidad(Integer.parseInt(f.txtCantidad.getText()));
            
            try {
                ps.guardarProducto(prod);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
        } /*else if(e.getSource()==f.btnLimpiar){
            f.txtId.setText("");
            f.txtCodigo.setText("");
            f.txtNombre.setText("");
            f.txtPrecio.setText("");
            f.txtCantidad.setText("");
            
        } else if(e.getSource()==f.btnModificar){
           prod.setId(Integer.parseInt(f.txtId.getText()));
           prod.setCodigo(f.txtCodigo.getText());
           prod.setNombre(f.txtNombre.getText());
           prod.setPrecio(Double.parseDouble(f.txtPrecio.getText()));
           prod.setCantidad(Integer.parseInt(f.txtCantidad.getText()));
    
    } else if(e.getSource()==f.btnEliminar){
           prod.setId(Integer.parseInt(f.txtId.getText()));
           }
        
        else if(e.getSource()==f.btnBuscar){
           prod.setCodigo(f.txtCodigo.getText());
           }*/


    }
}
