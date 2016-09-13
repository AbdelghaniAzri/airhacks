package com.airhacks.tables.boundary;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author airhacks.com
 */
@Path("rows")
@Produces(MediaType.APPLICATION_JSON)
public class RowsResource {

    @GET
    public void data(@Suspended AsyncResponse response) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < 10; i++) {
            arrayBuilder.add(create(i, i * 2));
        }

        response.resume(arrayBuilder.build());
    }

    @POST
    public void save(JsonObject input) {
        System.out.println("input = " + input);
    }

    JsonObject create(int first, int next) {
        return Json.createObjectBuilder().
                add("first", first).
                add("second", next).
                build();
    }

}
