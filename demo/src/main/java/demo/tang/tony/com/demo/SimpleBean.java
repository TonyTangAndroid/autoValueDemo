package demo.tang.tony.com.demo;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import javax.annotation.Nullable;

@AutoValue
public abstract class SimpleBean {

    public static Builder builder() {
        return new AutoValue_SimpleBean.Builder();
    }

    public static TypeAdapter<SimpleBean> typeAdapter(Gson gson) {
        return new AutoValue_SimpleBean.GsonTypeAdapter(gson);
    }

    public abstract String objectId();

    public abstract String title();

    @Nullable
    public abstract String content();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder objectId(String objectId);

        public abstract Builder title(String title);

        public abstract Builder content(String content);

        public abstract SimpleBean build();
    }
}
