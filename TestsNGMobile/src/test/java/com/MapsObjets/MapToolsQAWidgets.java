package com.MapsObjets;



import org.openqa.selenium.By;

import com.ClasesBase.ClaseBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapToolsQAWidgets extends ClaseBase{

	public MapToolsQAWidgets(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR 
		protected By btnDataPicker=By.xpath("//android.widget.TextView[@text='Selector de fechas']");
		protected By txtSelectDate=By.xpath("//android.widget.EditText[@resource-id='datePickerMonthYearInput']");
		protected By txtDateTime=By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");

}
