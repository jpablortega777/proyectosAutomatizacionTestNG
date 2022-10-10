package com.PagesObjets;

import java.io.File;

import org.testng.annotations.Test;

import com.MapsObjets.MapToolsQAWidgets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageToolsQAWidgets extends MapToolsQAWidgets{

	public PageToolsQAWidgets(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=driver;
	}
	//METODO WIDGETS
	
		public void widgets(File rutaCarpeta,String generarEvidencia) 
		{
			try {
				
				//CLICK EN BOTON DATAPICKER
				click(btnDataPicker, rutaCarpeta,generarEvidencia,"boton a data picker");
				tiempoEspera(2000);
				//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
				scrollVertical(rutaCarpeta,550,600,1300,2);
				tiempoEspera(2000);
				//ENVIAMOS DATA
				borrar(txtSelectDate, rutaCarpeta,generarEvidencia,"campo de selectDate");
				tiempoEspera(2000);
				//ENVIAMOS EL DATO DE LA FECHA DEL SISTEMA MENOS UN MES Y UN YEAR Y UN DIA
				sendkey(dateWidgest(1,1,1), txtSelectDate, rutaCarpeta,generarEvidencia,"campo de selectDate");
				tiempoEspera(2000);
				//OPRIMIMOS ENTER
				enter(txtSelectDate,rutaCarpeta,generarEvidencia,"selectDate");
				tiempoEspera(2000);
				//FUNCION DE BORRAR CAMPO DATATIME
				borrar(txtDateTime, rutaCarpeta,generarEvidencia,"campo de DateTime");
				tiempoEspera(2000);
				//ENVIAMOS EL DATO DE LA FECHA DEL SISTEMA MENOS UN MES Y UN YEAR Y UN DIA
				sendkey(dateWidgest(1,1,1), txtDateTime, rutaCarpeta,generarEvidencia,"campo de DateTime");
				tiempoEspera(2000);
				//OPRIMIMOS ENTER
				enter(txtDateTime,rutaCarpeta,generarEvidencia,"DateTime");
				tiempoEspera(2000);
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}

}
