package services;

import static org.junit.Assert.assertTrue;

import static org.assertj.core.api.Assertions.*; 

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.CalculException;
import services.CalculService;

/**

Test unitaire de la classe dev.service.CalculService.

*/

public class CalculServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	
	@Test
	public void testAdditionner() throws Exception {
	
		LOG.info("Etant donné, une instance de la classe CalculService"); // TODO
		CalculService calculService = new CalculService();
				
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4"); // TODO
		int somme = 0;
		somme = calculService.additionner("1+3+4");
		LOG.info("Alors j'obtiens le résultat 8");
		assertThat(somme).isEqualTo(8);
		
		// TODO
	
	}

	@Test  (expected = CalculException.class)
	public void testExeption(){
		
		String varFalse = "1+3-4";
		int resulat = 0 ;
		LOG.info("appel du service");
		CalculService calculService = new CalculService();
		LOG.info("modethode exeption appele");
		resulat =  calculService.additionner(varFalse);
		
		
	}
}

