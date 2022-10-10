package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import com.ClasesBase.ClaseBase;
import com.PagesObjets.PageMercuryHome;
import com.PagesObjets.PageMercuryRegister;
import com.PagesObjets.PageObjetCrearCuentaMercadolibre;
import com.PagesObjets.PageObjetHomeMercadolibre;
import com.PagesObjets.PageObjetToolsQAAlerts;
import com.PagesObjets.PageObjetToolsQAHome;
import com.PagesObjets.PageObjetToolsQAWidgets;
import com.utilidades.GenerarReportePdf;
import com.utilidades.MyScreenRecorder;
import com.utilidades.Utilidades;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;


import org.openqa.selenium.WebDriver;


public class RunTestNG 
{
 
	WebDriver driver;
	PageObjetHomeMercadolibre pagHomeML;
	PageObjetCrearCuentaMercadolibre pagcrearCuentaML;
	ClaseBase claseBase;
	PageMercuryHome pagMercuryHome;
	PageMercuryRegister pagMercuryRegister;
	PageObjetToolsQAHome pagtoolsHome;
	PageObjetToolsQAAlerts pagtoolsAlerts;
	PageObjetToolsQAWidgets pagtoolsWidgets;
	GenerarReportePdf generarReportePdf;
	String rutaImgEncabezadoML,rutaImgEncabezadoMT,rutaImgEncabezadoTQA;
	
  @BeforeClass
  @Parameters({"rutaImgML","rutaImgMT","rutaImgTQA"})
  public void beforeClass(@Optional("default") String rutaImgML,
		  				  @Optional("default") String rutaImgMT,
		  				  @Optional("default") String rutaImgTQA) throws Exception
  {
			 System.out.println(rutaImgMT);
			 System.out.println(rutaImgTQA);
			 driver= ClaseBase.chromeDriverConnection();
			 //INSTANCIA LA CLASEBASE
			 claseBase = new ClaseBase(driver);
			 //INSTANCIA LA CLASE PageObjetHomeMercadolibre
			 pagHomeML=new PageObjetHomeMercadolibre(driver);
			 //INSTANCIA LA CLASE PageObjetCrearCuentaMercadolibre
			 pagcrearCuentaML=new PageObjetCrearCuentaMercadolibre(driver);
			 //INSTANCIA LA CLAGE PageMercuryHome
			 pagMercuryHome= new PageMercuryHome(driver);
			 //INSTANCIAR LA CLASE PageObjetToolsQAHome
			 pagtoolsHome= new PageObjetToolsQAHome(driver);
			 //INSTANCIAR LA CLASE PageObjetToolsQAAlerts
			 pagtoolsAlerts= new PageObjetToolsQAAlerts(driver);
			 //INSTANCIAR LA CLASE PageObjetToolsQAWidgets
			 pagtoolsWidgets= new PageObjetToolsQAWidgets(driver);
			 //INSTANCIA LA CLAGE PageMercuryRegister
			 pagMercuryRegister= new PageMercuryRegister(driver);
			 //INSTANCIAR CLASE REPORTES
			 generarReportePdf = new GenerarReportePdf();
			 //GRABAR EN LA VARIABLE LA RUTA
			 rutaImgEncabezadoML=rutaImgML;
			 //GRABAR EN LA VARIABLE LA RUTA
			 rutaImgEncabezadoMT=rutaImgMT;
			 rutaImgEncabezadoTQA=rutaImgTQA;
  }
  
  @DataProvider(name="mercadolibre")
  public Object[][] datos() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "mercadolibre");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
	  
  }
  @DataProvider(name="mercadolibreCrearCuenta")
  public Object[][] datosML() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "mercadolibreCuenta");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
	  
  }
  @DataProvider(name="mercurytours")
  public Object[][] datosmercuryTours() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "mercurytours");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;  
  }
  @DataProvider(name="toolsqaAlerts")
  public Object[][] datostoolsqaAlerts() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "toolsqaAlerts");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null; 
  }
  @DataProvider(name="toolsqaWidgets")
  public Object[][] datostoolsqaWidgets() throws Exception
  {
	  try {
		  Object[][] arreglo=Utilidades.getTableArray("./Data/DataTest.xlsx", "toolsqaWidgets");
		  return arreglo;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;  
  }
  
  @Test(dataProvider = "mercadolibre",priority=1)
  public void mercadolibreTestNG(String producto,String url,String email,String generarReporte,String run,String responsable) throws Exception 
  {
	  	if(run.equals("On")) {
	  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			if(generarReporte.equals("Si")) {
				    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoML);
				    //URL ACCESO ALA PAGINA
				  	pagHomeML.urlAcceso(url);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
					//CREAR UNA CUENTA
					pagHomeML.eligiendoPrimerElemento(producto,rutaCarpeta,generarReporte);
					//CREAR UNA CUENTA
					pagcrearCuentaML.crearCuenta(email,rutaCarpeta,generarReporte);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
			}else {
				//URL ACCESO ALA PAGINA
			  	pagHomeML.urlAcceso(url);
			  	//CREAR UNA CUENTA
				pagHomeML.eligiendoPrimerElemento(producto,rutaCarpeta,generarReporte);
				//CREAR UNA CUENTA
				pagcrearCuentaML.crearCuenta(email,rutaCarpeta,generarReporte);
			}
	  	}else {
	  		//URL ACCESO ALA PAGINA
		  	//pagHomeML.urlAcceso(url);
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  
  @Test(dataProvider = "mercadolibreCrearCuenta",priority=2)
  public void mercadolibreCrearCuentaTestNG(String url,String email,String generarReporte,String run,String responsable) throws Exception 
  {
	  	if(run.equals("On")) {
		  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);
	  		if(generarReporte.equals("Si")) {
				    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				    generarReportePdf.setRutaImagen(rutaImgEncabezadoML);
				    //URL ACCESO ALA PAGINA
				  	pagHomeML.urlAcceso(url);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);			
					//CREAR UNA CUENTA
					pagcrearCuentaML.crearCuentaLink(email,rutaCarpeta,generarReporte);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
	  		}else {
		  			 //URL ACCESO ALA PAGINA
				  	pagHomeML.urlAcceso(url);
				  	//CREAR UNA CUENTA
					pagcrearCuentaML.crearCuentaLink(email,rutaCarpeta,generarReporte);
		  	}
	  	}else {	  		
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  
  @Test(dataProvider = "mercurytours",priority=3)
  public void mercurytoursTestNG(String nombre,String apellido,String telefono,String email,
		  String direccion,String ciudad,String provincia,String codigoposta,
		  String pais,String usuario,String pass,String confpass,String url,String generarEvidencia,String run,String responsable) throws Exception 
  {
	  if(run.equals("On")) {
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		if(generarEvidencia.equals("Si")) {
				  	//GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
				   	generarReportePdf.setRutaImagen(rutaImgEncabezadoMT);
				   	//URL ACCESO ALA PAGINA
				  	pagMercuryHome.urlAccesoMercury(url);
					//INICIO DE LA GRABACION DEL VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
					//INVOCAMOS EL METODO IR REGISTER QUE ESTA EN HOME
					pagMercuryHome.irLinkRegistro(rutaCarpeta,generarEvidencia);
					//INVOCAMOS EL METODO llenarCamposRegistro
					pagMercuryRegister.llenarCamposRegistro(nombre, apellido, telefono, email, direccion, ciudad, 
															provincia, codigoposta, pais, usuario, pass, confpass, 
															rutaCarpeta,generarEvidencia);
					//FINALIZA GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					//INICIA CREACION DE REPORTE PDF
					generarReportePdf.cerrarPalntilla();
		}else {
				//URL ACCESO ALA PAGINA
			  	pagMercuryHome.urlAccesoMercury(url);
			    //INVOCAMOS EL METODO IR REGISTER QUE ESTA EN HOME
				pagMercuryHome.irLinkRegistro(rutaCarpeta,generarEvidencia);
				//INVOCAMOS EL METODO IR REGISTER QUE ESTA EN HOME
				pagMercuryHome.irLinkRegistro(rutaCarpeta,generarEvidencia);
				//INVOCAMOS EL METODO llenarCamposRegistro
				pagMercuryRegister.llenarCamposRegistro(nombre, apellido, telefono, email, direccion, ciudad, 
														provincia, codigoposta, pais, usuario, pass, confpass, 
														rutaCarpeta,generarEvidencia);
		}
	  }else {
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  
  @Test(dataProvider ="toolsqaAlerts",priority=4)
  public void ToolsQAAlertsTestNG(String url,String text,String generarReporte,String run,String responsable) throws Exception 
  {
	  	if(run.equals("On")) {
		  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			if(generarReporte.equals("Si")) {
					    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
					    generarReportePdf.setRutaImagen(rutaImgEncabezadoTQA);
					    //URL ACCESO ALA PAGINA
					  	pagtoolsHome.urlAcceso(url);
						//INICIO DE LA GRABACION DEL VIDEO
						MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
						//CREAR UNA CUENTA
						pagtoolsHome.accessoAlertsFrameWindows(rutaCarpeta,generarReporte);
						//CREAR UNA CUENTA
						pagtoolsAlerts.desplegueAlertas(text,rutaCarpeta,generarReporte);
						//FINALIZA GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.cerrarPalntilla();
			}else {
				//URL ACCESO ALA PAGINA
			  	pagtoolsHome.urlAcceso(url);
			  	//CREAR UNA CUENTA
			  	pagtoolsHome.accessoAlertsFrameWindows(rutaCarpeta,generarReporte);
				//CREAR UNA CUENTA
			  	pagtoolsAlerts.desplegueAlertas(text,rutaCarpeta,generarReporte);
			}
	  	}else {
	  		System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
  
  @Test(dataProvider ="toolsqaWidgets",priority=5)
  public void ToolsQAWidgetsTestNG(String url,String text,String generarReporte,String run,String responsable) throws Exception 
  {
	  	if(run.equals("On")) {
		  		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			if(generarReporte.equals("Si")) {
					    //GUARDA LA RUTA DE LA IMAGEN PARA EL ENCABEZADO DEL PDF
					    generarReportePdf.setRutaImagen(rutaImgEncabezadoTQA);
					    //URL ACCESO ALA PAGINA
					  	pagtoolsHome.urlAcceso(url);
						//INICIO DE LA GRABACION DEL VIDEO
						MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.crearPlantilla(nomTest, rutaCarpeta,responsable);
						//CREAR UNA CUENTA
						pagtoolsHome.accessoWidgets(rutaCarpeta,generarReporte);
						//CREAR UNA CUENTA
						pagtoolsWidgets.datePicketTest2(rutaCarpeta,generarReporte);
						//FINALIZA GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						//INICIA CREACION DE REPORTE PDF
						generarReportePdf.cerrarPalntilla();
			}else {
				//URL ACCESO ALA PAGINA
			  	pagtoolsHome.urlAcceso(url);
			  	//CREAR UNA CUENTA
			  	pagtoolsHome.accessoWidgets(rutaCarpeta,generarReporte);
				//CREAR UNA CUENTA
			  	pagtoolsWidgets.datePicketTest2(rutaCarpeta,generarReporte);
			}
	  	}else {
	  			System.out.println("No a Seleccionado esta automatizacion");
	  	}
  }
 
  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
