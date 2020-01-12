package logic;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
public class JSONresource {

    @GET
    public JsonArray getDataArray() {
        return Json.createArrayBuilder()
                .add(getData("Anton", 18))
                .add(getData("Semen", 22))
                .add(getData("Boris",27))
                .build();
    }

    private JsonObject getData(String name, int age) {

        return Json.createObjectBuilder()
                .add("name", name)
                .add("age", age)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray setDataArray(String data, @HeaderParam("Accept") String userAgent) {
        System.out.println("Post apply!"+userAgent);
        return Json.createArrayBuilder()
                .add(data)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeData(@PathParam("id") int id) {
        System.out.println("Data removed: "+id);
        return Response.ok(getData("removed", id)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public JsonArray updateData(String data, @PathParam("id") int id) {

        System.out.println("Update data with id: "+id);
        System.out.println("Modified data: "+data);
        return Json.createArrayBuilder()
                .add(data)
                .build();
    }


}
