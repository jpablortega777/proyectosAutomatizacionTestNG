package com.PagesObjets;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.MapsObjets.MapObjetMercuryRegister;

public class PageMercuryRegister extends MapObjetMercuryRegister
{
	//CONSTRUCTOR
		public PageMercuryRegister(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		//METODO LLENAR CAMPOS REGISTRO
		
		public void llenarCamposRegistro( String nombre,String apellido,String telefono,String email,
				  String direccion,String ciudad,String provincia,String codigoposta,
				  String pais,String usuario,String pass,String confpass, File rutaCarpeta,String generarEvidencia) throws  Exception
		{
			
			//ENVIAMOS EL TEXTO AL CAMPO NOMBRE
			sendkey(nombre, txtNombre, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO AL CAMPO APELLIDO
			sendkey(apellido, txtApellido, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO AL CAMPO TELEFONO
			sendkey(telefono, txtTelefono, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO AL CAMPO EMAIL
			sendkey(email, txtEmail, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE LA DIRECCION
			sendkey(direccion, txtDireccion, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE LA CIUDAD
			sendkey(ciudad, txtCiudad, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE LA PROVINCIA
			sendkey(provincia, txtProvincia, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE LA CODIGO POSTAL
			sendkey(codigoposta, txtCodigoPostal, rutaCarpeta,generarEvidencia);
			//SELECTION OPTION DE PAIS 
			selectOption(pais,selectOptPais, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE EL NOMBRE DE USUARIO
			sendkey(usuario, txtUserNombre, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE EL PASSWORD
			sendkey(pass, txtPassword, rutaCarpeta,generarEvidencia);
			//ENVIAMOS EL TEXTO DE CONFIRMAR PASSWORD
			sendkey(confpass, txtConfirmPassword, rutaCarpeta,generarEvidencia);
			//BOTON ENVIAR REGISTRO
			click(btnEnviar, rutaCarpeta,generarEvidencia);
		}
		
}
