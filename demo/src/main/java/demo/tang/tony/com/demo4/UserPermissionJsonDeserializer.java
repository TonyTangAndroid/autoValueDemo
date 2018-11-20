package demo.tang.tony.com.demo4;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserPermissionJsonDeserializer implements JsonDeserializer<AclWrapper>, JsonSerializer<AclWrapper> {


    private final Gson baseGson;

    public UserPermissionJsonDeserializer(Gson baseGson) {
        this.baseGson = baseGson;
    }

    @Override
    public AclWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        Set<String> strings = obj.keySet();
        int size = strings.size();
        if (size == 0) {
            return null;
        }

        List<UserPermission> userPermissionList = new ArrayList<>(strings.size());

        for (String userId : strings) {
            JsonElement jsonElement = obj.get(userId);
            String permissionJson = jsonElement.toString();//{"read":true,"write":false}
            Permission permission = baseGson.fromJson(permissionJson, Permission.class);
            UserPermission userPermission = UserPermission.builder().permission(permission).userId(userId).build();
            userPermissionList.add(userPermission);
        }

        return AclWrapper.builder().aclList(userPermissionList).build();

    }

    @Override
    public JsonElement serialize(AclWrapper src, Type typeOfSrc, JsonSerializationContext context) {

        final JsonObject jsonObject = new JsonObject();


        for (UserPermission userPermission : src.aclList()) {
            JsonElement jsonElement = baseGson.toJsonTree(userPermission.permission());
            jsonObject.add(userPermission.userId(), jsonElement);
        }

        return jsonObject;

    }
}