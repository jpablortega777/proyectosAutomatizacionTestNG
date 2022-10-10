package com.MapsObjets;

import org.openqa.selenium.By;

import com.ClasesBase.ClaseBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapToolsQAAlertas extends ClaseBase{

	public MapToolsQAAlertas(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR
		protected By linkAlertas=By.xpath("//android.widget.TextView[@text='Alertas']");
		protected By btnAlerta=By.xpath("//android.widget.Button[@resource-id='alertButton']");
		protected By btnAceptarAlerta=By.xpath("//android.widget.Button[@text='Aceptar']");
		protected By btnTimerAlerta=By.xpath("//android.widget.Button[@resource-id='timerAlertButton']");
		protected By btnAceptarTimerAlerta=By.xpath("//android.widget.Button[@text='Aceptar']");
		protected By btnConfirmacionAlerta=By.xpath("//android.widget.Button[@resource-id='confirmButton']");
		protected By btnAceptarConfirmAlerta=By.xpath("//android.widget.Button[@text='Aceptar']");
		protected By btnCancelarConfirmAlerta=By.xpath("//android.widget.Button[@text='Cancelar']");
		protected By btnTextAlerta=By.xpath("//android.widget.Button[@resource-id='promtButton']");
		protected By txtAlerta=By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/js_modal_dialog_prompt']");
		protected By btnAceptarText=By.xpath("//android.widget.Button[@text='Aceptar']");
		
	
}
