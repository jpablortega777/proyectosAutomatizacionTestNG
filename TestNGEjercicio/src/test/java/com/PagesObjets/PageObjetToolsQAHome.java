package com.PagesObjets;

import java.io.File;

import org.openqa.selenium.WebDriver;


import com.MapsObjets.MapObjetToolsQAHome;

public class PageObjetToolsQAHome extends MapObjetToolsQAHome{
 
	//CONSTRUCTOR
		public PageObjetToolsQAHome(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		//METODO CARGA DE URL
		public void urlAcceso(String url)
		{
					driver.get(url);
		}
		//METODO ACESSO ALERTS
		public void accessoAlertsFrameWindows(File rutaCarpeta,String generarEvidencia) throws  Exception
		{
			try {
			moverScroll(200,1);		
			click(btnAlertasFrameWind, rutaCarpeta,generarEvidencia);
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		//METODO ACESSO WIDGETS
			public void accessoWidgets(File rutaCarpeta,String generarEvidencia) throws  Exception
			{
				try {
				moverScroll(200,1);		
				click(btnWidgets, rutaCarpeta,generarEvidencia);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
}
