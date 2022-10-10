package com.PagesObjets;

import java.io.File;


import org.openqa.selenium.WebDriver;


import com.MapsObjets.MapObjetCrearCuentaMercadolibre;

public class PageObjetCrearCuentaMercadolibre extends MapObjetCrearCuentaMercadolibre{
  
	public PageObjetCrearCuentaMercadolibre(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void cuenta(String producto,File rutaCarpeta, String generarReporte)
	{
		try {
		//CLICK EN EL CHECKBOX	
		click(btnCheckBox,rutaCarpeta,generarReporte);
		tiempoEspera(2000);
		//CLICK BOTON CONTINUAR
		click(btnContinuar,rutaCarpeta,generarReporte);
		tiempoEspera(2000);
		//CLICK BOTON VALIDAR EMAIL
		click(btnValidarEmail,rutaCarpeta,generarReporte);
		tiempoEspera(2000);
		//INGRESAMOS EL COOREO ELECTRONICO
		sendkey(producto,txtEmail,rutaCarpeta,generarReporte);
		tiempoEspera(2000);
		
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
	}
	public void crearCuenta(String email,File rutaCarpeta, String generarReporte) throws InterruptedException 
	{
		try {
			
		
			//CLICK BOTON CREARCUENTA
			click(btnCrearcuenta,rutaCarpeta,generarReporte);
			tiempoEspera(2000);
			//INVOCA EL METODO CUENTA
			cuenta(email,rutaCarpeta,generarReporte);
			tiempoEspera(2000);
			//driver.close();
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
		
	}
	
	public void crearCuentaLink(String producto,File rutaCarpeta,String generarReporte) throws InterruptedException 
	{
		try {
			//CLICK BOTON COOKIES
			//click(btnCookie,rutaCarpeta,generarReporte);
			validacion( btnCookie, rutaCarpeta, generarReporte);
			tiempoEspera(2000);
			//CLICK LINK CREARCUENTA
			click(linkCrearcuenta,rutaCarpeta,generarReporte);
			tiempoEspera(2000);
			//INVOCA EL METODO CUENTA
			cuenta(producto,rutaCarpeta,generarReporte);
			tiempoEspera(2000);
			//driver.close();
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
		
	}

}
