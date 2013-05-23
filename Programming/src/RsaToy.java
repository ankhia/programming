import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
  13:  * Basic RSA example.
  14:  */
public class RsaToy
{
	public static void main(
			String[]    args)
					throws Exception
					{
		byte[]           input = "hola mundo hola ".getBytes();
		Security.addProvider(new  BouncyCastleProvider());
		Cipher             cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
		
		KeyFactory       keyFactory = KeyFactory.getInstance("RSA", "BC");

		// create the keys

		System.out.println(new BigInteger("d46f473a2d746537de2056ae3092c451", 16).mod(new BigInteger("57791d5430d593164082036ad8b29fb1", 16)));
		
		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(	   new BigInteger("A9E167983F39D55FF2A093415EA6798985C8355D9A915BFB1D01DA197026170FBDA522D035856D7A986614415CCFB7B7083B09C991B81969376DF9651E7BD9A93324A37F3BBBAF460186363432CB07035952FC858B3104B8CC18081448E64F1CFB5D60C4E05C1F53D37F53D86901F105F87A70D1BE83C65F38CF1C2CAA6AA7EB", 16), new BigInteger("010001", 16));
		RSAPrivateKeySpec privKeySpec = new RSAPrivateKeySpec( new BigInteger("A9E167983F39D55FF2A093415EA6798985C8355D9A915BFB1D01DA197026170FBDA522D035856D7A986614415CCFB7B7083B09C991B81969376DF9651E7BD9A93324A37F3BBBAF460186363432CB07035952FC858B3104B8CC18081448E64F1CFB5D60C4E05C1F53D37F53D86901F105F87A70D1BE83C65F38CF1C2CAA6AA7EB", 16), new BigInteger("67CD484C9A0D8F98C21B65FF22839C6DF0A6061DBCEDA7038894F21C6B0F8B35DE0E827830CBE7BA6A56AD77C6EB517970790AA0F4FE45E0A9B2F419DA8798D6308474E4FC596CC1C677DCA991D07C30A0A2C5085E217143FC0D073DF0FA6D149E4E63F01758791C4B981C3D3DB01BDFFA253BA3C02C9805F61009D887DB0319", 16));

		RSAPublicKey pubKey = (RSAPublicKey)keyFactory.generatePublic(pubKeySpec);
		RSAPrivateKey privKey = (RSAPrivateKey)keyFactory.generatePrivate(privKeySpec);

		System.out.println("input : " + input);

		// encryption step

		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		System.out.println(cipher.getBlockSize());
		
		byte[] cipherText = cipher.doFinal(input);

		System.out.println("cipher: " + new String(cipherText));

		// decryption step

		cipher.init(Cipher.DECRYPT_MODE, privKey);

		byte[] plainText = cipher.doFinal(cipherText);

		System.out.println("plain : " + new String(plainText));
					}
}