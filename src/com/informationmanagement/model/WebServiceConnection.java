/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author Claudio
 */
public abstract class WebServiceConnection {
    final String PATH = "http://172.26.77.238:8081/WebServiceIM/" ;
    
    public String getRequest(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
    
    /*Post data is done */
    public void postRequest(String urlToRead,String json) throws MalformedURLException, ProtocolException, IOException, Exception{
        URL url = new URL(urlToRead);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty("Content-Type", "application/json");
        httpCon.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
        out.write(json);
        out.close();
        InputStream inputStream = httpCon.getInputStream();
        String text = "";
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        if(!text.equals("SUCESS")){
            throw new Exception("Json data was not recognized!");
        }
    }
    
    /*Put request done sucessfully */
public void putRequest(String urlToRead, String json) throws MalformedURLException, ProtocolException, IOException, Exception{
        URL url = new URL(urlToRead);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty("Content-Type", "application/json");
        httpCon.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
        out.write(json);
        out.close();
        InputStream inputStream = httpCon.getInputStream();
        String text = "";
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        } 
        if(!text.equals("SUCESS")){
            throw new Exception("Json data was not recognized!");
        }
    }
    
    public void deleteRequest(String urlToRead,String json) throws MalformedURLException, ProtocolException, IOException, Exception{
        URL url = new URL(urlToRead);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty("Content-Type", "application/json");
        httpCon.setRequestMethod("DELETE");
        OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
        out.write(json);
        out.close();
        InputStream inputStream = httpCon.getInputStream();
        String text = "";
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        } 
        System.out.println(text);
        if(!text.equals("SUCESS")){
            throw new Exception("Json data was not recognized!");
        }
    }    
}
