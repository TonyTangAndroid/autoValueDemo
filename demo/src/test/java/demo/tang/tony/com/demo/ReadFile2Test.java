package demo.tang.tony.com.demo;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.com.demo2.NestIdBean;

public class ReadFile2Test {


    @Test(expected = RuntimeException.class)
    public void builder_error() throws IOException {

        String json = TestUtils.json("2.json", this);
        SimpleBean2 actual = SimpleBean2.typeAdapter(new Gson()).fromJson(json);
        Truth.assertThat(actual).isNotNull();

    }


    @Test
    public void builder_1() throws IOException {
        String json = TestUtils.json("2.json", this);
        SimpleBean2 actual = SimpleBean2.typeAdapter(gson()).fromJson(json);
        Truth.assertThat(actual).isNotNull();

    }

    private Gson gson() {
        return new GsonBuilder().registerTypeAdapter(
                NestIdBean.class, NestIdBean.typeAdapter(new Gson())).create();
    }


    @Test
    public void builder_2() throws IOException {
        String json = TestUtils.json("2.json", this);
        SimpleBean2 actual = SimpleBean2.typeAdapter(gson2()).fromJson(json);
        Truth.assertThat(actual).isNotNull();

    }

    private static Gson gson2() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(BoxTypeAdapterFactory.create())
                .create();
    }


}