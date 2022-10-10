package com.MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ClasesBase.ClaseBase;

public class MapObjetToolsQAAlerts extends ClaseBase{
	
	public MapObjetToolsQAAlerts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	protected By btnItemAlertas=By.xpath("//*[@id='item-1']/span[text()='Alerts']");
	protected By btnAlerta=By.id("alertButton");
	protected By btnTimeAlerta=By.id("timerAlertButton");
	protected By btnConfirmAlerta=By.id("confirmButton");
	protected By btnpromtAlerta=By.id("promtButton");
}
