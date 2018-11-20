package demo.tang.tony.com.demo;

import com.google.common.truth.Truth;
import com.google.gson.Gson;

import org.junit.Test;

import java.io.IOException;

public class NestIdTest {


    @Test
    public void builder() throws IOException {

        String json = TestUtils.json("1_2.json", this);

        NestIdBean actual = NestIdBean.typeAdapter(new Gson()).fromJson(json);
        NestIdBean expected = NestIdBean.builder().userId("3WQrZ0dyrt").userName("Tony").build();
        Truth.assertThat(actual).isEqualTo(expected);

    }
    

}