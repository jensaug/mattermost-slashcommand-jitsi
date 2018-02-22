/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redpilllinpro.mattermost;

import org.apache.commons.text.WordUtils;

/**
 *
 * @author jena
 */
class Slascommand {

    private static final String HOST_RL = "https://meet.redpill-linpro.com";
    private static final String HOST_JITSI = "https://meet.jit.si";
    
    protected String getRoomUrl(String room, boolean external) {
        return (external ? HOST_JITSI : HOST_RL) + "/" + room;
    }
    
    protected String createValidCamelCaseRoomName(String room) {
        return WordUtils.capitalizeFully(room, new char[]{'-','_', ' ', ':'})
                .replaceAll("-", "")
                .replaceAll("_", "")
                .replaceAll(" ", "")
                .replaceAll(":", "");
    }    
    
    protected String createValidPathRoomName(String room) {
        return room
                .replaceAll(",", "_")
                .replaceAll(";", "_");
    }       
}
