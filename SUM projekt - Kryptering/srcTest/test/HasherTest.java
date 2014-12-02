package test;

import static org.junit.Assert.*;
import model.Hasher;
import org.junit.*;

public class HasherTest {

	@Test
	public void testHashingEquals() {
		String hash1 = Hasher.hashPassword("Password1");
		//Output for "Password1"
		String hashoutput = "cbe0cd68cbca3868250c0ba545c48032f43eb0e8a5e6bab603d109251486f77a91e46a3146d887e37416c6bdb6cbe701bd514de778573c9b0068483c1c626aec";

		assertEquals(hash1, hashoutput);
	}
	
	@Test
	public void testHashingNotEquals() {
		String hash1 = Hasher.hashPassword("Davs");
		//Output for "davs"
		String hashoutput = "cbe0cd68cbca3868250c0ba545c48032f43eb0e8a5e6bab603d109251486f77a91e46a3146d887e37416c6bdb6cbe701bd514de778573c9b0068483c1c626aec";
		assertTrue(hash1 != hashoutput);
	}
}
