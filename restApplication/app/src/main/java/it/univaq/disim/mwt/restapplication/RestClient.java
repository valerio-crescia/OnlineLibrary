package it.univaq.disim.mwt.restapplication;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class RestClient {

    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private static final String TAG = "REST_CLIENT";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.addHeader("Accept", "application/json");
        client.addHeader("Content-Type", "application/json;charset=utf-8");
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        Log.i(TAG, BASE_URL + relativeUrl);
        return BASE_URL + relativeUrl;
    }

}
