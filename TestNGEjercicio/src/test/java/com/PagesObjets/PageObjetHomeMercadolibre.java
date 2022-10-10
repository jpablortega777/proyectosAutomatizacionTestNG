package com.PagesObjets;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.MapsObjets.MapObjetHomeMercadolibre;

public class PageObjetHomeMercadolibre extends MapObjetHomeMercadolibre{

	public PageObjetHomeMercadolibre(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//METODO INICIAL
		public void urlAcceso(String url)
		{
			driver.get(url);
			
		}
		
		//METODO PRIMERA ETAPA DE ABRIR EL NAVEGADOR 
		public void busquedaCargarPagina(String Producto,File rutaCarpeta, String generarReporte) 
		{
			try {
				
			//CLICK CERRAR COOKIES	
			validacion( btnCookie, rutaCarpeta, generarReporte);
			tiempoEspera(2000);
			//TECLADO ESCRIBE DATOS DE BUSQUEDA
			sendkey(Producto,txtBusqueda,rutaCarpeta,generarReporte);
			tiempoEspera(2000);
			//TECLA ENTER
			submit(txtBusqueda,rutaCarpeta,generarReporte);
			tiempoEspera(2000);
			//CLICK CERRAR UBICACION
			validacion( closeUbicacion, rutaCarpeta, generarReporte);
			tiempoEspera(2000);
			
			} catch(Exception e) 
			{
				imprimirMensaje(e);
			}
		}
		//METODO SEGUNDA PRUEBA 
				public void eligiendoPrimerElemento(String producto,File rutaCarpeta, String generarReporte) throws InterruptedException
				{
					try {
						
					
						//INVOCA EL SIGUIENTE METODO
						busquedaCargarPagina(producto,rutaCarpeta,generarReporte);
						tiempoEspera(2000);
						//CLICK EN EL LINK DEL PRODUCTO
						click(clickPrimerProducto,rutaCarpeta,generarReporte);
						tiempoEspera(2000);
						//CLICK BOTON ADD A CARRITO
						click(btnAddCarrito,rutaCarpeta,generarReporte);
						tiempoEspera(2000);
					} catch (Exception e) {
						imprimirMensaje(e);
					}

					
				}

}
