package com.MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ClasesBase.ClaseBase;

public class MapObjetMercuryHome extends ClaseBase {

	public MapObjetMercuryHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//ELEMENTOS A MAPEAR MERCURYTOURS- HOME
	protected By linkRegistro = By.linkText("REGISTER");

}
