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

    private static final String HOST = "https://meet.redpill-linpro.com";
    
    protected String getRoomUrl(String room) {
        return HOST + "/" + room;
    }
    
    protected String createValidRoomName(String room) {
        return WordUtils.capitalizeFully(room, new char[]{'-','_', ' ', ':'})
                .replaceAll("-", "")
                .replaceAll("_", "")
                .replaceAll(" ", "")
                .replaceAll(":", "");
    }    
}
