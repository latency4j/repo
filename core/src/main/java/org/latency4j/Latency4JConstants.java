package org.latency4j;

import org.latency4j.alert.MissedTargetAlertLogger;
import org.latency4j.util.ClasspathResourceUtils;

/**
 * <p>
 * Latency4J library constants.
 * </p>
 */
public interface Latency4JConstants {

	/**
	 * <p>
	 * The category utilised for logging alerts where none is specified in the
	 * {@link MissedTargetAlertLogger} configuration. The value of this constant
	 * is {@value #LATENCY4J_LOGGER_NAME}.
	 * </p>
	 */
	String LATENCY4J_LOGGER_NAME = "LATENCY4J";

	/**
	 * <p>
	 * The name of the system property which can be used to specify the path to
	 * the epsilon configuration file. The value of this constant is
	 * {@value #CONFIG_FILE_VM_PROP}.
	 * </p>
	 */
	String CONFIG_FILE_VM_PROP = "latency4j.config";

	/**
	 * <p>
	 * The assumed name of the epsilon configuration file. This is the value
	 * used if the property {@link #CONFIG_FILE_VM_PROP} is not specified. The
	 * value of this constant is {@value #DEFAULT_CONFIGURATION_RESOURCE_NAME}.
	 * </p>
	 */
	String DEFAULT_CONFIGURATION_RESOURCE_NAME = ClasspathResourceUtils.CLASSPATH_RESOURCE_PREFIX + "/latency4j.xml";

	/**
	 * <p>
	 * The name of the standard Java system property which holds the path to the
	 * system temporary folder i.&nbsp;e.&nbsp; {@value #JAVA_TMP_FILE_FOLDER}.
	 * </p>
	 */
	String JAVA_TMP_FILE_FOLDER = "java.io.tmpdir";

}