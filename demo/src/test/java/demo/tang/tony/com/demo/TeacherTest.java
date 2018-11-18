package demo.tang.tony.com.demo;


import com.google.common.truth.Truth;

import org.junit.Test;

public class TeacherTest {

    @Test
    public void builder() {
        Teacher tony1 = Teacher.builder().id("1").name("Tony").build();
        Teacher tony2 = Teacher.builder().id("1").name("Tony").build();
        Truth.assertThat(tony1).isEqualTo(tony2);
    }

    @Test(expected = RuntimeException.class)
    public void builder_error() {
        Teacher.builder().id("1").build();
    }
}