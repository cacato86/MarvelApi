package com.cct.marvelwallapop.domain.net.ApiUtils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by carloscarrasco on 15/8/16.
 */
public class GenerateHashTest {

    private final Long TIMESTAMP = 10l;
    private final String APIKEY_PRIVATE = "abc";
    private final String APIKEY_PUBLIC = "123";
    private final String MD5RESULT = "5fd05122345f5678e2f6ad57f68c6756";

    @Test
    public void testGenerateCorrectMD5Hash() {
        GenerateHash generateHash = new GenerateHash();
        String md5Hash = generateHash.getMd5Hash(TIMESTAMP, APIKEY_PRIVATE, APIKEY_PUBLIC);
        assertThat(md5Hash, is(MD5RESULT));
    }
}