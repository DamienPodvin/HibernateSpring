package fr.formation.inti;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppLog {
	
	private static final Log log = LogFactory.getLog(AppLog.class);

	public static void main(String[] args) {
	
		log.debug("debug ! ");
		log.info("information !");
		log.warn("alerte !");
		log.error("erreur ! ");
		log.fatal("fatal !");

	}

}
