package com.MapsObjets;



import org.openqa.selenium.By;

import com.ClasesBase.ClaseBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapMercadoLibreCrearCuenta extends ClaseBase{

	public MapMercadoLibreCrearCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR
		protected By btnCrearCuenta=By.xpath("//android.widget.TextView[@text='Crear cuenta']");
		protected By checkAutorizacion=By.xpath("//android.widget.ImageView[@resource-id='com.mercadolibre:id/leftCheckboxIcon']");
		protected By btnContinuar=By.xpath("//android.widget.TextView[@text='Continuar']");
		protected By btnValidar=By.xpath("//android.widget.Button[@text='Validar']");
		protected By txtEmail=By.xpath("//android.widget.EditText[@text='']");

}
