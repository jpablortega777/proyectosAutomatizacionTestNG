package com.MapsObjets;

import org.openqa.selenium.By;

import com.ClasesBase.ClaseBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapMercadoLibreHome extends ClaseBase{

	public MapMercadoLibreHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR
		protected By linkPais=By.xpath("//android.widget.TextView[@text='Argentina']");
		protected By Buscar=By.xpath("(//android.widget.LinearLayout)[2]");
		protected By txtBuscar=By.xpath("//android.widget.EditText[@text='Buscar en Mercado Libre']");
		protected By linkProducto=By.xpath("(//android.widget.RelativeLayout)[5]");
		protected By btnAddCarrito=By.xpath("//android.widget.TextView[@text='Agregar al carrito']");

  
}
