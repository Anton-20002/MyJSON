package logic;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
}
