/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Control.Controller;
import Modelo.Producto;
import Servicios.ProductoServicios;
import Vista.frmProducto;

/**
 *
 * @author CarlosReneAngarita
 */
public class CRUDmvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Producto pro = new Producto();
       ProductoServicios ps=new ProductoServicios();
       frmProducto f = new frmProducto();
       
       Controller ctrl = new Controller(pro, ps, f);
       ctrl.iniciar();
       f.setVisible(true);
       
    }
    
}
