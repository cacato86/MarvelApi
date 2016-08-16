package com.cct.marvelwallapop.domain.net.ApiUtils;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static com.cct.marvelwallapop.Utils.Constants.APIKEY_PUBLIC;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by carloscarrasco on 16/8/16.
 */
public class QueryInterceptorFactoryTest {

    @Rule
    public MockWebServer server = new MockWebServer();

    private static final String TIMESTAMP_KEY = "ts";

    private static final Long TIMESTAMP = 10l;
    private static final String HASH = "1290be4cc57eecaf8e266cc67f5f28a1";

    @Test
    public void applicationInterceptorsQueryGenerateCorrectPath() throws Exception {
        server.enqueue(new MockResponse());

        GenerateTime generateTime = Mockito.mock(GenerateTime.class);
        when(generateTime.getTimeStamp()).thenReturn(TIMESTAMP);

        GenerateHash generateHash = new GenerateHash();

        Interceptor loggingInterceptor = new LoggingInterceptorFactory().getLoggingInterceptor();
        Interceptor queryInterceptor = new QueryInterceptorFactory(generateHash, generateTime).getQueryInterceptor();

        OkHttpClient client = new OkHttpClientFactory(loggingInterceptor, queryInterceptor).getOkhttpClient();

        Request request = new Request.Builder()
                .url(server.url("/"))
                .get()
                .build();

        client.newCall(request).execute();

        RecordedRequest recordedRequest = server.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());

        String requestLine = "/?" + TIMESTAMP_KEY + "=" + TIMESTAMP + "&apikey=" + APIKEY_PUBLIC + "&hash=" + HASH;
        assertEquals(requestLine, recordedRequest.getPath());
    }

}