
/**
 * JcaKeyFactoryTest.java
 * Copyright (c) 2013 by Dr. Herong Yang, herongyang.com
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;
class JcaKeyFactoryTest {
   public static void main( String ... args ) {
	   String[] a = new String[]{"2048","RSA","RSA"};
      if (a.length<3) {
         System.out.println("Usage:");
         System.out.println("java JcaKeyFactoryTest keySize output"
            +" algorithm");
         return;
      }
      int keySize = Integer.parseInt(a[0]);
      String output = a[1];
      String algorithm = a[2]; // RSA, DSAgb
      try {
         writeKeys(keySize,output,algorithm);
         readKeys(output,algorithm);
      } catch (Exception e) {
         System.out.println("Exception: "+e);
         return;
      }
   }
   private static void writeKeys(int keySize, String output, 
         String algorithm) throws Exception {
      KeyPairGenerator kg = KeyPairGenerator.getInstance(algorithm);
      kg.initialize(keySize);
      System.out.println();
      System.out.println("KeyPairGenerator Object Info: ");
      System.out.println("Algorithm = "+kg.getAlgorithm());
      System.out.println("Provider = "+kg.getProvider());
      System.out.println("Key Size = "+keySize);
      System.out.println("toString = "+kg.toString());
      KeyPair pair = kg.generateKeyPair();
      PrivateKey priKey = pair.getPrivate();
      PublicKey pubKey = pair.getPublic();

      String fl = output+".pri";
      FileOutputStream out = new FileOutputStream(fl);
      byte[] ky = priKey.getEncoded();
      out.write(ky);
      out.close();
      System.out.println();
      System.out.println("Private Key Info: ");
      System.out.println("Algorithm = "+priKey.getAlgorithm());
      System.out.println("Saved File = "+fl);
      System.out.println("Length = "+ky.length);
      System.out.println("Format = "+priKey.getFormat());
      System.out.println("toString = "+priKey.toString());

      fl = output+".pub";
      out = new FileOutputStream(fl);
      ky = pubKey.getEncoded();
      out.write(ky);
      out.close();
      System.out.println();
      System.out.println("Public Key Info: ");
      System.out.println("Algorithm = "+pubKey.getAlgorithm());
      System.out.println("Saved File = "+fl);
      System.out.println("Length = "+ky.length);
      System.out.println("Format = "+pubKey.getFormat());
      System.out.println("toString = "+pubKey.toString());
   }
   private static void readKeys(String input,
         String algorithm) throws Exception {
      KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
      System.out.println();
      System.out.println("KeyFactory Object Info: ");
      System.out.println("Algorithm = "+keyFactory.getAlgorithm());
      System.out.println("Provider = "+keyFactory.getProvider());
      System.out.println("toString = "+keyFactory.toString());

      String priKeyFile = input+".pri";
      FileInputStream priKeyStream = new FileInputStream(priKeyFile);
      int priKeyLength = priKeyStream.available();
      byte[] priKeyBytes = new byte[priKeyLength];
      priKeyStream.read(priKeyBytes);
      priKeyStream.close();
      PKCS8EncodedKeySpec priKeySpec 
         = new PKCS8EncodedKeySpec(priKeyBytes);
      PrivateKey priKey = keyFactory.generatePrivate(priKeySpec);
      System.out.println();
      System.out.println("Private Key Info: ");
      System.out.println("Algorithm = "+priKey.getAlgorithm());
      System.out.println("Saved File = "+priKeyFile);
      System.out.println("Length = "+priKeyBytes.length);
      System.out.println("toString = "+priKey.toString());

      String pubKeyFile = input+".pub";
      FileInputStream pubKeyStream = new FileInputStream(pubKeyFile);
      int pubKeyLength = pubKeyStream.available();
      byte[] pubKeyBytes = new byte[pubKeyLength];
      pubKeyStream.read(pubKeyBytes);
      pubKeyStream.close();
      X509EncodedKeySpec pubKeySpec 
         = new X509EncodedKeySpec(pubKeyBytes);
      PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
      System.out.println();
      System.out.println("Public Key Info: ");
      System.out.println("Algorithm = "+pubKey.getAlgorithm());
      System.out.println("Saved File = "+pubKeyFile);
      System.out.println("Length = "+pubKeyBytes.length);
      System.out.println("toString = "+pubKey.toString());
   }
}