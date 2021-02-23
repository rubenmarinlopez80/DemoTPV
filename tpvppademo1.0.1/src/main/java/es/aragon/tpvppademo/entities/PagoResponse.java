package es.aragon.tpvppademo.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PagoResponse {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	
	    @JsonProperty("idPeticionPago")
	    @NotBlank
	    private String idPeticionPago;

	    @JsonProperty("estado")
	    @NotBlank
	    private String estado;

	    @JsonProperty("estadoDescripcion")
	    @NotNull
	    private String estadoDescripcion;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIdPeticionPago() {
			return idPeticionPago;
		}

		public void setIdPeticionPago(String idPeticionPago) {
			this.idPeticionPago = idPeticionPago;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getEstadoDescripcion() {
			return estadoDescripcion;
		}

		public void setEstadoDescripcion(String estadoDescripcion) {
			this.estadoDescripcion = estadoDescripcion;
		}

		public PagoResponse(Long id, @NotBlank String idPeticionPago, @NotBlank String estado,
				@NotNull String estadoDescripcion) {
			super();
			this.id = id;
			this.idPeticionPago = idPeticionPago;
			this.estado = estado;
			this.estadoDescripcion = estadoDescripcion;
		}

		public PagoResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}
