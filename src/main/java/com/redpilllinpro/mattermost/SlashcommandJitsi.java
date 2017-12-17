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
public class SlashcommandJitsi {

    @POST
    @Path("meet")
    @Produces("application/json")
    public Response jitsi(
            @FormParam(CHANNEL_NAME) String channelName,
            @FormParam(TEAM_DOMAIN) String teamDomain,
            @FormParam(TEXT) String text,
            @FormParam(USER_NAME) String userName
    ) {
        SlashcommandResponse resp = new SlashcommandResponse();
        String markdown = "#### " + userName + " wants to meet!";
        markdown += "\n Surf to https://meet.redpill-linpro.com/" + toCamelCase(teamDomain + " " + channelName);
        markdown += "\n text: " + text;
        resp.setText(markdown);
        return Response.status(200)
                .entity(resp)
                .build();
    }

    private String toCamelCase(String string) {
        return WordUtils.capitalizeFully(string, new char[]{'_', ' ', ':'})
                .replaceAll("_", "")
                .replaceAll(" ", "")
                .replaceAll(":", "");
    }
}
