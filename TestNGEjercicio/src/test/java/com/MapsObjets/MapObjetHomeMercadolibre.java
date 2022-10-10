package com.MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ClasesBase.ClaseBase;

public class MapObjetHomeMercadolibre extends ClaseBase{
	//CONSTRUCTOR DE LA CLASE
		public MapObjetHomeMercadolibre(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}

		//ELEMENTOS PAGINA PRINCIPAL
		protected By btnCookie=By.xpath("//div[@class='cookie-consent-banner-opt-out__actions']/button[text()='Entendido']");
		protected By txtBusqueda=By.id("cb1-edit");
		protected By closeUbicacion=By.xpath("//button[@class='andes-tooltip-button-close']");
		protected By linkProducto=By.xpath("//*[@src='https://http2.mlstatic.com/D_NQ_NP_915069-MCO48941383812_012022-V.webp']");
		protected By btnAddCarrito=By.xpath("//button/span[text()='Agregar al carrito']");
		protected By clickPrimerProducto= By.xpath("//*[@class='ui-search-result-image__element shops__image-element'][1]");
}
