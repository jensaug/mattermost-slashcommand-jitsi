/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redpilllinpro.mattermost;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author jena
 */
@Path("rest")
public class SlashcommandJitsi {

    @GET
    @Path("jitsi")
    @Produces("text/plain")
    public String jitsi() {
        return "Yo Jitsi";
    }

}
