package gov.usgs.cida.simplehash;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * A vanilla Java solution for consistently hashing Strings to 
 * hexadecimal-encoded Strings without bringing in a bunch of dependencies and 
 * consequent version conflicts.
 */

public class SimpleHash {
	
	public static final String CHARSET = "UTF-8";
	/**
	 * Generates a hexadecimal-encoded hash for the given String
	 * 
	 * @param plainText Plaintext String to be hashed
	 * @param hashAlgorithm case-sensitive name of the hash algorithm. Allowed values include: "MD5",
	 *	"SHA-1", and "SHA-256". Other values may be available depending on the Java VM implementation
	 *	Standard Algorithm names are detailed here: http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#MessageDigest
	 * @return a hexadecimal-encoded hash for the given String
	 */
	public static String hash(String plainText, String hashAlgorithm){
		MessageDigest md;
		try{
			md = MessageDigest.getInstance(hashAlgorithm);
			md.update(plainText.getBytes(CHARSET));
		}
		catch(NoSuchAlgorithmException|UnsupportedEncodingException ex){
			throw new RuntimeException(ex);
		}
		
		byte[] hash = md.digest();
		String encodedHash = DatatypeConverter.printHexBinary(hash).toLowerCase(Locale.ENGLISH);
		return encodedHash;
	}
	
}
