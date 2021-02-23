package es.aragon.tpvppademo.entities;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DAO de entrada al modulo de integracion con el componente TPV de PPA
 * 
 * @author maa
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagoTarjeta")
@ApiModel(value="PagoTarjeta", 
	description="Datos de un pago de tarjeta")
public class PagoTarjetaIn {
	
/*
	//	TPVPPA_MerchantID: Requerido9 
	@XmlElement(required = true)
	private String merchantId;
	
//	TPVPPA_AcquirerBIN: Requerido 10 
	@XmlElement(required = true)
	private String acquirerBin;
	
//	TPVPPA_TerminalID: Requerido 8
	@XmlElement(required = true)
	private String terminalId;
	
//	TPVPPA_Num_operacion: Requerido 50 
	@XmlElement(required = true)
	private String numOperacion;
*/
//	TPVPPA_Importe: Requerido 12
	@XmlElement(required = true)
	@ApiModelProperty()
	private Long importe;
	
//	TPVPPA_TipoMoneda: Requerido 3
	@XmlElement(required = true)
	private String tipoMoneda;
/*	
//	TPVPPA_Exponente: Requerido 1
	@XmlElement(required = true)
	private String exponente;
*/	
//	TPVPPA_URL_OK: Requerido 500
	@XmlElement(required = true)
	private String urlOk;
	
//	TPVPPA_URL_NOK: Requerido 500
	@XmlElement(required = true)
	private String urlNok;
/*	
//	TPVPPA_Firma: Requerido 256
	@XmlElement(required = true)
	private String firma;
	
//	TPVPPA_Cifrado: Requerido 4
	@XmlElement(required = true)
	private String cifrado;
*/	
//	TPVPPA_Idioma: Opcional 1
	private String idioma;
/*	
//	TPVPPA_Pago_soportado: Requerido 3
	@XmlElement(required = true)
	private String soportado;
*/	
//	TPVPPA_Descripcion: Opcional 1000
	private String descripcion;
/*	
//	TPVPPA_Pago_elegido: Opcional
	private String pagoElegido;
	
//	TPVPPA_Pago_elegido: Opcional
	private String pan;
	
	private String caducidad;
	
	private String ccv2;
	
//	TPVPPA_Referencia: Opcional 30
	private String referencia;
	
//	TPVPPA_Sesion: Opcional 
	private String sesion;
	
//	TPVPPA_Datos_acs_20: opcional 
	private String datosAcs;
	
//	TPVPPA_Firma_acs_20 
	private String firmaAcs;
	
//	TPVPPA_Merchant_url Opcional 500 
	private String merchantUrl;
	
//	TPVPPA_Merchant_parameters: Opcional 500
	private String merchantParameters;
*/
	
/*
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAcquirerBin() {
		return acquirerBin;
	}

	public void setAcquirerBin(String acquirerBin) {
		this.acquirerBin = acquirerBin;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getNumOperacion() {
		return numOperacion;
	}

	public void setNumOperacion(String numOperacion) {
		this.numOperacion = numOperacion;
	}
*/
	@ApiModelProperty(
			access="public",
			name="importe",
			value = "Importe de la operacion sin formatear. Siempre sera un numero entero donde los dos ultimos digitos seran los centimos de Euro", 
			example = "123456789012",
			allowEmptyValue=false, 
			required=true,
			allowableValues="NUMBER(12)")
	public Long getImporte() {
		return importe;
	}

	public void setImporte(Long importe) {
		this.importe = importe;
	}

	@ApiModelProperty(
			access="public",
			name="tipoMoneda",
			value = "Es el codigo ISO-4217 correspondiente a la moneda en la que se efectua el pago. Contendra el valor 978 para Euros", 
			allowEmptyValue=false, 
			required=true,
			allowableValues="978",
			example = "978")
	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
/*
	public String getExponente() {
		return exponente;
	}

	public void setExponente(String exponente) {
		this.exponente = exponente;
	}
*/
	@ApiModelProperty(
			access="public",
			name="urlOk",
			value = "Url completa (http://...) determinada por el comercio a la que se redirigira en caso de que el pago se realice correctamente", 
			allowEmptyValue=false, 
			required=true,
			allowableValues="http://...., https://")
	public String getUrlOk() {
		return urlOk;
	}

	public void setUrlOk(String urlOk) {
		this.urlOk = urlOk;
	}
	@ApiModelProperty(
			access="public",
			name="urlNok",
			value = "Url completa (http://...) determinada por el comercio a la que se redirigira en caso de que el pago NO se realice correctamente", 
			allowEmptyValue=false, 
			required=true,
			allowableValues="http://...., https://")
	public String getUrlNok() {
		return urlNok;
	}

	public void setUrlNok(String urlNok) {
		this.urlNok = urlNok;
	}
/*
	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
*/
	@ApiModelProperty(
			access="public",
			name="idioma",
			value = "Codigo de idioma. Por defecto Espa�ol", 
			allowEmptyValue=true, 
			required=false,
			allowableValues="1-Espa�ol, 2-Catalan, 3-Euskera, 4-Gallego, 5-Valenciano, 6-Ingles, 7-Frances, 8-Aleman, 9-Portugues, 10-Italiano, 14-Ruso, 15-Noruego",
			example = "1")
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
/*
	public String getSoportado() {
		return soportado;
	}

	public void setSoportado(String soportado) {
		this.soportado = soportado;
	}
*/
	@ApiModelProperty(
			access="public",
			name="descripcion",
			value = "Descripci�n del pago", 
			allowEmptyValue=true, 
			required=false,
			allowableValues="CHAR(500)")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public String getPagoElegido() {
		return pagoElegido;
	}

	public void setPagoElegido(String pagoElegido) {
		this.pagoElegido = pagoElegido;
	}
*/
	/*
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public String getDatosAcs() {
		return datosAcs;
	}

	public void setDatosAcs(String datosAcs) {
		this.datosAcs = datosAcs;
	}

	public String getFirmaAcs() {
		return firmaAcs;
	}

	public void setFirmaAcs(String firmaAcs) {
		this.firmaAcs = firmaAcs;
	}

	public String getMerchantUrl() {
		return merchantUrl;
	}

	public void setMerchantUrl(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}

	public String getMerchantParameters() {
		return merchantParameters;
	}

	public void setMerchantParameters(String merchantParameters) {
		this.merchantParameters = merchantParameters;
	}
	
	*/

	public boolean checkObligatorios () {
		//TODO: completar
		return true;
	}
	
	@Override
	public String toString() {
		return "PagoTarjetaIn [importe=" + importe + ", tipoMoneda=" + tipoMoneda
				+ ", urlOk=" + urlOk + ", urlNok=" + urlNok + ", idioma=" + idioma 
				+ ", descripcion=" + descripcion  + "]";
	}
	
	/*
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	public String getCcv2() {
		return ccv2;
	}
	public void setCcv2(String ccv2) {
		this.ccv2 = ccv2;
	}

	*/
}
