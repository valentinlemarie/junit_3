package exception;

import org.slf4j.LoggerFactory;

public class CalculException extends RuntimeException{
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("monLogger");
	public  CalculException(String exp){
		LOGGER.info("L'expression "+exp+" calcule est invalide");
	}
}
