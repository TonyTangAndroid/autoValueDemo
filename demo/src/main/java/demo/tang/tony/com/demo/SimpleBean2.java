package demo.tang.tony.com.demo;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import javax.annotation.Nullable;

@AutoValue
public abstract class SimpleBean2 {

    public static Builder builder() {
        return new AutoValue_SimpleBean2.Builder();
    }

    public static TypeAdapter<SimpleBean2> typeAdapter(Gson gson) {
        return new AutoValue_SimpleBean2.GsonTypeAdapter(gson);
    }

    public abstract String objectId();

    public abstract String title();

    public abstract NestIdBean nest_id();

    @Nullable
    public abstract String content();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder objectId(String objectId);

        public abstract Builder title(String title);

        public abstract Builder content(String content);

        public abstract Builder nest_id(NestIdBean nest_id);

        public abstract SimpleBean2 build();
    }
}
