package demo.tang.tony.com.demo4;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

class PermissionJsonAdapter implements JsonDeserializer<Permission> {


    private final Gson gson;

    public PermissionJsonAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Permission deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) throws JsonParseException {
        return gson.fromJson(json.getAsString(), Permission.class);
    }
}