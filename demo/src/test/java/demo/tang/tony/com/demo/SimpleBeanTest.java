package demo.tang.tony.com.demo;

import com.google.common.truth.Truth;

import org.junit.Test;

public class SimpleBeanTest {


    @Test
    public void builder() {


        SimpleBean.Builder builder = SimpleBean.builder();
        builder.objectId("1");
        builder.title("2");
        SimpleBean simpleBean1 = builder.build();
        SimpleBean simpleBean2 = builder.build();

        SimpleBean simpleBean3 = SimpleBean.builder().title("2").objectId("1").build();


        Truth.assertThat(simpleBean1).isEqualTo(simpleBean2);
        Truth.assertThat(simpleBean1).isEqualTo(simpleBean3);

        //1, immutability. 再也不会被别人修改了。
        //2,
    }


    @Test(expected = IllegalStateException.class)
    public void builder_title_null() {
        SimpleBean.Builder builder = SimpleBean.builder();
        builder.objectId("1");
        builder.build();
    }

    @Test
    public void builder_content_null() {
        SimpleBean.Builder builder = SimpleBean.builder();
        builder.objectId("1");
        builder.title("2");
        builder.build();
    }

}