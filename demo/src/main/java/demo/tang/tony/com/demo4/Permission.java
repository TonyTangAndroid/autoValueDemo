package demo.tang.tony.com.demo4;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Permission {

    public static TypeAdapter<Permission> typeAdapter(Gson gson) {
        return new AutoValue_Permission.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Permission.Builder();
    }

    public abstract boolean read();

    public abstract boolean write();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder read(boolean read);

        public abstract Builder write(boolean write);

        public abstract Permission build();
    }
}
