package es.aragon.tpvppademo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class RespuestaTPV {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private boolean pagoCorrecto;
	private String MerchantID;
	private String AcquirerBIN;
	private String TerminalID ;
	private String Num_operacion; 
	private String Importe;
	private String TipoMoneda; 
	private String Exponente; 
	private String Referencia; 
	private String Firma ;
	private String Codigo_pedido ;
	private String Codigo_cliente ;
	private String Codigo_comercio;
	private String Num_aut;
	private String BIN;
	private String FinalPAN;
	private String Cambio_moneda ;
	private String Idioma;
	private String Pais ;
	private String Tipo_tarjeta ;
	private String Tipo_operacion;
	private String Descripcion ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMerchantID() {
		return MerchantID;
	}
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	public String getAcquirerBIN() {
		return AcquirerBIN;
	}
	public void setAcquirerBIN(String acquirerBIN) {
		AcquirerBIN = acquirerBIN;
	}
	public String getTerminalID() {
		return TerminalID;
	}
	public void setTerminalID(String terminalID) {
		TerminalID = terminalID;
	}
	public String getNum_operacion() {
		return Num_operacion;
	}
	public void setNum_operacion(String num_operacion) {
		Num_operacion = num_operacion;
	}
	public String getImporte() {
		return Importe;
	}
	public void setImporte(String importe) {
		Importe = importe;
	}
	public String getTipoMoneda() {
		return TipoMoneda;
	}
	public void setTipoMoneda(String tipoMoneda) {
		TipoMoneda = tipoMoneda;
	}
	public String getExponente() {
		return Exponente;
	}
	public void setExponente(String exponente) {
		Exponente = exponente;
	}
	public String getReferencia() {
		return Referencia;
	}
	public void setReferencia(String referencia) {
		Referencia = referencia;
	}
	public String getFirma() {
		return Firma;
	}
	public void setFirma(String firma) {
		Firma = firma;
	}
	public String getCodigo_pedido() {
		return Codigo_pedido;
	}
	public void setCodigo_pedido(String codigo_pedido) {
		Codigo_pedido = codigo_pedido;
	}
	public String getCodigo_cliente() {
		return Codigo_cliente;
	}
	public void setCodigo_cliente(String codigo_cliente) {
		Codigo_cliente = codigo_cliente;
	}
	public String getCodigo_comercio() {
		return Codigo_comercio;
	}
	public void setCodigo_comercio(String codigo_comercio) {
		Codigo_comercio = codigo_comercio;
	}
	public String getNum_aut() {
		return Num_aut;
	}
	public void setNum_aut(String num_aut) {
		Num_aut = num_aut;
	}
	public String getBIN() {
		return BIN;
	}
	public void setBIN(String bIN) {
		BIN = bIN;
	}
	public String getFinalPAN() {
		return FinalPAN;
	}
	public void setFinalPAN(String finalPAN) {
		FinalPAN = finalPAN;
	}
	public String getCambio_moneda() {
		return Cambio_moneda;
	}
	public void setCambio_moneda(String cambio_moneda) {
		Cambio_moneda = cambio_moneda;
	}
	public String getIdioma() {
		return Idioma;
	}
	public void setIdioma(String idioma) {
		Idioma = idioma;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	public String getTipo_tarjeta() {
		return Tipo_tarjeta;
	}
	public void setTipo_tarjeta(String tipo_tarjeta) {
		Tipo_tarjeta = tipo_tarjeta;
	}
	public String getTipo_operacion() {
		return Tipo_operacion;
	}
	public void setTipo_operacion(String tipo_operacion) {
		Tipo_operacion = tipo_operacion;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public RespuestaTPV(Long id, @NotBlank String merchantID, @NotBlank String Num_operacion,
			@NotNull String Descripcion) {
		super();
		this.id = id;
		this.MerchantID = merchantID;
		this.Num_operacion = Num_operacion;
		this.Descripcion = Descripcion;
	}

	public RespuestaTPV() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isPagoCorrecto() {
		return pagoCorrecto;
	}
	
	public void setPagoCorrecto(boolean pagoCorrecto) {
		this.pagoCorrecto = pagoCorrecto;
	}

}
