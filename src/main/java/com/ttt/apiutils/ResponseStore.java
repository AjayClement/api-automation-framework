package com.ttt.apiutils;

import com.ttt.enums.ResponseContext;
import netscape.javascript.JSObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ResponseStore {
    private final Map<String, Object> response = new HashMap<>();
    private final Map<String,String> responseString = new HashMap<>();
    private final Map<String, JSObject> responseJson = new HashMap<>();
    private final Map<String, List<Object>> responseList = new HashMap<>();
    private final Map<String, List<JSObject>> responseListJson = new HashMap<>();
    private final Map<String, List<String>> responseListString = new HashMap<>();

    public Object getResponseContext(ResponseContext key) {
        return response.get(key.toString());
    }

    public void setResponseContext(ResponseContext key, Object response) {
        this.response.put(key.toString(),response);
    }

    public String getResponseString(ResponseContext key) {
        return responseString.get(key.toString());
    }

    public void setResponseString(ResponseContext key, String value) {
        this.responseString.put(key.toString(),value);
    }

    public JSObject getResponseJson(ResponseContext key) {
        return responseJson.get(key.toString());
    }

    public void setResponseJson(ResponseContext key, JSObject jsObject) {
        this.responseJson.put(key.toString(), jsObject);
    }

    public List<Object> getResponseList(ResponseContext key) {
        return responseList.get(key.toString());
    }

    public void setResponseList(ResponseContext key, List<Object> value) {
        this.responseList.put(key.toString(), value);
    }

    public List<JSObject> getResponseListJson(ResponseContext key) {
        return responseListJson.get(key.toString());
    }

    public void setResponseListJson(ResponseContext key, List<JSObject> value) {
        this.responseListJson.put(key.toString(),value);
    }

    public List<String> getResponseListString(ResponseContext key) {
        return responseListString.get(key.toString());
    }

    public void setResponseListString(ResponseContext key, List<String> value) {
        this.responseListString.put(key.toString(), value);
    }

}
