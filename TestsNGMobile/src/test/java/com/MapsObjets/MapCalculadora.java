package com.MapsObjets;

import org.openqa.selenium.By;

import com.ClasesBase.ClaseBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapCalculadora extends ClaseBase{

	public MapCalculadora(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS DE CALCULADORA
		protected By btnBorrar=By.xpath("//android.widget.ImageView[@content-desc='borrar']");
		protected By btnIgual=By.xpath("//android.widget.ImageView[@content-desc='igual a']");
		protected By btnsNumeros=By.xpath("//android.widget.TextView[@text='{0}']");
		protected By btnOperaciones=By.xpath("//android.widget.ImageView[@content-desc='{0}']");
		protected By validacion=By.xpath("//android.widget.TextView[@resource-id='com.miui.calculator:id/result']");
}
