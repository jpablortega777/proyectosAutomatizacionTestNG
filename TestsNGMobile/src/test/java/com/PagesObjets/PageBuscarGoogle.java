package com.PagesObjets;

import java.io.File;

import org.testng.annotations.Test;

import com.MapsObjets.MapBuscarGoogle;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageBuscarGoogle extends MapBuscarGoogle{
	
	public PageBuscarGoogle(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;
		// TODO Auto-generated constructor stub
	}
	// METODO PARA BUSCAR EN GOOGLE
	public void buscarGoogle(String url,File rutaCarpeta,String generarEvidencias) throws Exception 
	{
		
		
		//INVOCAMOS EL METODO BORRAR 
		borrar(btnBuscar, rutaCarpeta,generarEvidencias,"limpia el campo");
		tiempoEspera(15);
		//METODO CLICK EN EL BUSCADOR DE GOOGLE
		click(btnBuscar, rutaCarpeta,generarEvidencias,"boton buscar");
		tiempoEspera(15);
		//ENVIAMOS EL TEXTO QUE ESTA EN EXCEL LA URL 
		sendkey(url,btnBuscar, rutaCarpeta,generarEvidencias,"campo de busqueda de google");
		tiempoEspera(15);
		//METODO ENTER 
		enter(btnBuscar,rutaCarpeta,generarEvidencias,"en el campo de busqueda de google");
		tiempoEspera(2000);
	
		
	}
}
