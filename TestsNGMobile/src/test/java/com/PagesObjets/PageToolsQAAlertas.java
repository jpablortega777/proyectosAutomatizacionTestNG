package com.PagesObjets;

import java.io.File;

import com.MapsObjets.MapToolsQAAlertas;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageToolsQAAlertas extends MapToolsQAAlertas{

	public PageToolsQAAlertas(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;
	}
	//METODO ALERTAS
		public void alertas(String texto,File rutaCarpeta,String generarEvidencia) throws Exception 
		{
			try {
				
				//CLICK EN BOTON CREAR CUENTA
				click(linkAlertas, rutaCarpeta,generarEvidencia,"link alertas");
				tiempoEspera(2000);
				//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
				scrollVertical(rutaCarpeta,550,600,1300,2);
				tiempoEspera(2000);
				//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
				scrollVertical(rutaCarpeta,880,1000,500,2);
				tiempoEspera(2000);
				//CLICK EN BOTON CREAR CUENTA
				click(btnAlerta, rutaCarpeta,generarEvidencia,"boton alertas");
				tiempoEspera(2000);
				//CLICK EN BOTON ACEPTAR ALERTA
				click(btnAceptarAlerta, rutaCarpeta,generarEvidencia,"boton aceptar alertas");
				tiempoEspera(2000);
				//CLICK EN BOTON TIMER ALERTA
				click(btnTimerAlerta,rutaCarpeta,generarEvidencia,"boton timer alertas");
				tiempoEspera(2000);
				//CLICK EN BOTON ACEPTAR ALERTA TIMER
				click(btnAceptarTimerAlerta,rutaCarpeta,generarEvidencia,"boton aceptar timer alerta");
				tiempoEspera(2000);
				//CLICK EN BOTON CONFIRMAR ALERTA
				click(btnConfirmacionAlerta,rutaCarpeta,generarEvidencia,"boton confirmar alerta");
				tiempoEspera(2000);
				//CLICK BOTON ACEPTAR CONFIRMACION
				click(btnAceptarConfirmAlerta,rutaCarpeta,generarEvidencia,"boton aceptar confirmacion alerta");
				tiempoEspera(2000);
				//CLICK BOTON CONFIRMAR ALERTA
				click(btnConfirmacionAlerta,rutaCarpeta,generarEvidencia,"boton confirmar alerta");
				tiempoEspera(2000);
				//CLICK BOTON CANCELAR CONFIRMACION
				click(btnCancelarConfirmAlerta,rutaCarpeta,generarEvidencia,"boton cancelar confirmar alerta");
				tiempoEspera(2000);
				//CLICK BOTON ENVIAR TEXTO ALERTA
				click(btnTextAlerta,rutaCarpeta,generarEvidencia,"boton texto alerta");
				tiempoEspera(2000);
				//ENVIAR TEXTO DEL EXCEL EN EL CAMPO TEXT
				sendkey(texto, txtAlerta, rutaCarpeta,generarEvidencia,"enviar texto alerta");
				tiempoEspera(2000);
				//CLICK EN ACEPTAR PARA ENVIAR TEXTO
				click(btnAceptarText,rutaCarpeta,generarEvidencia,"boton aceptar texto alerta");
				tiempoEspera(2000);
				} catch (Exception e) {
					System.out.println(e);
				}
			
			
		}
		
}
