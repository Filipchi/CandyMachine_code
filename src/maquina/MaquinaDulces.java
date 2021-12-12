package maquina;

import java.util.ArrayList;

import componentes.Celda;
import componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double Saldo;
		
	
	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}

	public void agregarCelda(String codigoCelda) {
		celdas.add(new Celda(codigoCelda));
	}
	
	public void configurarMaquina(String codigo1, String codigo2, String codigo3, String codigo4) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			System.out.println("Celda: "+celdaX.getCodigo());
		}
	}
	
	public void mostrarConfiguracion() {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			System.out.println("Celda: "+celdaX.getCodigo());
		}
	}
	
	public Celda buscarCelda(String codigoCelda) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			if (celdaX.getCodigo() == codigoCelda) {
				return celdaX;
			}
		}
		return null;
	}
	
	public void cargarProducto(Producto producto, String codigoCelda, int stock) {
		Celda celdaRecuperada = buscarCelda(codigoCelda);
		celdaRecuperada.ingresarProducto(producto, stock);
	}
	
	public void mostrarProductos() {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			System.out.print("Celda: "+celdaX.getCodigo()+" ");
			System.out.print("Stock: "+celdaX.getStock()+" ");
			if (celdaX.getProducto() != null) {
				System.out.print("Producto: "+celdaX.getProducto().getNombre()+" ");
				System.out.println("Precio: "+celdaX.getProducto().getPrecio());
			} else {
				System.out.println("Sin Producto asignado");
			}
		}
		System.out.println("Saldo: "+this.Saldo+"\n");
	}
	
	public Producto buscarProductoEnCelda(String codigoCelda) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			if (celdaX.getCodigo() == codigoCelda) {
				return celdaX.getProducto();
			}
		}
		return null;
	}
	
	public double consultarPrecio(String codigoCelda) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			if (celdaX.getCodigo() == codigoCelda) {
				return celdaX.getProducto().getPrecio();
			}
		}
		return 0.0;
	}
	
	public Celda buscarCeldaProducto(String codigoProducto) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			if (celdaX.getProducto() != null) {
				if (celdaX.getProducto().getCodigo().equals(codigoProducto)) {
				return celdaX;
				}
			}
		}
		return null;
	}
	
	public void incrementarProductos(String codigoProducto, int items) {
		Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
		int stockActual = celdaEncontrada.getStock();
		stockActual += celdaEncontrada.getStock();
		celdaEncontrada.setStock(stockActual);
	}
	
	public void vender(String codigoCelda) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			if (celdaX.getCodigo().equals(codigoCelda)) {
				celdaX.setStock(celdaX.getStock()-1);
				this.Saldo += celdaX.getProducto().getPrecio();
				mostrarProductos();
			}
		}
	}

	public double venderConCambio(String codigoCelda, double valorCliente) {
		Celda celdaX = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaX = celdas.get(i);
			if (celdaX.getCodigo().equals(codigoCelda)) {
				celdaX.setStock(celdaX.getStock()-1);
				this.Saldo += celdaX.getProducto().getPrecio();
				return valorCliente - celdaX.getProducto().getPrecio();
			}
		}
		return 0.0;
	}
	

	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}	
}
