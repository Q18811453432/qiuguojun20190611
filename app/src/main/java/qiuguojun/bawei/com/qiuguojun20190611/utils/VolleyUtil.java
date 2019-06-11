package qiuguojun.bawei.com.qiuguojun20190611.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyUtil {
    private VolleyUtil() {

    }

    private static class HolderVolley {
        private final static VolleyUtil VOLLEYUTIL = new VolleyUtil();

    }

    public static VolleyUtil getInstance() {
        return HolderVolley.VOLLEYUTIL;
    }

    public void getUrl(String url, Context context, final VolleyCallback volleyCallback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallback.setResult(response);
            }
        }, null);
        requestQueue.add(sr);
    }

    public interface VolleyCallback {
        void setResult(String jsonstr);
    }
}
