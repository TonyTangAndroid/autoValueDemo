package demo.tang.tony.com.demo;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class UserPermission {

    public static TypeAdapter<UserPermission> typeAdapter(Gson gson) {
        return new AutoValue_UserPermission.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_UserPermission.Builder();
    }

    public abstract String userId();

    public abstract Permission permission();


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder userId(String userId);

        public abstract Builder permission(Permission permission);

        public abstract UserPermission build();
    }
}
