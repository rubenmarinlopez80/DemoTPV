package com.example.demo;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


@Controller
public class Controlador {
    
         @GetMapping("otra")
	 public String login()
	 {		
		 return "otrapagina";
	 }  
         
         @GetMapping("pago")
    	 public String tpvpago()
    	 {		
    		 return "tpv";
    	 }  
         
         @PostMapping("/tpvamspago")
         public void pagoTpv(@RequestParam("importe") String importe,@RequestParam("tipoMoneda") String tipoMoneda,
        		 @RequestParam("urlOk") String urlOk,@RequestParam("urlNok") String urlNok,
        		 @RequestParam("idioma") String idioma,@RequestParam("descripcion") String descripcion,HttpServletResponse httpServletResponse) {
         	 System.out.println("Pago Tarjeta ...");
         		PagoTarjetaIn datosPago = new PagoTarjetaIn();

         		datosPago.setImporte(new Long(importe));
         		datosPago.setTipoMoneda(tipoMoneda);
         		datosPago.setUrlOk(urlOk);
         		datosPago.setUrlNok(urlNok);
         		datosPago.setIdioma(idioma);
         		datosPago.setDescripcion(descripcion);

         		//----------------------------------
         		System.out.println("DatosPago : " +datosPago);
         		
         		String urlServidor = "https://despasarelapagos.aragon.es/ppa_tpv/services/v1/tpv/";
         		boolean inicializado = true;
         		String user2 = "prueba";
         		String password2 = "3ccf5231-d870-4f04-a4ad-664d1348c63d";
         		String servicioPago = "pagoTarjeta/";
         		String urlTPV="";
         		ModelAndView model;
         		model = new ModelAndView("pagoTpv");
         		try {
         			System.out.println("Pago Redirect Url");
         			
         			Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
         			
         			client = client.register(new Authenticator(user2, password2));
         	    	WebTarget webTarget = client.target(urlServidor).path("pagoTarjeta/");

         	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

         	        Response response = invocationBuilder.post(Entity.entity(datosPago, MediaType.APPLICATION_JSON));

         	        System.out.println(response.getStatus());
         	        urlTPV=response.readEntity(String.class);
         	        System.out.println(urlTPV);
         	       

         		} catch (Exception e) {
         			e.printStackTrace();
         		}
         		
//         	    RedirectView redirectView = new RedirectView();
//         	    redirectView.setUrl(urlTPV);
//         	    return redirectView;
         		/*model.addObject("url", urlTPV);
         		return model;*/
         	   //return new ModelAndView("redirect:" + urlTPV);
         	   httpServletResponse.setHeader("Location", urlTPV);
         		
         		 
         }
}
