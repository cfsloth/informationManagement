/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.controller;

import com.informationmanagement.model.UserModel;
import com.informationmanagement.model.WarningModel;
import com.informationmanagement.viewer.WarningUIController;

/**
 *
 * @author Claudio
 */
public class WarningController {
    private WarningModel warningModel;
    private WarningUIController warningUI;
    private UserModel user;
    
    public WarningController(WarningModel warningModel, WarningUIController warningUI){
        this.warningModel = warningModel;
        this.warningUI = warningUI;
    }
    
    public WarningModel getWarningByUser(String email) throws Exception{
        return this.warningModel.getWarningByUser(email);
    }
    
    public WarningModel getWarningModel() {
        return warningModel;
    }

    public void setWarningModel(WarningModel warningModel) {
        this.warningModel = warningModel;
    }

    public WarningUIController getWarningUI() {
        return warningUI;
    }

    public void setWarningUI(WarningUIController warningUI) {
        this.warningUI = warningUI;
    }
}
