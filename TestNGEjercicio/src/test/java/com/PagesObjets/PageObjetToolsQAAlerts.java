package com.PagesObjets;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.MapsObjets.MapObjetToolsQAAlerts;

public class PageObjetToolsQAAlerts extends MapObjetToolsQAAlerts{
  
	public PageObjetToolsQAAlerts(WebDriver driver) {
		super(driver);
		
	}

	//METODO DESPLEGUE DE ALERTAS 
	public void desplegueAlertas(String txt,File rutaCarpeta,String generarEvidencias)throws  Exception
	{
		try
		{
		//INVOCAMOS METODO SCROLL
		moverScroll(200,1);
		//INVOCAMOS METODO CLICK
		click(btnItemAlertas,rutaCarpeta,generarEvidencias);
		//INVOCAMOS METODO SCROLL
		moverScroll(100,1);
		//INVOCAMOS METODO CLICK
		clickTools(btnAlerta,rutaCarpeta,generarEvidencias);
		tiempoEspera(2000);
		//INVOCAMOS METODO CLICK
		tiempoEspera(2000);
		//INVOCAMOS METODO CLICK
		clickTools(btnTimeAlerta,rutaCarpeta,generarEvidencias);
		tiempoEspera(6000);
		//SELECCIONAR EL TERCER ALERT ACEPTAR
		clickTools(btnConfirmAlerta, rutaCarpeta, generarEvidencias);
		tiempoEspera(3000);
		// INICIALIZAR LA VARIABLE alert
		Alert alert3 = driver.switchTo().alert();
		// DAR ACEPTAR EN EL POP - UP
		alert3.accept();
		tiempoEspera(3000);
		//SELECCIONAR EL TERCER ALERT RECHAZAR
		clickTools(btnConfirmAlerta, rutaCarpeta, generarEvidencias);
		tiempoEspera(3000);
		// INICIALIZAR LA VARIABLE alert
		Alert alert_32 = driver.switchTo().alert();
		// DAR ACEPTAR EN EL POP - UP
		alert_32.dismiss();
		tiempoEspera(3000);		
		//SELECCIONAR EL CUARTO ALERT INPUT
		clickTools(btnpromtAlerta, rutaCarpeta, generarEvidencias);
		tiempoEspera(3000);
		// INICIALIZAR LA VARIABLE alert ENVIAR INPUT
		//alert.sendKeys(input);// REVISAR 
		driver.switchTo().alert().sendKeys(txt);
		tiempoEspera(3000);
		driver.switchTo().alert().accept();
		captureScreen(btnpromtAlerta,rutaCarpeta,"click", generarEvidencias);
		//alert.accept();
		tiempoEspera(3000);
		}catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		
		
	}
}
