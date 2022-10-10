package com.PagesObjets;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.MapsObjets.MapObjetToolsQAWidgets;

public class PageObjetToolsQAWidgets extends MapObjetToolsQAWidgets{
 
	public PageObjetToolsQAWidgets(WebDriver driver) {
		super(driver);
		
	}
	
	//METODO DETERMINAR HORA
	
		public void datePicketTest2(File rutaCarpeta,String generarEvidencia) 
		{
			try {
			//MOVER SCROLL
			moverScroll(200, 1);
			//cLICK
			click(btnMenuDataPicker,rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			//DELETE
			borrar(selectDate, rutaCarpeta,generarEvidencia);
			tiempoEspera(4000);
			//ENVIAR DATO selectDate
			sendkey(dateWidgest(1,1,1),selectDate,rutaCarpeta,generarEvidencia);
			//DELETE
			borrar(dateTime, rutaCarpeta,generarEvidencia);
			tiempoEspera(4000);
			//ENVIAR DATO dateTime
			sendkey(dateWidgest(1,1,1),dateTime,rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			//submit(dateTime, rutaCarpeta,generarEvidencia);
			
			}catch(Exception e) {
			System.out.println("Error="+e);
			}
		}
}
