package test;

import componentes.Celda;
import componentes.Producto;

public class TestCelda {
	public static void main(String[] args) {
		Celda celda=new Celda("A1");
		celda.ingresarProducto(new Producto("KE34","Papitas",0.85), 5);

		System.out.println("************* "+"CELDA: "+celda.getCodigo()+" *************");
		System.out.println("Nombre Producto: "+celda.getProducto().getNombre());
		System.out.println("Precio Producto: "+celda.getProducto().getPrecio());
		System.out.println("Código Producto: "+celda.getProducto().getCodigo());
		System.out.println("STOCK: "+celda.getStock());
		System.out.println("*************************************");
	}
}
