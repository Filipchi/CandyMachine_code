package test;

import componentes.Producto;
import maquina.MaquinaDulces;

public class TestVender {

	public static void main(String[] args) {

		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda("A");
		maquina.agregarCelda("B");
		maquina.agregarCelda("C");
		maquina.agregarCelda("D");

        maquina.cargarProducto(new Producto("AF5Y", "Arepas", 0.89),"A", 3);
        maquina.cargarProducto(new Producto("MH6S", "Yogurt", 1.53),"B", 8);
        maquina.cargarProducto(new Producto("BDCR", "Gatorade", 2.54),"D",5);
		
        System.out.println("***************  Venta Producto en Celda A  ***************");
        maquina.vender("A");
        System.out.println("***************  Venta Producto en Celda B  ***************");
        maquina.vender("B");
        
	}
}