/*
 *
 */
package es.aragon.tpvppademo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.regex.Matcher;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import es.aragon.tpvppademo.util.Constantes;

/**
 * The Class UtilsEnv.
 */
@Slf4j
public class UtilsEnv {

	/**
	 * Carga los archivos de propiedades de la aplicación haciendo uso de una ubicación externa que obtiene de la a propiedad de sistema
	 * java.class.path, si no la encuentra utilizará una ruta predefinida definida en INTEGRATION_EXTERNAL_PATH o PRODUCTION_EXTERNAL_PATH
	 * dependiendo del entorno local o productivo
	 *
	 * @return the properties
	 */
	public static Properties getProperties() {

		String entorno = getEntorno();
		String hostname = getHostname();
		String path = "";
		if (hostname != null && hostname.equals(Constantes.INTEGRATION_WINDOWS_HOSTNAME)) {
			path = getClassPathWin();
		} else if (entorno != null) {
			path = getClassPathLin();
		}
		log.info("Hostname: " + getHostname());
		log.info("Entorno actual: " + entorno);
		log.info("Ruta obtenida del java.class.path: " + path);
		Properties props = new Properties();
		if (entorno != null) {
			if (!pathExist(path)) {
				log.warn("Harcodeando path, la ruta obtenida no existe.");
				log.warn(
					"Asegurese de que la ruta de ubicación de los archivos de propiedades externos se encuentra en la varibale de sistema java.class.path.");
				showClassPath();
				if (hostname != null && hostname.equals(Constantes.INTEGRATION_WINDOWS_HOSTNAME)) {
					if (Constantes.INTEGRATION_TESTING_FLAG) {
						path = Constantes.INTEGRATION_EXTERNAL_PATH +"/"+ Constantes.PROJECT_CODE + "/";
					}
				} else {
					path = Constantes.PRODUCTION_EXTERNAL_PATH +"/"+ Constantes.PROJECT_CODE + "/";
				}
			}
		} else {
			log.error(
				"Error obteniendo las propiedades externas, falta por definir el valor de la constante 'INTEGRATION_WINDOWS_HOSTNAME' con el Hostname de esta máquina --> ("
						+ getHostname() + ")");
		}
		if (!path.equals("")) {
			log.info("Captando propiedades externas para entorno (" + entorno + ") de: " + path);
			props.put("spring.config.location", path);
			log.info("Captando propiedades  " + props.getProperty("spring.config.location"));
			/*LoggerContext context = (LoggerContext) LogManager.getContext(false);
			File file = new File(path + Constantes.APPLICATION_CONFIG_LOG_FILENAME);
			context.setConfigLocation(file.toURI());*/
			return props;
		} else {
			return null;
		}

	}

	/**
	 * Muestra las propiedades del sistema.
	 */
	public static void showSystemProperties() {
		log.info("PROPIEDADES DEL SISTEMA:");
		Properties propi = System.getProperties();
		propi.forEach((k, v) -> log.info(k + ":" + v));
	}

	/**
	 * Muestra el valor de la variable de sistema java.class.path
	 */
	public static void showClassPath() {
		log.info("JAVA CLASS PATH:");
		String systemJavaClassPath = System.getProperty("java.class.path");
		log.info(systemJavaClassPath);
	}

	/**
	 * Comprueba que exista la ruta dada en el sistema de archivos de la maquina.
	 *
	 * @param path the path
	 *
	 * @return true, if successful
	 */
	public static boolean pathExist(String path) {
		return new File(path).exists();
	}

	/**
	 * Evaluamos el nombre de la maquina del servidor y en función de ello ejecutaremos uno u otro perfil de los entornode de DES(mi),
	 * PRE(me) o PRO(mo), también se establece un servidor de pruebas de integración que ha de definirse en la constante
	 * INTEGRATION_TESTING_HOSTNAME y que activa el profile de configuración (it).
	 *
	 * @return the entorno
	 */
	public static String getEntorno() {
		String hostname = getHostname();
		String entorno = null;
		if (hostname == null || org.apache.commons.lang.StringUtils.isEmpty(hostname)) {
			return null;
		}

		if (Constantes.INTEGRATION_WINDOWS_HOSTNAME.equals(hostname) || hostname.startsWith("mi")) {
			entorno = "mi";
		} else if (hostname.startsWith("me")) {
			entorno = "me";
		} else if (hostname.startsWith("mo")) {
			entorno = "mo";
		}

		return entorno;
	}

	/**
	 * Muestra el nombre de la maquina.
	 *
	 * @return the string
	 */
	public static String getHostname() {
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostName().toLowerCase();
		} catch (UnknownHostException e) {
			log.warn("Error obteniendo el nombre de la maquina: " + e.getMessage());
		}
		return hostname;
	}

	/**
	 * recuperamos la ruta de configuración de la variable de sistema java.class.path en linux ejemplo de classpath:
	 * /opt/oracle/jdk/java/lib/tools.jar:/opt/oracle/as/12.2.1.2/midwls/wlserver/server/lib/weblogic.jar:/opt/oracle/as/12.2.1.2/midwls/wlserver/../oracle_common/modules/net.sf.antcontrib_1.1.0.0_1-0b3/lib/ant-contrib.jar:/opt/oracle/as/12.2.1.2/midwls/wlserver/modules/features/oracle.wls.common.nodemanager.jar:/opt/oracle/as/12.2.1.2/midwls/wlserver/common/derby/lib/derbyclient.jar:/opt/oracle/as/12.2.1.2/midwls/wlserver/common/derby/lib/derby.jar:/app/oracle/configuracion:/opt/oracle/as/12.2.1.2/midwls/wlserver/server/lib/debugpatch-agent.jar
	 *
	 * @return the class path lin
	 */
	public static String getClassPathLin() {

		log.info("Recuperando ruta externa de archivos de configuracion (Maquina Linux).");
		String project = Constantes.PROJECT_CODE + "/";
		String systemJavaClassPath = System.getProperty("java.class.path");
		String[] rutas = systemJavaClassPath.split("\\:");
		String path = "";
		for (String r : rutas) {
			if (!r.contains(".jar")) {
				path = r;
			}
		}
		path += project;
		return path;

	}

	/**
	 * recuperamos la ruta de configuración de la variable de sistema java.class.path en windows
	 *
	 * @return the class path win
	 */
	public static String getClassPathWin() {
		log.info("Recuperando ruta externa de archivos de configuracion. (Maquina Windows)");
		String project = Constantes.PROJECT_CODE + "/";
		String systemJavaClassPath = System.getProperty("java.class.path");
		String[] rutas = systemJavaClassPath.split("\\;");
		String place = rutas[0];
		if (place.contains(".jar")) {
			place = rutas[rutas.length - 1];
		}
		String[] carpetas = place.split(Matcher.quoteReplacement(System.getProperty("file.separator")));
		//String path = "file://";
		String path = "";
		for (String c : carpetas) {
			path += "/" + c;
		}
		path += project;
		path = path.replaceFirst("/", "");
		return path;

	}

	/**
	 * Metodo de prueba para testear el uso de propiedades externas en el propio embed-Tomcat de SpringBoot.
	 *
	 * @param application the application
	 */
	public static void testExternalPropertiesOnTomcat(SpringApplication application) {
		String hostname = getHostname();
		if (hostname != null && (hostname.equals(Constantes.INTEGRATION_WINDOWS_HOSTNAME)) && Constantes.INTEGRATION_TESTING_FLAG) {
			log.info("Testenado Propiedades Externas en SpringBoot mediante Embed-Tomcat");
			Properties pr = UtilsEnv.getProperties();
			if (pr != null) {
				application.setDefaultProperties(pr);
			}
			String entorno = UtilsEnv.getEntorno();
			if (entorno != null) {
				application.setAdditionalProfiles(entorno);
			}
		}

	}

	/**
	 * Test para comprobar rutas, paths y carga de propiedades externas.
	 */
	public void itTest() {

		showClassPath();
		getProperties();
	}

}
