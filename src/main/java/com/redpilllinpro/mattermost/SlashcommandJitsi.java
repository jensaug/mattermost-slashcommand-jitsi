/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redpilllinpro.mattermost;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author jena
 */
@Path("jitsi")
public class SlashcommandJitsi {

    @POST
    @Path("meet")
    @Produces("application/json")
    public Response jitsi(@HeaderParam("user-agent") String userAgent, @QueryParam("channel_name") String channelName1, @FormParam("channel_name") String channelName2) {
        SlashcommandResponse resp = new SlashcommandResponse();
        resp.text += "\n*query:* " + channelName1;
        resp.text += "\n*form:* " + channelName2;
        resp.text += "\n*addUser is called, userAgent *: " + userAgent;
        return Response.status(200)
                .entity(resp)
                .build();
    }

}
