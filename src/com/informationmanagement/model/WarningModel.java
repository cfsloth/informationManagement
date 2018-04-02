/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.ProtocolException;

/**
 *
 * @author Claudio
 */
public class WarningModel extends WebServiceConnection{
    private int warningId;
    private int user_sending_id;
    private String userEmailSend;
    private String description;
    private String severity;
    private String subject;
    private String date;
    private int user_receiving_id;
    private String URI = PATH + "warningsInformation.php"; //later put in default

    public WarningModel(int informationWarningId, String description, 
            String severity, String subject, int user_sending_id) {
        this.warningId = informationWarningId;
        this.user_sending_id = user_sending_id;
        this.description = description;
        this.severity = severity;
        this.subject = subject;
    }
    
    //This constroctor is for the GUI
    public WarningModel(int informationWarningId,String userSendingEmail,String subject,String severityTable,String date){
        this.warningId = informationWarningId;
        this.userEmailSend = userSendingEmail;
        this.subject = subject;
        this.severity = severityTable;
        this.date = date;
    }
    
    public WarningModel(){
        
    }
    
    public WarningModel[] getWarningByUser(String email) throws Exception{
        String result = super.getRequest(URI + "?administrator_email=" + email);
        //System.out.println(result);
        Gson a = new Gson();
        return a.fromJson(result, WarningModel[].class);
    }
    
    public int getNextAdmin() throws Exception{
        String result = super.getRequest(URI + "?next_administrator");
        Gson a = new Gson();
        WarningModel model = a.fromJson(result,WarningModel.class);
        System.out.println(model.user_receiving_id);
        return model.user_receiving_id;
    }
    
    public void postWarning(WarningModel warning) throws IOException, ProtocolException, Exception{
        warning.setUser_receiving_id(warning.getNextAdmin());
        Gson gson = new Gson();
        String json  = gson.toJson(warning);
        super.postRequest(URI,json);
    }
    
    public int getInformationWarningId() {
        return warningId;
    }

    public void setInformationWarningId(int informationWarningId) {
        this.warningId = informationWarningId;
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

    public int getUser_receiving_id() {
        return user_receiving_id;
    }

    public void setUser_receiving_id(int user_receiving_id) {
        this.user_receiving_id = user_receiving_id;
    }

    public int getUser_sending_id() {
        return user_sending_id;
    }

    public void setUser_sending_id(int user_sending_id) {
        this.user_sending_id = user_sending_id;
    }

    public String getAdresser() {
        return this.userEmailSend;
    }

    public void setAdresser(String user_sending_email) {
        this.userEmailSend = user_sending_email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
