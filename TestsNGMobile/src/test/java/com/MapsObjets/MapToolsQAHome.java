package com.MapsObjets;



import org.openqa.selenium.By;

import com.ClasesBase.ClaseBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapToolsQAHome extends ClaseBase{
  
	public MapToolsQAHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR
	protected By btnAlertas=By.xpath("//android.widget.TextView[@text='Alertas, marco y ventanas']");
	protected By btnWidgets=By.xpath("//android.widget.TextView[@text='Widgets']");
		

}
