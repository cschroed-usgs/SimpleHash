/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.usgs.cida.simplehash;

import java.security.NoSuchAlgorithmException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cschroed
 */
public class SimpleHashTest {
	
	/**
	 * Test of hash method, of class SimpleHash.
	 */
	@Test
	public void testKnownHashes() {
		String plainText = "water";
		String hashAlgorithm = "SHA-1";
		String expResult = "6d5a45920a15adea049c8f22d569ff209625a43b".toUpperCase();
		String result = SimpleHash.hash(plainText, hashAlgorithm);
		assertEquals(expResult, result);
		
		hashAlgorithm = "MD5";
		expResult = "9460370bb0ca1c98a779b1bcc6861c2c".toUpperCase();
		result = SimpleHash.hash(plainText, hashAlgorithm);
		assertEquals(expResult, result);
		
		hashAlgorithm = "SHA-256";
		expResult = "0f4168490e38b8447e11ba4bd656aa11b925bd22af30bac464bc153fdb608501".toUpperCase();
		result = SimpleHash.hash(plainText, hashAlgorithm);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testUnknownAlgorithm() {
		try{
			SimpleHash.hash("", "LASAGNA_IS_NOT_A_HASH_ALGORITHM");
			fail();
		}
		catch(RuntimeException ex){
			assertTrue("Thrown Exception has the correct cause", ex.getCause() instanceof NoSuchAlgorithmException);
		}
	}
}
