package org.edu.oracle.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExChangeController {

    private static String apiUrl = "https://v6.exchangerate-api.com/v6/65c9c702c2170889d748c6d1/latest/";

    public static JsonObject getConversionRates(String rate)  {
        URL url = null;
        try {
            url = new URL(apiUrl + rate);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            return jsonobj.get("conversion_rates").getAsJsonObject();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
