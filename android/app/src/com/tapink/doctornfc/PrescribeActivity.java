package com.tapink.doctornfc;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

@ContentView(R.layout.activity_prescribe)
public class PrescribeActivity extends RoboActivity {

  @InjectView(R.id.spinner) Spinner mSpinner;
  //private ArrayAdapter<String> mAdapter;

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Constants.LOREM_ARRAY);
    mSpinner.setAdapter(adapter);

  }

}
