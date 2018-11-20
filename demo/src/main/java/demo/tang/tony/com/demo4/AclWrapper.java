package demo.tang.tony.com.demo4;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class AclWrapper {

    public static TypeAdapter<AclWrapper> typeAdapter(Gson gson) {
        return new AutoValue_AclWrapper.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_AclWrapper.Builder();
    }

    public abstract List<UserPermission> aclList();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder aclList(List<UserPermission> aclList);

        public abstract AclWrapper build();
    }
}
