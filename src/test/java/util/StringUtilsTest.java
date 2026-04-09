package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.util.StringUtils;

public class StringUtilsTest {
	@Test
	void lowerCaseShouldNormalizeString() {
	    assertEquals("tomate", StringUtils.lowerCase("  ToMaTe  "));
	}

}
