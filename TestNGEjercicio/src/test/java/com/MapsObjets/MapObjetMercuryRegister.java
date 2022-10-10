package com.MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ClasesBase.ClaseBase;

public class MapObjetMercuryRegister extends ClaseBase{
	
	public MapObjetMercuryRegister(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//MAPEO DE LOS CAMPOS DE REGISTRO
	protected By txtNombre=By.name("firstName");
	protected By txtApellido=By.name("lastName");
	protected By txtTelefono=By.name("phone");
	protected By txtEmail=By.id("userName");
	protected By txtDireccion=By.name("address1");
	protected By txtCiudad=By.name("city");
	protected By txtProvincia=By.name("state");
	protected By txtCodigoPostal=By.name("postalCode");
	protected By selectOptPais=By.name("country");
	protected By txtUserNombre=By.id("email");
	protected By txtPassword=By.name("password");
	protected By txtConfirmPassword=By.name("confirmPassword");
	protected By btnEnviar=By.name("submit");
	
}
