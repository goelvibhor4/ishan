package com.hibernate.dto;

	import java.security.MessageDigest;

	public class SHA512 {
			      
	    protected String convertByteToHex(byte data[])
	    {
	        StringBuffer hexData = new StringBuffer();
	        for (int byteIndex = 0; byteIndex<data.length; byteIndex++)
	            hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
	        
	        return hexData.toString();
	    }
	    
	    public  String hashText(String textToHash) throws Exception
	    {
	        final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
	        sha512.update(textToHash.getBytes());
	        
	        return convertByteToHex(sha512.digest());
	    }
	}
