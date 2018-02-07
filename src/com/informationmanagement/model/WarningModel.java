/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.model;

import com.google.gson.Gson;

/**
 *
 * @author Claudio
 */
public class WarningModel extends WebServiceConnection{
    private int informationWarningId;
    private String userEmailSend;
    private String description;
    private String severity;
    private String subject;
    private String URI = "http://192.168.1.20:8081/WebServiceIM/warningsInformation?administrator_email="; //later put in default

    public WarningModel(int informationWarningId, String description, 
            String severity, String subject, String userEmailSend) {
        this.informationWarningId = informationWarningId;
        this.userEmailSend = userEmailSend;
        this.description = description;
        this.severity = severity;
        this.subject = subject;
    }
    
    public WarningModel(){
        
    }
    
    public WarningModel getWarningByUser(String email) throws Exception{
        String result = super.getRequest(URI + email);
        Gson a = new Gson();
        WarningModel warning = a.fromJson(result, WarningModel.class);
        if(warning.getUserEmailSend() == null){
            throw new Exception("Warnings not found in database!");
        }
        return warning;
    }
    
    public int getInformationWarningId() {
        return informationWarningId;
    }

    public void setInformationWarningId(int informationWarningId) {
        this.informationWarningId = informationWarningId;
    }

    public String getUserEmailSend() {
        return userEmailSend;
    }

    public void setUserEmailSend(String userEmailSend) {
        this.userEmailSend = userEmailSend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
