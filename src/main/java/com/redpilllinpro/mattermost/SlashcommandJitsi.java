/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redpilllinpro.mattermost;

import static com.redpilllinpro.mattermost.SlashcommandParam.*;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.commons.text.WordUtils;

/**
 *
 * @author jena
 */
@Path("jitsi")
public class SlashcommandJitsi extends Slascommand {

    @POST
    @Path("meet")
    @Produces("application/json")
    public Response jitsi(
            @FormParam(CHANNEL_NAME) String channelName,
            @FormParam(TEAM_DOMAIN) String teamDomain,
            @FormParam(TEXT) String text,
            @FormParam(USER_NAME) String userName
    ) {
        String room = 
                text != null && !"".equals(text) ?
                text :
                createValidCamelCaseRoomName(teamDomain + " " + channelName);
        String url = getRoomUrl(room, false);
        SlashcommandResponse resp = new SlashcommandResponse();
        resp.setText(createMarkdown(userName, url));
        resp.setGoto_location(url);
        
        return Response.status(200)
                .entity(resp)
                .build();
    }
    
    @POST
    @Path("meet-external")
    @Produces("application/json")
    public Response jitDotSi(
            @FormParam(CHANNEL_NAME) String channelName,
            @FormParam(TEAM_DOMAIN) String teamDomain,
            @FormParam(TEXT) String text,
            @FormParam(USER_NAME) String userName
    ) {
        String room = 
                text != null && !"".equals(text) ?
                text :
                createValidPathRoomName(teamDomain + " " + channelName);
        String url = getRoomUrl(room, true);        
        SlashcommandResponse resp = new SlashcommandResponse();
        resp.setText(createMarkdown(userName, url));
        resp.setGoto_location(url);
        
        return Response.status(200)
                .entity(resp)
                .build();
    }    

    private String createMarkdown(String userName, String url) {
        String markdown = "##### " + userName + " wants to meet :video_camera:";
        markdown += "\n :point_right: Surf to [" + url +"](" + url+ ")";
        return markdown;
    }
}
