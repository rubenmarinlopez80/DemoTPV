package es.aragon.tpvppademo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import es.aragon.tpvppademo.config.YAMLConfig;
import es.aragon.tpvppademo.entities.PagoTarjetaIn;
import es.aragon.tpvppademo.util.Authenticator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@Configuration
@RequestMapping("/pruebas")
public class Controlador {
	

	
	 	 @Autowired
	 	 YAMLConfig propiedades;

         @GetMapping("pago")
    	 public String tpvpago()
    	 {	
        	 log.info("Pago Tarjeta .........."+propiedades.getPpaTPVurl());
    		 return "tpv";
    	 }  
         
         @PostMapping("/tpvamspago")
         public RedirectView pagoTpv(@RequestParam("importe") String importe,@RequestParam("tipoMoneda") String tipoMoneda,
        		 @RequestParam("urlOk") String urlOk,@RequestParam("urlNok") String urlNok,
        		 @RequestParam("idioma") String idioma,@RequestParam("descripcion") String descripcion,HttpServletResponse httpServletResponse) {
        	    log.info("Pago Tarjeta ..........");
         		PagoTarjetaIn datosPago = new PagoTarjetaIn();
         		datosPago.setImporte(new Long(importe));
         		datosPago.setTipoMoneda(tipoMoneda);
         		datosPago.setUrlOk(urlOk);
         		datosPago.setUrlNok(urlNok);
         		datosPago.setIdioma(idioma);
         		datosPago.setDescripcion(descripcion);
         		//----------------------------------
         		log.info("DatosPago : " +datosPago);
         	    log.info("URL del YML.........."+propiedades.getPpaTPVurl());
         	    log.info("User del YML.........."+propiedades.getUserTPV());
//         	    log.info("Pass del YML.........."+propiedades.getPassword());
//         		String urlServidor = "https://despasarelapagos.aragon.es/ppa_tpv/services/v1/tpv/";
//         		String user2 = "prueba";
//         		String password2 = "3ccf5231-d870-4f04-a4ad-664d1348c63d";
         	    String urlServidor = propiedades.getPpaTPVurl();
        		String user2 = propiedades.getUserTPV();
        		String password2 = propiedades.getPassword();
         		boolean inicializado = true;
         		Map<String, String> urlTPV2 = new HashMap<String, String>();

         		try {
         			log.info("Pago Redirect Url");
         			
         			Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
         			
         			client = client.register(new Authenticator(user2, password2));
         	    	WebTarget webTarget = client.target(urlServidor).path("pagoTarjeta/");

         	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

         	        Response response = invocationBuilder.post(Entity.entity(datosPago, MediaType.APPLICATION_JSON));

         	        System.out.println(response.getStatus());

         	        urlTPV2=response.readEntity(Map.class);
         	        
        	      
         	       log.info(urlTPV2.get("url"));
         	       

         		} catch (Exception e) {
         			e.printStackTrace();
         		}
         		
        	    RedirectView redirectView = new RedirectView();
         	    redirectView.setUrl(urlTPV2.get("url"));
         	    return redirectView;
	
         		 
         }
         
         
         
//         @PostMapping("/listadoPagos")
//         public RedirectView listadoPagos(@RequestParam("importe") String importe,@RequestParam("tipoMoneda") String tipoMoneda,
//        		 @RequestParam("urlOk") String urlOk,@RequestParam("urlNok") String urlNok,
//        		 @RequestParam("idioma") String idioma,@RequestParam("descripcion") String descripcion,HttpServletResponse httpServletResponse) {
//         	 	System.out.println("Listado Pagos..........");
//         	 	
//         		Peticion peticion = new Peticion();
//         		
//         		//----------------------------------
//         		System.out.println("Peticion : " +peticion);
//         		//System.out.println("urlServidor : " +urlServidor);
//         		String urlServidor = "https://despasarelapagos.aragon.es/ppa_tpv/services/v1/tpv/";
//         		boolean inicializado = true;
//         		String user2 = "prueba";
//         		String password2 = "3ccf5231-d870-4f04-a4ad-664d1348c63d";
//         		String servicioPago = "consulta/";
//         		String urlTPV="";
//         		Map<String, String> urlTPV2 = new HashMap<String, String>();
//         		ModelAndView model;
//         		model = new ModelAndView("pagoTpv");
//         		try {
//         			System.out.println("Pago Redirect Url");
//         			
//         			Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
//         			
//         			client = client.register(new Authenticator(user2, password2));
//         	    	WebTarget webTarget = client.target(urlServidor).path("consulta/");
//
//         	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//
//         	        Response response = invocationBuilder.post(Entity.entity(peticion, MediaType.APPLICATION_JSON));
//
//         	        System.out.println(response.getStatus());
//
//         	        urlTPV2=response.readEntity(Map.class);
//        	      
//        	        System.out.println(urlTPV2.get("url"));
//         	       
//
//         		} catch (Exception e) {
//         			e.printStackTrace();
//         		}
//         		
//        	    RedirectView redirectView = new RedirectView();
//         	    redirectView.setUrl(urlTPV2.get("url"));
//         	    return redirectView;
//
//         		
//         		 
//         }
}
