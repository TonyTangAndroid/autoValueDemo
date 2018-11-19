package demo.tang.tony.com.demo;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.io.IOException;

public class IgnoredTest {


    @Test
    public void builder_error() throws IOException {

        SimpleBean title1 = SimpleBean.builder().objectId("1").title("").build();
        SimpleBean title2 = SimpleBean.builder().objectId("1").title("1").build();

        Truth.assertThat(title1).isEqualTo(title2);
    }


}