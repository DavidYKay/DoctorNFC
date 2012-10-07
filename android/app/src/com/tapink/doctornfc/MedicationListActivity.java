package com.tapink.doctornfc;

import roboguice.activity.RoboListActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

@ContentView(R.layout.activity_prescription_list)
public class MedicationListActivity extends RoboListActivity {

  @InjectView(R.id.prescription_search)
  EditText mSearchText;

  private ArrayAdapter<String> mAdapter;

  static final int NEW_PRESCRIPTION_REQUEST = 1;

  private static final String TAG = "MedicationListActivity";

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    mSearchText.addTextChangedListener(mFilterTextWatcher);

    mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        Constants.MEDICATIONS);
    setListAdapter(mAdapter);
    getListView().setTextFilterEnabled(true);
  }

  private TextWatcher mFilterTextWatcher = new TextWatcher() {
    public void afterTextChanged(Editable s) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
      mAdapter.getFilter().filter(s);
    }

  };

  protected void onActivityResult(int requestCode, int resultCode,
                                  Intent data) {
    Log.v(TAG, "onActivityResult: " + requestCode);
    if (requestCode == NEW_PRESCRIPTION_REQUEST) {
      if (resultCode == RESULT_OK) {
         setResult(
             RESULT_OK,
             data);
         finish();
      }
    }
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    String drugName = mAdapter.getItem(position);
    Intent intent = new Intent(this, PrescribeActivity.class);
    intent.putExtra("DRUG_NAME", drugName);

    startActivityForResult(intent, NEW_PRESCRIPTION_REQUEST);
  }

}
