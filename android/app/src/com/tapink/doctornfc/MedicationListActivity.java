package com.tapink.doctornfc;

import roboguice.activity.RoboListActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MedicationListActivity extends RoboListActivity {

  @InjectView(R.id.prescription_search) EditText mSearchText;

  private ArrayAdapter<String> mAdapter;

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.activity_prescribe);

    mSearchText.addTextChangedListener(mFilterTextWatcher);


    mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Constants.MEDICATIONS);
    setListAdapter(mAdapter);
    getListView().setTextFilterEnabled(true);
  }

  private TextWatcher mFilterTextWatcher = new TextWatcher() {
    public void afterTextChanged(Editable s) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
      mAdapter.getFilter().filter(s);
    }

  };

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    //super.onListItemClick(l, v, position, id);

    String drugName = mAdapter.getItem(position);


  }


}
