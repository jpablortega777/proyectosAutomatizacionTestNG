package com.MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.ClasesBase.ClaseBase;

public class MapObjetToolsQAHome extends ClaseBase
{

	public MapObjetToolsQAHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTO MAPEADOS DE LA WEB TOOLS QA
	protected By btnAlertasFrameWind=By.xpath("//div[@class='category-cards']//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
	protected By btnWidgets=By.xpath("//h5[text()='Widgets']");
}
