/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redpilllinpro.mattermost;

/**
 *
 * @author jena
 */
class SlashcommandResponse {

    private String goto_location;
    private String response_type = "in_channel";
    private String username = "jitsi";
    private String text;
    
    public void setGoto_location(String goto_location) {
        this.goto_location = goto_location;
    }

    public String getGoto_location() {
        return goto_location;
    }
    
    public String getResponse_type() {
        return response_type;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
