package com.tapink.doctornfc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class EMRActivity extends Activity {
  private TabHost mTabs;

  private static final String[] words = {"lorem", "ipsum", "dolor",
    "sit", "amet", "consectetuer", "adipiscing", "elit",
    "morbi", "vel", "ligula", "vitae", "arcu", "aliquet",
    "mollis", "etiam", "vel", "erat", "placerat", "ante",
    "porttitor", "sodales", "pellentesque", "augue", "purus"};

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
    ListView medsList = (ListView) medView.findViewById(R.id.meds_list);
    medsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words));
    addTab(
        medView,
        buildTabIndicator("medications"),
        "medications"
        );

    // Labs
    //makeSimpleTab("labs");
    makeTabWithLayout(R.layout.labs, "labs");

    // XRay
    //makeSimpleTab("xray");
    makeTabWithLayout(R.layout.xray, "xray");
  }

  private void makeTabWithLayout(int layoutId, String tabName) {
    View medView = getLayoutInflater().inflate(layoutId, mTabs.getTabWidget(), false);

    addTab(
        medView,
        buildTabIndicator(tabName),
        tabName
        );

  }

//  private void makeSimpleTab(String tabName) {
//    TextView text = new TextView(this);
//    text.setText(tabName);
//
//    View content = text;
//
//    addTab(
//        content,
//        buildTabIndicator(tabName),
//        tabName
//        );
//  }

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



}
