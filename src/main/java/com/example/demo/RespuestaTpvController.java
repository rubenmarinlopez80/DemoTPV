package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class RespuestaTpvController {
	
	String urlServidor = "https://despasarelapagos.aragon.es/ppa_tpv/services/v1/tpv/";
	boolean inicializado = true;
	String user2 = "prueba";
	String password2 = "3ccf5231-d870-4f04-a4ad-664d1348c63d";
	private static final String CORRECTA = "Ok";
	private static final String ERRONEA = "NOk";
	private static final String URL_RESPUESTA_TPV = "callback%s?idPeticion=%s&parametros=%s";
	

	public PagoResponse respuestaCorrecta(Long idPeticion, String parametros) {
		System.out.println("Respuesta correcta ");
		return respuesta(CORRECTA, idPeticion, parametros); 
	}
	
	public PagoResponse respuestaErronea(Long idPeticion, String parametros) {
		System.out.println("Respuesta erronea ");
		return respuesta(ERRONEA, idPeticion, parametros); 
	}
    @GetMapping(value = "/pagadook")
    public ResponseEntity<PagoResponse> pagook() {

        System.out.println("Pago correcto");
        
        PagoResponse pagoResponse = respuestaCorrecta (Long.parseLong("7"),"Aqui%20Otros%20Parametros%20De%20OK");
		//agenteAccesoPago.respuestaErronea (Long.parseLong("8"),"Aqui%20Otros%20Parametros%20De%20ERROR");
        //pagoResponse.setEstado("ok");
        //pagoResponse.setEstadoDescripcion("Pago Correcto");
        //pagoResponse.setIdPeticionPago("1");
        
        
        return new ResponseEntity(pagoResponse, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/pagadoko")
    public ModelAndView pagoko() {

        System.out.println("Pago incorrecto");
        PagoResponse pagoResponse =respuestaErronea (Long.parseLong("8"),"Aqui%20Otros%20Parametros%20De%20ERROR");
        //pagoResponse.setEstado("ko");
        //pagoResponse.setEstadoDescripcion("Pago Incorrecto");
        //pagoResponse.setIdPeticionPago("1");
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("respuestaincorrecta");
        mv.setStatus(HttpStatus.OK);
        mv.addObject("pagoResponse", pagoResponse);
        return mv;
        

    }
    
    public PagoResponse respuesta(String resultado, Long idPeticion, String parametros) {

    	Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
			
		client = client.register(new Authenticator(user2, password2));

		String url = urlServidor + String.format(URL_RESPUESTA_TPV,resultado,String.valueOf(idPeticion),parametros);
		System.out.println("URL : " +url);

		WebTarget webTarget = client.target (url); 

		PagoResponse pagoResponse = webTarget.request(MediaType.APPLICATION_JSON).get(PagoResponse.class);

		System.out.println("PagoResponse : " +pagoResponse);
		
		return pagoResponse;
	}

	
}
