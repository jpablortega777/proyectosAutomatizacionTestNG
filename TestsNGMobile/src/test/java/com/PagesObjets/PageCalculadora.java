package com.PagesObjets;



import java.io.File;

import org.testng.Assert;

import com.MapsObjets.MapCalculadora;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageCalculadora extends MapCalculadora {

	public PageCalculadora(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}
	public void operaciones(String valor1,String operacion,String valor2,File rutaCarpeta,String generarEvidencia) throws  Exception
	{
		
		//CLICK EN BOTON BORRAR
		click(btnBorrar, rutaCarpeta,generarEvidencia,"boton borrar");
		//SEPARAMOS LOS DATOS TIMPO STRING
		//INGRESO DE NUMEROS A LA CALCULADORA
		numIngresadosCalculadora(valor1,btnsNumeros,rutaCarpeta,generarEvidencia);
		//CLICK EN LA OPERACION MATEMATICA
		click(localizadorVariable(btnOperaciones,operacion), rutaCarpeta,generarEvidencia,operacion);
		//INGRESO DE NUMEROS A LA CALCULADORA		
		numIngresadosCalculadora(valor2,btnsNumeros,rutaCarpeta,generarEvidencia);		
		//CLICK EN EL BOTON IGUAL
		click(btnIgual, rutaCarpeta,generarEvidencia,"boton igual");
		tiempoEspera(2500);
		//float f=Float.parseFloat(driver.findElement(validacion).getText());
		float result=Float.valueOf(valor1);
		System.out.print("= "+valor1);
		System.out.print(45);
		
		//Assert.assertEquals(f, 0);
		Assert.assertEquals("",driver.findElement(validacion).getText().toString());
		
		
	}
	/*
	public String resultado(String operacion) {
		
		switch (operacion) { 
	    case sumar:
	     // secuencia de sentencias.
	     break;
	    case restar:
	     // secuencia de sentencias.
	     break;
	}*/
}
