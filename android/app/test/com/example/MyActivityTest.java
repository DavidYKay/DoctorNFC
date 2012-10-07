package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tapink.doctornfc.EMRActivity;
import com.tapink.doctornfc.R;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

  @Test
  public void shouldHaveHappySmiles() throws Exception {
    String hello = new EMRActivity().getResources().getString(R.string.app_name);
    assertThat(hello, equalTo("DoctorNFC"));
  }

  @Test
  public void testRegex() {

    //String regex = "patients/([a-zA-Z0-9]\\+)";
    String regex = "http://doctornfc.com/patients(/[a-zA-Z0-9]+)?";
    Pattern pattern = Pattern.compile(regex);

    String[] inputs = {
      "http://doctornfc.com/patients",
      "http://doctornfc.com/patients/1",
      "http://doctornfc.com/patients/kennedy",
    };
    for (String input : inputs) {
      Matcher matcher = pattern.matcher(input);
      assertThat(matcher.find(), equalTo(true));
    }


  }
}
