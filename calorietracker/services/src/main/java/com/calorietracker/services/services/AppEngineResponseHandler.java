package com.calorietracker.services.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.frogermcs.gactions.ResponseHandler;
import com.frogermcs.gactions.api.response.RootResponse;
import com.google.gson.Gson;

public class AppEngineResponseHandler implements ResponseHandler {
    private final HttpServletResponse httpServletResponse;
    private final Gson gson;

    public AppEngineResponseHandler(HttpServletResponse httpServletResponse) {
        this(httpServletResponse, new Gson());
    }

    public AppEngineResponseHandler(HttpServletResponse httpServletResponse, Gson gson) {
        this.httpServletResponse = httpServletResponse;
        this.gson = gson;
    }

    public void onPrepareContentType(String contentType) {
        httpServletResponse.setContentType(contentType);
    }

    public void onPrepareResponseHeaders(Map<String, String> headers) {
        for (String headerName : headers.keySet()) {
            httpServletResponse.addHeader(headerName, headers.get(headerName));
        }
    }

    public void onResponse(RootResponse rootResponse) {
        try {
            gson.toJson(rootResponse, httpServletResponse.getWriter());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
