package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RespuestaTpvController {
	


    @GetMapping(value = "/pagadook")
    public ResponseEntity<PagoResponse> pagook() {

        System.out.println("Pago correcto");
        PagoResponse pagoResponse = new PagoResponse();
        pagoResponse.setEstado("ok");
        pagoResponse.setEstadoDescripcion("Pago Correcto");
        pagoResponse.setIdPeticionPago("1");
        
        
        return new ResponseEntity(pagoResponse, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/pagadoko")
    public ResponseEntity<PagoResponse> pagoko() {

        System.out.println("Pago incorrecto");
        PagoResponse pagoResponse = new PagoResponse();
        pagoResponse.setEstado("ko");
        pagoResponse.setEstadoDescripcion("Pago Incorrecto");
        pagoResponse.setIdPeticionPago("1");
        return new ResponseEntity(pagoResponse, HttpStatus.OK);

    }

	
}
