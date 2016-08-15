package com.cct.marvelwallapop.domain.net.ApiUtils;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by carloscarrasco on 15/8/16.
 */
public class OkHttpClientFactoryTest {

    private static final String TIMESTAMP_KEY = "ts";
    private static final String HASH_KEY = "hash";
    private static final String APIKEY_KEY = "apikey";

    private static final Long TIMESTAMP = 10l;
    private static final String APIKEY_PUBLIC = "abc";
    private static final String APIKEY_PRIVATE = "123";
    private static final String HASH = "123";

    @Test
    public void testIfIntercerptorLogIsEnableInDebug() {

        GenerateTime generateTime = Mockito.mock(GenerateTime.class);
        when(generateTime.getTimeStamp()).thenReturn(TIMESTAMP);

        GenerateHash generateHash = Mockito.mock(GenerateHash.class);
        when(generateHash.getMd5Hash(TIMESTAMP, APIKEY_PRIVATE, APIKEY_PUBLIC)).thenReturn(HASH);

        OkHttpClientFactory okHttpClientFactory = new OkHttpClientFactory(generateHash, generateTime);
        okHttpClientFactory.getOkhttpClient();
        assertThat(okHttpClientFactory.getOkhttpClient())

    }
}