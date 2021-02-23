/*
 *
 */
package es.aragon.tpvppademo.util;

/**
 * The Class Constantes.
 */
public class Constantes {

    private Constantes() {
    }

    /** The version api. */
    public static final String VERSION_API = "1.0.0";

    /** The Constant APP_CODE. */
    public static final String APP_CODE = "TPVPPADEMO";

    /** The Constant TITLE. */
    public static final String TITLE = "Aplicaci�n demo TPV PPA";
    
    public static final String PROJECT_CODE = "tpvppademo";


    /** Hostname de la maquina del entorno de pruebas de integraci�n (linux). */
    public static final String EDRTOOL_HOSTNAME = "mi0-des-ams-amm";
    
    public static final Boolean INTEGRATION_TESTING_FLAG = true;
    public static final String INTEGRATION_WINDOWS_HOSTNAME = "amsrubenmarin";

    /**
     * Ubicaci�n de los archivos de propiedades externos (misma unidad que el
     * despliegue) para el entorno de pruebas de integraci�n.
     */
    public static final String INTEGRATION_EXTERNAL_PATH = "/app/oracle/configuracion";

    /**
     * Ubicaci�n de los archivos de propiedades de los servidores de DES, PRE y
     * PRO (confirmar con AST para cada proyecto).
     */
    public static final String PRODUCTION_EXTERNAL_PATH = "/app/oracle/configuracion";

    /**
     * Nombre y extensi�n del archivo de propiedades del Logger de la
     * aplicaci�n.
     */
    public static final String APPLICATION_CONFIG_LOG_FILENAME = "log4j2.yml";

}
