package com.PagesObjets;

import java.io.File;

import com.MapsObjets.MapMercadoLibreHome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageMercadoLibreHome extends MapMercadoLibreHome{
  
	public PageMercadoLibreHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}
	//METODO HOME
	
		public void mercadolibreHome(String producto,File rutaCarpeta,String generarEvidencia) throws Exception 
		{
			try {
			//DAMOS CLICK AL PAIS SELECCIONADO
			tiempoEspera(2500);
			click(linkPais, rutaCarpeta,generarEvidencia,"link pais");
			tiempoEspera(2500);
			//CLICK EN EL BUSCADOR DE MERCADO LIBRE
			click(Buscar, rutaCarpeta,generarEvidencia,"barra de busqueda");
			//ENVIAMOS EL TEXT A BUSCAR DESDE EL EXCEL
			sendkey(producto,txtBuscar, rutaCarpeta,generarEvidencia,"texto a buscar");
			tiempoEspera(2500);
			//DAMOS ENTER
			enter(txtBuscar,rutaCarpeta,generarEvidencia,"a la busqueda");
			tiempoEspera(2500);
			//CLICK EN EL PRIMER PRODUCTO QUE APAREZCA
			click(linkProducto, rutaCarpeta,generarEvidencia,"link primer produsco que aperece");
			tiempoEspera(2500);
			//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,551,1759,555,1);
			//CLICK EN ADD A CARRITO
			click(btnAddCarrito, rutaCarpeta,generarEvidencia,"boton agregar a carrito");
			tiempoEspera(2500);
			}catch(Exception e) {
				System.out.println(e);
			}
		}

}
