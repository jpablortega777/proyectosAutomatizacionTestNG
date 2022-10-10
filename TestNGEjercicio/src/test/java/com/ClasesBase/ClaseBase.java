package com.ClasesBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.utilidades.GenerarReportePdf;

import org.openqa.selenium.TakesScreenshot;


public class ClaseBase {
 
	protected static WebDriver driver;
	

	public ClaseBase(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//METODO PAGINA PRINCIPAL
	public static WebDriver chromeDriverConnection() 
	{
		//SETEAR LAS OPCIONES DEL NAVEGADOR
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//SETEAR LAS PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver1.exe");
		driver = new ChromeDriver();
		
		//MIXIMIZAR EL NAVEGADOR 
		driver.manage().window().maximize();
		return driver;
	}
	
	//METODO DEL CLICK
	public void click(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).click();
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
		}catch(Exception e) {
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
            throw new InterruptedException();	
		}
		
	}
	//METODO DEL CLICK
		public void clickTools(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			try {
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
				driver.findElement(locator).click();
				tiempoEspera(2000);
			}catch(Exception e) {
				captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
	            throw new InterruptedException();	
			}
			
			
		}
	//METODO BORRAR
	public void borrar(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
		}catch(Exception e) {
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
	        throw new InterruptedException();	
		}
	}
	//METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator,File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(2000);
			captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
		}catch(Exception e) {
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
	        throw new InterruptedException();	
		}
	}
	//METODO ENTER SUBMIN
	public void submit(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		driver.findElement(locator).submit();
		tiempoEspera(2000);
		captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
	}
	//METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException
	{
		Thread.sleep(tiempo);
	}
	//IMPRIMIR MENSAJE CONSOLA
	public void imprimirMensaje(Exception mensaje) 
	{
		System.out.print(mensaje);
	}
	//METODO ENTER CLOSE COOKIE
	public void closeCookie(By locator,File rutaCarpeta,String generarEvidencia)throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//captureScreen(locator,rutaCarpeta,nomTest);
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(locator,rutaCarpeta,nomTest,generarEvidencia);
	}
	//METODO CAPTURA DE LA FECHA DEL SISTEMA
	public static String fechaHora()
	{
		//TOMAMOS LA FECHA DEL SISTEMA 
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA 
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	//METODO CAPTURA DE LA FECHA DEL SISTEMA
		public static String fechaHora2()
		{
			//TOMAMOS LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA 
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
	//METODO PARA ELIMINAR ARCHIVOS
		public void eliminarArchivo(String rutaImagen)
		{
			try {
			File fichero = new File(rutaImagen);
			fichero.delete();
			}catch (Exception e) {
				System.out.println(e);// TODO: handle exception
			}
		}
	//METODO CAPTURA DE HORA DEL SISTEMA 
	public static String HoraSistema()
	{
		//TOMAMOS LA FECHA DEL SISTEMA 
		LocalTime horaSistema = LocalTime.now();
		//DEFINIR FORMATO FECHA 
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}
	//METODO CAPTURA DE SCREENSHOT
	public void captureScreen(By locator,File rutaCarpeta, String nomTest,String generarEvidencia) throws Exception
	{
		if("Si".equals(generarEvidencia)) {
		try
		{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+nomTest+""+hora+".png"));
			String rutaImagen = new File(rutaCarpeta+"\\"+nomTest+""+hora+".png").toString();
			//INSTANCIAMOS LA CLASE DE GENERARREPORTES PDF
			GenerarReportePdf informePdf= new GenerarReportePdf();
			//SE INCERTA LOCALIZADOR Y RUTA DE LA IMAGEN EN EL PDF
			informePdf.crearBody(locator, rutaImagen);
			//ELIMINA EL ARCHIVO DE LA RUTA
			eliminarArchivo(rutaImagen);
		}catch(Exception e)
		{
			System.out.println(e);}
		}
	}
	// METODO ERROR AL CAPTURAR PANTALLA
    public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError)
            throws Exception {
        if (generarEvidencia.equals("Si")) {
            String hora = HoraSistema();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
            String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();
           // INSTACIAMOS LA CLASE GENERAR PDF
            GenerarReportePdf informePdf = new GenerarReportePdf();
            // SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
            informePdf.crearbodyError(locator, rutaImagen, msnError);
            // ELIMINAR IMAGEN CREADA
            eliminarArchivo(rutaImagen);
        }
    }
	//METODO CREAR CARPETA
	public File crearCarpeta( String nomTest)
	{
		//ALMACENAMOS LA FECHA DEL SISTEMA 
		String fecha = fechaHora();
		//CREAMOS EL NOMBRE DE LA CARPETA 
		String nomCarpeta = nomTest+"-"+fecha;
		//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/"+nomCarpeta);
		//CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	//METODO BUSCAR EN LISTA 
	public void selectOption( String inputText, By locator,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CAPTURAMOS LA LISTA 
		Select selectList= new Select(driver.findElement(locator));
		//HACEMOS VISIBLE EL TEXTO DE ENTRADA
		selectList.selectByVisibleText(inputText);
		tiempoEspera(2000);
		captureScreen( locator,rutaCarpeta,nomTest,generarEvidencia);
			
	}
	//METODO MOVER EL SCROLLBY
			public void moverScroll(int y,int numMovimiento) throws Exception
			{
				
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int i=0; i<=numMovimiento; i++) {
		    js.executeScript("window.scrollBy(0,"+y+")");
			}
		    tiempoEspera(2000);
			}
			//METODO ENVIA FECHA WIDGEST
			public String dateWidgest(int restYear,int restMes,int restDia) 
			{
				
					String[] fechaSeparada = fechaHora().split("-");
					int year=(Integer.parseInt(fechaSeparada[0]))-restYear;
					int mes=(Integer.parseInt(fechaSeparada[1]))-restMes;
					int dia=(Integer.parseInt(fechaSeparada[2]))-restDia;
					
					String Date=""+mes+"/"+dia+"/"+year+"";
					
				return Date;
			}
			public void validacion(By localizador, File rutaCarpeta, String generarEvidencia) {
			    try {
			        driver.findElement(localizador).isEnabled();
			        click(localizador,rutaCarpeta,generarEvidencia);
			    }catch (Exception e){
			        System.out.println(e);
			    }
			}
}
