package com.cct.marvelwallapop.domain.net.ApiUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class GenerateHash {

    public String getMd5Hash(Long timeStamp, String apikeyPrivate, String apikeyPublic) {
        String finalHashString = timeStamp + apikeyPrivate + apikeyPublic;
        try {
            MessageDigest md5Encoder = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5Encoder.digest(finalHashString.getBytes());

            StringBuilder md5 = new StringBuilder();
            for (int i = 0; i < md5Bytes.length; ++i) {
                md5.append(Integer.toHexString((md5Bytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return md5.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
