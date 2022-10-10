package com.PagesObjets;

import java.io.File;

import com.MapsObjets.MapToolsQAHome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageToolsQAHome extends MapToolsQAHome{

	public PageToolsQAHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=driver;
	}
	//METODO HOME SELECCIONAR ALERTAS
		public void selectAlerts(File rutaCarpeta,String generarEvidencia) throws Exception 
		{
			//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,342,1878,610,2);
			tiempoEspera(1000);
			//DAMOS CLICK AL PAIS SELECCIONADO
			click(btnAlertas, rutaCarpeta,generarEvidencia,"link alertas");
			tiempoEspera(200);		
			
		}
		//METODO HOME SELECCIONAR WIDGETS
		public void selectWidgets(File rutaCarpeta,String generarEvidencia) throws Exception 
		{
			//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,342,1878,610,3);
			tiempoEspera(1000);
			//DAMOS CLICK AL PAIS SELECCIONADO
			click(btnWidgets, rutaCarpeta,generarEvidencia,"link widgets");
			tiempoEspera(200);		
				
		}

}
