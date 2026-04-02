package domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uparis.projet_genie_logiciel.domain.model.Person;

public class PersonTest {
	Person person1;

	@BeforeEach
	void setUp() {
		person1 = new Person(1, "Thierry");
	}

	@Test
	void shouldCreatePerson() {
		Person person2 = new Person(2, "Benoit");
		assertNotNull(person2);
		assertEquals("Benoit", person2.getName());
		assertTrue(person2.getId() > 0);
	}

	@Test
	void shouldChangeName() {
		person1.setName("Fraise");
		assertEquals("Fraise", person1.getName());
	}

}
