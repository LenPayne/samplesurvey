/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author c0587637
 */
@Path("/question")
public class Questions {
    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(Database.getResults("SELECT * FROM questions")).build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(JsonObject json) {
        String question = json.getString("question");
        int result = Database.doUpdate("INSERT INTO questions (question) VALUES (?)", question);
        if (result <= 0)
            return Response.status(500).build();
        else
            return Response.ok(json).build();
    }
}
