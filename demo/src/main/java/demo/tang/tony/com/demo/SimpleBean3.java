package demo.tang.tony.com.demo;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
public abstract class SimpleBean3 {

    public static Builder builder() {
        return new AutoValue_SimpleBean3.Builder();
    }

    public static TypeAdapter<SimpleBean3> typeAdapter(Gson gson) {
        return new AutoValue_SimpleBean3.GsonTypeAdapter(gson);
    }

    public abstract String objectId();

    public abstract String title();

    @Nullable
    public abstract List<String> options();

    @Nullable
    @SerializedName("ACL")
    public abstract AclWrapper wrapper();


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder objectId(String objectId);

        public abstract Builder options(List<String> options);

        public abstract Builder title(String title);

        public abstract Builder wrapper(AclWrapper wrapper);

        public abstract SimpleBean3 build();
    }
}
