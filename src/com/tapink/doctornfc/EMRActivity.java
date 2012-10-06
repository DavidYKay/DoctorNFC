package com.tapink.doctornfc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TabHost;
import android.widget.TextView;

public class EMRActivity extends Activity {
  private TabHost mTabs;

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.activity_emr);

    mTabs = (TabHost) findViewById(R.id.tabhost);
    mTabs.setup();

    initTabs();
  }

  private void initTabs() {

    // Profile
    makeTab("profile");

    // Vitals
    makeTab("vitals");

    // Labs
    makeTab("labs");

    // XRay
    makeTab("xray");

  }

  private void makeTab(String tabName) {
    TextView text = new TextView(this);
    text.setText(tabName);

    View content = text;

    addTab(
        content,
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

  public void onClickAddTab(View v) {
    addTab(new AnalogClock(EMRActivity.this), buildTabIndicator("Clock"), "tag1");
  }

  private View buildTabIndicator(String msg) {
    View indicator = getLayoutInflater()
        .inflate(R.layout.tab_indicator, mTabs.getTabWidget(), false);
    TextView tv = (TextView) indicator.findViewById(R.id.title);
    tv.setText(msg);
    return (indicator);
  }

}
