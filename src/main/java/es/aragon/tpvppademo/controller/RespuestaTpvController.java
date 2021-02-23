package es.aragon.tpvppademo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import es.aragon.tpvppademo.entities.PagoResponse;
import es.aragon.tpvppademo.entities.RespuestaTPV;
import es.aragon.tpvppademo.util.Authenticator;
import es.aragon.tpvppademo.util.UtilsEnv;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@RestController
public class RespuestaTpvController {
	
	
	private static final String CORRECTA = "Ok";
	private static final String ERRONEA = "NOk";
	private static final String URL_RESPUESTA_TPV = "callback%s?idPeticion=%s&parametros=%s";
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	/*public PagoResponse respuestaCorrecta(Long idPeticion, String parametros) {
		log.info("Respuesta correcta ");
		return respuesta(CORRECTA, idPeticion, parametros); 
	}
	
	public PagoResponse respuestaErronea(Long idPeticion, String parametros) {
		log.info("Respuesta erronea ");
		return respuesta(ERRONEA, idPeticion, parametros); 
	}
    @GetMapping(value = "/pagadook")
    public ResponseEntity<PagoResponse> pagook() {

    	log.info("Pago correcto");
        
        PagoResponse pagoResponse = respuestaCorrecta (Long.parseLong("7"),"Aqui%20Otros%20Parametros%20De%20OK");
		//agenteAccesoPago.respuestaErronea (Long.parseLong("8"),"Aqui%20Otros%20Parametros%20De%20ERROR");
        //pagoResponse.setEstado("ok");
        //pagoResponse.setEstadoDescripcion("Pago Correcto");
        //pagoResponse.setIdPeticionPago("1");
        log.info("PagoResponse : " +pagoResponse);
        
        return new ResponseEntity(pagoResponse, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/pagadoko")
    public ModelAndView pagoko() {

    	log.info("Pago incorrecto");
        PagoResponse pagoResponse =respuestaErronea (Long.parseLong("8"),"Aqui%20Otros%20Parametros%20De%20ERROR");
        //pagoResponse.setEstado("ko");
        //pagoResponse.setEstadoDescripcion("Pago Incorrecto");
        //pagoResponse.setIdPeticionPago("1");
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("respuestaincorrecta");
        mv.setStatus(HttpStatus.OK);
        mv.addObject("pagoResponse", pagoResponse);
        return mv;
        

    }*/
    
    @RequestMapping(value="/respuestaComuOnLine", method= RequestMethod.POST)
    public void respuestaComuOnLine  (@RequestParam Map<String, String>reqParam) {

    	log.info("respuestaComuOnLine");
        String merchantID  = reqParam.get("MerchantID");
        String num_operacion = reqParam.get("Num_operacion");
        String descripcion = reqParam.get("Descripcion");
        String acquirerBIN = reqParam.get("AcquirerBIN");
        
        //log.info("***********respuestaComuOnLine************"+merchantID+"-"+num_operacion+"-"+descripcion+"-"+acquirerBIN);
        reqParam.forEach((k, v) ->   log.info("***********respuestaComuOnLine************"+(k + ":" + v)));
        //Logica Funcional de cada aplicacion//
    }
    
    @RequestMapping(value="/respuestaTpv", method= RequestMethod.GET)
    public ModelAndView respuestaTpv  (@RequestParam Map<String, String>reqParam) {

    	log.info("Respuesta TPV");
        String merchantID  = reqParam.get("MerchantID");
        String num_operacion = reqParam.get("Num_operacion");
        String descripcion = reqParam.get("Descripcion");
        String acquirerBIN = reqParam.get("AcquirerBIN");
        
        //log.info("Respuesta TPV"+merchantID+num_operacion+descripcion+acquirerBIN);
        // Los valores no son devueltos en esta respuesta sino en /respuestaComuOnLine en una llamada diferente
        RespuestaTPV respuestaTPV = new RespuestaTPV();
        respuestaTPV.setPagoCorrecto(true);
        respuestaTPV.setMerchantID(merchantID);
        respuestaTPV.setNum_operacion(num_operacion);
        respuestaTPV.setDescripcion(descripcion);
        respuestaTPV.setAcquirerBIN(acquirerBIN);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("respuestaTPV");
        mv.setStatus(HttpStatus.OK);
        mv.addObject("respuestaTPV", respuestaTPV);
        return mv;


    }
    
    @RequestMapping(value="/respuestaTpvKo", method= RequestMethod.GET)
    public ModelAndView respuestaTpvKo  (@RequestParam Map<String, String>reqParam) {

    	log.info("Respuesta TPV KO");

        RespuestaTPV respuestaTPV = new RespuestaTPV();
        respuestaTPV.setPagoCorrecto(false);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("respuestaTPV");
        mv.setStatus(HttpStatus.OK);
        mv.addObject("respuestaTPV", respuestaTPV);
        return mv;


    }
    
    /*public PagoResponse respuesta(String resultado, Long idPeticion, String parametros) {

    	Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
			
		client = client.register(new Authenticator(user2, password2));

		String url = urlServidor + String.format(URL_RESPUESTA_TPV,resultado,String.valueOf(idPeticion),parametros);
		log.info("URL : " +url);

		WebTarget webTarget = client.target (url); 

		PagoResponse pagoResponse = webTarget.request(MediaType.APPLICATION_JSON).get(PagoResponse.class);

		log.info("PagoResponse : " +pagoResponse);
		
		return pagoResponse;
	}*/

	
}
