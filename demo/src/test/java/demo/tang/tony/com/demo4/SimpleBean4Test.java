package demo.tang.tony.com.demo4;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import demo.tang.tony.com.demo.BoxTypeAdapterFactory;
import demo.tang.tony.com.demo.TestUtils;

public class SimpleBean4Test {


    @Test
    public void builder_easy() throws IOException {


        Truth.assertThat(expected()).isNotNull();
        Truth.assertThat(actual()).isEqualTo(expected());


    }


    @Test
    public void builder_hard() throws IOException {

        Truth.assertThat(actual_hard()).isEqualTo(expected());

        Truth.assertThat(gson_hard().toJson(expected())).isEqualTo(expectJsonString());

    }

    @Test
    public void builder_hard_serialize() throws IOException {

        Truth.assertThat(gson_hard().toJson(actual_hard())).isEqualTo(expectJsonString());
    }

    private String expectJsonString() {
        return TestUtils.json("3_hard.json", this);
    }


    @Test
    public void builder_serialize() throws IOException {

        SimpleBean4 expected = expected();

        System.out.println(baseGson().toJson(expected));

    }


    private SimpleBean4 actual_hard() throws IOException {

        return SimpleBean4.typeAdapter(gson_hard()).fromJson(TestUtils.json("3_hard.json", this));
    }

    private SimpleBean4 actual() throws IOException {

        return SimpleBean4.typeAdapter(baseGson()).fromJson(TestUtils.json("3.json", this));
    }

    private Gson baseGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(BoxTypeAdapterFactory.create());
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create();
    }

    private Gson gson_hard() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(BoxTypeAdapterFactory.create());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(AclWrapper.class, new UserPermissionJsonDeserializer(baseGson()));
        return gsonBuilder.create();

    }


    private SimpleBean4 expected() {

        return SimpleBean4.builder()
                .objectId("3WQrZ0dyrt")
                .title("test title 1")
                .options(Arrays.asList("a", "b", "c"))
                .wrapper(AclWrapper.builder()
                        .aclList(Arrays.asList(
                                UserPermission.builder().userId("ctn1Zeov9d").permission(Permission.builder().read(true).write(true).build()).build(),
                                UserPermission.builder().userId("zn1xx1ov8d").permission(Permission.builder().read(true).write(false).build()).build()
                        ))
                        .build())
                .build();
    }


}