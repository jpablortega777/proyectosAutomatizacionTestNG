package com.RunTestNG;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ClasesBase.ClaseBase;
import com.PagesObjets.PageBuscarGoogle;
import com.PagesObjets.PageCalculadora;
import com.PagesObjets.PageMercadoLibreCrearCuenta;
import com.PagesObjets.PageMercadoLibreHome;
import com.PagesObjets.PageToolsQAAlertas;
import com.PagesObjets.PageToolsQAHome;
import com.PagesObjets.PageToolsQAWidgets;
import com.utilidades.GenerarReportePdf;
import com.utilidades.MyScreenRecorder;
import com.utilidades.Utilidades;

import io.appium.java_client.AppiumDriver;

public class RunMobileTNG {
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	ClaseBase claseBase;
	GenerarReportePdf generarReportePdf;
	PageCalculadora pagCalculadora;
	PageBuscarGoogle pagGoogle;
	PageMercadoLibreHome pagMLHome;
	PageToolsQAHome pagTQAHome;
	PageToolsQAAlertas pagTQAAlertas;
	PageMercadoLibreCrearCuenta pagMLCuenta;
	PageToolsQAWidgets pagTQAWidgets;
	String rutaImgEncabezadoML,rutaImgEncabezadoTQA,rutaImgEncabezadoCal,appPackageGoogle,appActivityGoogle;
	String listparameters[];
	  @BeforeClass
	  @Parameters({"rutaImgCAL","rutaImgML","rutaImgTQA","appPackageGoogle","appActivityGoogle","platformName","deviceName","platformVersion","noReset","autoGrantPermissions"})
	  public void beforeClass(@Optional("default") String rutaImgCAL,
			  				  @Optional("default") String rutaImgML,
			  				  @Optional("default") String rutaImgTQA,
				  			  @Optional("default") String appPackageGoogle1,
				  			  @Optional("default") String appActivityGoogle1,
				  			  @Optional("default") String platformName,
				  			  @Optional("default") String deviceName,
				  			  @Optional("default") String platformVersion,
				  			  @Optional("default") String noReset,
				  			  @Optional("default") String autoGrantPermissions) throws Exception
	  {
		     System.out.println(appPackageGoogle);
			 System.out.println(rutaImgTQA);
			 rutaImgEncabezadoCal=rutaImgCAL;
			 rutaImgEncabezadoML=rutaImgML;
			 rutaImgEncabezadoTQA=rutaImgTQA;
			 appPackageGoogle=appPackageGoogle1;
			 appActivityGoogle=appActivityGoogle1;
		
			 listparameters=new String[]{platformName,deviceName,platformVersion,noReset,autoGrantPermissions};
			 //INSTANCIAR CLASE REPORTES
			 generarReportePdf = new GenerarReportePdf();

	  }
	  @DataProvider(name="calculadora")
	  public Object[][] datos() throws Exception
	  {
		  try {
			  Object[][] arreglo=Utilidades.getTableArray("./data/DataTestMobile.xlsx", "calculadora");
			  return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		  
	  }
	  @DataProvider(name="mercadolibre")
	  public Object[][] datosmercadolibre() throws Exception
	  {
		  try {
			  Object[][] arreglo=Utilidades.getTableArray("./data/DataTestMobile.xlsx", "mercadolibre");
			  return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;  
	  }
	  @DataProvider(name="toolsqa")
	  public Object[][] datostoolsqa() throws Exception
	  {
		  try {
			  Object[][] arreglo=Utilidades.getTableArray("./data/DataTestMobile.xlsx", "toolsqa");
			  return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;  
	  }
	  @DataProvider(name="toolsqaWidgets")
	  public Object[][] datostoolsqawidgets() throws Exception
	  {
		  try {
			  Object[][] arreglo=Utilidades.getTableArray("./data/DataTestMobile.xlsx", "toolsqawidgets");
			  return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;  
	  }
	  
  @Test(dataProvider = "calculadora",priority=1)
  public void testcalculadora(String valor1,String operacion,String valor2,String run,String appPackage,String appActivity,String generarReporte,String responsable) 
		  throws Exception{
	  if(run.equals("On")) {
		     
		    driver= ClaseBase.appiumDriverConnetion(listparameters,appPackage,appActivity);
			 //INSTANCIA LA CLASEBASE
			 claseBase = new ClaseBase(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			pagCalculadora= new PageCalculadora(driver);
			
			if(generarReporte.equals("On")) {
				    try {
					//GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoCal);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
					//CREAR UNA CUENTA
					pagCalculadora.operaciones(valor1,operacion,valor2,rutaCarpeta,generarReporte);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				    }catch (Exception e) {
						System.out.println(e);
						//FINALIZA GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.cerrarPalntilla();
					}
			}else {
				 
				 pagCalculadora= new PageCalculadora(driver);
			  	//CREAR UNA CUENTA
				 pagCalculadora.operaciones(valor1,operacion,valor2,rutaCarpeta,generarReporte);
				
			}
	  	}else {
	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  
  }
  @Test(dataProvider = "mercadolibre",priority=2)
  public void testMercadolibre(String email,String producto,String url,String run,String generarReporte,String responsable) 
		  throws Exception{
	  if(run.equals("On")) {
		     
		    driver= ClaseBase.appiumDriverConnetion(listparameters,appPackageGoogle,appActivityGoogle);
			 //INSTANCIA LA CLASEBASE
			 claseBase = new ClaseBase(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			//INSTANCIA DE LA CLASE PageObjetBuscarEnGoogle
			pagGoogle= new PageBuscarGoogle(driver);
			//INSTANCIA DE LA CLASE PageObjetMercadoLibreHome
			pagMLHome= new PageMercadoLibreHome(driver);
			//INSTANCIA DE LA CLASE PageObjetMercadoLibreCrearCuenta
			pagMLCuenta= new PageMercadoLibreCrearCuenta(driver); 
			
			if(generarReporte.equals("On")) {
				   
					try {
					//GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoML);				
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagGoogle.buscarGoogle(url,rutaCarpeta,generarReporte);
					//PAGINA DE INICIO MERCADO LIBRE
					pagMLHome.mercadolibreHome(producto,rutaCarpeta,generarReporte);
					//PAGINA DE MERCADO LIBRE CREAR CUENTA
					pagMLCuenta.mercadolibreHomeCrearCuenta(email,rutaCarpeta,generarReporte);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
					}catch (Exception e) {
						System.out.println(e);
						//FINALIZA GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.cerrarPalntilla();
					}
				    
			}else {
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagGoogle.buscarGoogle(url,rutaCarpeta,generarReporte);
					//PAGINA DE INICIO MERCADO LIBRE
					pagMLHome.mercadolibreHome(producto,rutaCarpeta,generarReporte);
					//PAGINA DE MERCADO LIBRE CREAR CUENTA
					pagMLCuenta.mercadolibreHomeCrearCuenta(email,rutaCarpeta,generarReporte); 
				 
			}
	  	}else {
	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  
  }
  @Test(dataProvider = "toolsqa",priority=3)
  public void testToolsQA(String texto,String url,String run,String generarReporte,String responsable) 
		  throws Exception{
	  if(run.equals("On")) {
		     
		    driver= ClaseBase.appiumDriverConnetion(listparameters,appPackageGoogle,appActivityGoogle);
			 //INSTANCIA LA CLASEBASE
			 claseBase = new ClaseBase(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
		    //INSTANCIA DE LA CLASE PageObjetBuscarEnGoogle
			pagGoogle= new PageBuscarGoogle(driver);
			//INSTANCIA DE LA CLASE PageObjetToolsQAHome
			pagTQAHome= new PageToolsQAHome(driver);
			//INSTANCIA DE LA CLASE PageObjetToolsQAAlertas
			pagTQAAlertas= new PageToolsQAAlertas(driver); 
			
			if(generarReporte.equals("On")) {
				    try {
					//GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
			    	generarReportePdf.setRutaImagen(rutaImgEncabezadoTQA);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagGoogle.buscarGoogle(url,rutaCarpeta,generarReporte);
					//PAGINA DE INICIO TOOLS QA
					pagTQAHome.selectAlerts(rutaCarpeta,generarReporte);
					//PAGINA DE TOOLS QA ALERTAS
					pagTQAAlertas.alertas(texto,rutaCarpeta,generarReporte);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				    }catch (Exception e) {
						System.out.println(e);
						//FINALIZA GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.cerrarPalntilla();
					}
			}else {
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagGoogle.buscarGoogle(url,rutaCarpeta,generarReporte);
					//PAGINA DE INICIO TOOLS QA
					pagTQAHome.selectAlerts(rutaCarpeta,generarReporte);
					//PAGINA DE TOOLS QA ALERTAS
					pagTQAAlertas.alertas(texto,rutaCarpeta,generarReporte);
					 
			}
	  	}else {
	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  
  }
  
  @Test(dataProvider = "toolsqaWidgets",priority=4)
  public void testToolsQAWidgets(String url,String run,String generarReporte,String responsable) 
		  throws Exception{
	  if(run.equals("On")) {
		     
		    driver= ClaseBase.appiumDriverConnetion(listparameters,appPackageGoogle,appActivityGoogle);
			 //INSTANCIA LA CLASEBASE
			 claseBase = new ClaseBase(driver);
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			//INSTANCIA DE LA CLASE PageObjetBuscarEnGoogle
			pagGoogle= new PageBuscarGoogle(driver);
			//INSTANCIA DE LA CLASE PageObjetToolsQAHome
			pagTQAHome= new PageToolsQAHome(driver);
			//INSTANCIA DE LA CLASE PageToolsQAWidgets
			pagTQAWidgets= new PageToolsQAWidgets(driver); 
			
			if(generarReporte.equals("On")) {
				    try {
					//GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoTQA);		
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagGoogle.buscarGoogle(url,rutaCarpeta,generarReporte);
					//PAGINA DE INICIO TOOLS QA
					pagTQAHome.selectWidgets(rutaCarpeta,generarReporte);
					//PAGINA WIDGETS TOOLS QA
					pagTQAWidgets.widgets( rutaCarpeta,generarReporte);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
				    }catch (Exception e) {
						System.out.println(e);
						//FINALIZA GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.cerrarPalntilla();
					}
			}else {
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagGoogle.buscarGoogle(url,rutaCarpeta,generarReporte);
					//PAGINA WIDGETS TOOLS QA
					pagTQAWidgets.widgets( rutaCarpeta,generarReporte);
					//PAGINA WIDGETS TOOLS QA
					pagTQAWidgets.widgets( rutaCarpeta,generarReporte);
					 
			}
	  	}else {
	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  
  }
  @AfterClass
  public void afterClass() 
  {
	 
	  driver.quit();
  }

}
