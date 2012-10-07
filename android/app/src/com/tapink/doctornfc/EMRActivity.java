package com.tapink.doctornfc;

import java.util.List;

import roboguice.activity.RoboActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.inject.Inject;
import com.tapink.doctornfc.adapters.PrescriptionAdapter;
import com.tapink.doctornfc.callbacks.GetCallback;
import com.tapink.doctornfc.model.PatientManager;
import com.tapink.doctornfc.patients.Prescription;

public class EMRActivity extends RoboActivity {
  private TabHost mTabs;

  static final int PRESCRIBE_MEDICATION_REQUEST = 0;

  @Inject
  private PatientManager mPatientManager;

  private ListView mMedsList;
  private Context mContext = this;

  protected static final String TAG = "EMRActivity";

  ////////////////////////////////////////////////////////////
  // Activity Lifecycle
  ////////////////////////////////////////////////////////////

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.activity_emr);

    mTabs = (TabHost) findViewById(R.id.tabhost);
    mTabs.setup();

    initTabs();
    refreshPrescriptions();
  }

  protected void onActivityResult(int requestCode, int resultCode,
                                  Intent data) {
    Log.v(TAG, "onActivityResult: " + requestCode);
    if (requestCode == PRESCRIBE_MEDICATION_REQUEST) {
      if (resultCode == RESULT_OK) {
        String drugName = data.getStringExtra(Constants.DRUG_NAME);
        Log.v(TAG, "drug: " + drugName);
      }
    }
  }

  ////////////////////////////////////////////////////////////
  // UI Callbacks
  ////////////////////////////////////////////////////////////

  public void onClickAddTab(View v) {
    addTab(new AnalogClock(EMRActivity.this), buildTabIndicator("Clock"), "tag1");
  }

  ////////////////////////////////////////////////////////////
  // Views
  ////////////////////////////////////////////////////////////

  private void initTabs() {
    // Profile
    //makeSimpleTab("profile");
    makeTabWithLayout(R.layout.profile, "profile");

    // Vitals
    //makeSimpleTab("vitals");
    makeTabWithLayout(R.layout.vitals, "vitals");

    // Medications
    //makeSimpleTab("medications");

    View medView = getLayoutInflater().inflate(R.layout.medications, mTabs.getTabWidget(), false);
    Button newMedicationButton = (Button) medView.findViewById(R.id.new_medication_button);
    newMedicationButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivityForResult(new Intent(
            mContext,
            MedicationListActivity.class
            ),
            PRESCRIBE_MEDICATION_REQUEST
                               );
      }
    });

    mMedsList = (ListView) medView.findViewById(R.id.meds_list);
    mMedsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Constants.LOREM_ARRAY));
    addTab(
        medView,
        buildTabIndicator("medications"),
        "medications"
        );

    // Notes
    //makeSimpleTab("notes");
    makeTabWithLayout(R.layout.notes, "notes");

  }

  private void makeTabWithLayout(int layoutId, String tabName) {
    View medView = getLayoutInflater().inflate(layoutId, mTabs.getTabWidget(), false);

    addTab(
        medView,
        buildTabIndicator(tabName),
        tabName
        );

  }

  private void addTab(final View content, View indicator, String tag) {
    TabHost.TabSpec spec = mTabs.newTabSpec(tag);
    spec.setContent(new TabHost.TabContentFactory() {
      public View createTabContent(String tag) {
        return content;
      }
    });

    spec.setIndicator(indicator);
    mTabs.addTab(spec);
  }


  private View buildTabIndicator(String msg) {
    View indicator = getLayoutInflater()
        .inflate(R.layout.tab_indicator, mTabs.getTabWidget(), false);
    TextView tv = (TextView) indicator.findViewById(R.id.title);
    tv.setText(msg);
    return (indicator);
  }

  ////////////////////////////////////////////////////////////
  // ListView
  ////////////////////////////////////////////////////////////


  ////////////////////////////////////////////////////////////
  // Network
  ////////////////////////////////////////////////////////////

  private void refreshPrescriptions() {
    mPatientManager.listPrescriptions(new GetCallback<Prescription>() {

      @Override
      public void failed(Exception exception) {
        Log.e(TAG, exception.toString());
      }

      @Override
      public void itemsReceived(List<Prescription> items) {
        Log.v(TAG, "items: " + items.toString());

        PrescriptionAdapter adapter = new PrescriptionAdapter(EMRActivity.this);
        adapter.setListItems(items);
        mMedsList.setAdapter(adapter);
      }

      @Override
      public void itemReceived(Prescription item) {
        Log.v(TAG, "item: " + item.toString());

      }

    });
  }
}
