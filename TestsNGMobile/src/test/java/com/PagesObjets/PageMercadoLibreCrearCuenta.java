package com.PagesObjets;

import java.io.File;

import com.MapsObjets.MapMercadoLibreCrearCuenta;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PageMercadoLibreCrearCuenta  extends MapMercadoLibreCrearCuenta {

	public PageMercadoLibreCrearCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;
	}
	//METODO CREAR CUENTA
		public void mercadolibreHomeCrearCuenta(String email,File rutaCarpeta,String generarEvidencia) throws Exception 
		{
			//CLICK EN BOTON CREAR CUENTA
			//btnCrearCuenta
			click(btnValidar, rutaCarpeta,generarEvidencia,"boton crear cuenta");
			tiempoEspera(2500);
			//SELECCIONAMOS EL CHECK BOX
			click(checkAutorizacion, rutaCarpeta,generarEvidencia,"check autorizacion");
			tiempoEspera(2500);
			//OPRIMIMOS EL BOTON CONTINUAR
			click(btnContinuar, rutaCarpeta,generarEvidencia,"boton continuar");
			tiempoEspera(2500);
			//CLICK EN EL BOTON VALIDAR
			click(btnValidar, rutaCarpeta,generarEvidencia,"boton validar");
			tiempoEspera(2500);
			//ENVIAMOS LA DIRECCION DE CORREO ELECTRONICO
			sendkey(email,txtEmail, rutaCarpeta,generarEvidencia,"correo electronico");
			tiempoEspera(2000);
		}
 
}
