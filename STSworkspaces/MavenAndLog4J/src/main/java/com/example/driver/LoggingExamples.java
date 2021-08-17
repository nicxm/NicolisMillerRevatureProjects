package com.example.driver;

import org.apache.log4j.Logger;

public class LoggingExamples {
	
	final static Logger log = Logger.getLogger(LoggingExamples.class);
	
	public static void main(String[] args) {
		System.out.println("Regular ole print statement");
		
		log.trace("trace message - very fine");
		log.debug("statement for debuging");
		log.info("info");
		log.warn("warning");
		log.error("Error");
		log.fatal("Fatal");
	}

	
	@SuppressWarnings("unused")
	public void verifyExceptions() {
		if(10 == 20) {
			log.error("?????");
		} else {
			log.info("info");
		}
	}
}
