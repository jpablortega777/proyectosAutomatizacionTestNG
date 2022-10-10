package com.MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ClasesBase.ClaseBase;

public class MapObjetToolsQAWidgets extends ClaseBase{
	
	public MapObjetToolsQAWidgets(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS MAPEDOS DE WIDGETS
	protected By listMenuWidgets=By.xpath("//div[@class='element-list collapse show']//ul/li[@class='btn btn-light ']");
	protected By btnMenuDataPicker=By.xpath("//*[text()='Date Picker']");
	protected By selectDate=By.xpath("//*[@id='datePickerMonthYearInput']");
	protected By selectDateMAgust=By.xpath("//*[text()='August']");
	protected By selectDateD7=By.xpath("//div[@class='react-datepicker__week']/div[@aria-label='Choose Sunday, August 7th, 2022']");
	protected By dateTime=By.id("dateAndTimePickerInput");
	protected By btnDateMes=By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']");
	protected By dateTimeMes=By.xpath("//div[text()='August']");
	protected By dateTimeDia=By.xpath("//div[@class='react-datepicker__month']//div[@aria-label='Choose Sunday, August 7th, 2022']");
	protected By dateTimeHora=By.xpath("//*[text()='16:30']");
	protected By listdateTimeHora=By.xpath("//*[@id='dateAndTimePicker']/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li[@class='react-datepicker__time-list-item ']");
}
