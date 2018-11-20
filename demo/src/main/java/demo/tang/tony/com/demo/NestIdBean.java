package demo.tang.tony.com.demo;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class NestIdBean {


    public abstract String userId();

    public abstract String userName();

    public static Builder builder() {
        return new AutoValue_NestIdBean.Builder();
    }


    public static TypeAdapter<NestIdBean> typeAdapter(Gson gson) {
        return new AutoValue_NestIdBean.GsonTypeAdapter(gson);
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder userId(String userId);

        public abstract Builder userName(String userName);

        public abstract NestIdBean build();
    }
}
