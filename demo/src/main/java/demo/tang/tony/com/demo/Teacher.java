package demo.tang.tony.com.demo;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Teacher {

    public static Builder builder() {
        return new AutoValue_Teacher.Builder();
    }

    public abstract String id();

    public abstract String name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String id);

        public abstract Builder name(String name);

        public abstract Teacher build();
    }
}
