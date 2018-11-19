package demo.tang.tony.com.demo;

import com.google.common.truth.Truth;
import com.google.gson.Gson;

import org.junit.Test;

import java.io.IOException;

public class ReadFileTest {


    @Test
    public void builder() throws IOException {

        String json = TestUtils.json("1.json", this);

        SimpleBean actual = SimpleBean.typeAdapter(new Gson()).fromJson(json);
        SimpleBean expected = SimpleBean.builder().objectId("3WQrZ0dyrt").title("test title 1").build();
        Truth.assertThat(actual).isEqualTo(expected);

    }


}