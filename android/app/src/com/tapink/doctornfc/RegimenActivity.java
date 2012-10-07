package com.tapink.doctornfc;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.inject.Inject;

@ContentView(R.layout.activity_regimen)
public class RegimenActivity extends RoboActivity {

  public static final int NOTIFY_ME_ID = 1337;
  private static final Class<RegimenActivity> NOTIFICATION_CLASS = RegimenActivity.class;

  private Context mContext = this;


  @Inject
  private NotificationManager mNotificationManager;

  //private int mCount;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void onBeginRegimen(View v) {
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        showNotification();
      }
    }, 3000);
  }

  @SuppressWarnings("deprecation")
  public void showNotification() {
    Notification note = new Notification(R.drawable.ic_launcher,
                                         mContext.getString(R.string.notification_short),
                                         System.currentTimeMillis());

    note.flags |= Notification.FLAG_AUTO_CANCEL;
    note.defaults |= Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND;

    PendingIntent i = PendingIntent.getActivity(mContext, 0, new Intent(
        mContext, NOTIFICATION_CLASS), 0);

    note.setLatestEventInfo(mContext,
                            mContext.getString(R.string.notification_title),
                            mContext.getString(R.string.notification_message),
                            i);

    // note.number = ++count;
    mNotificationManager.notify(NOTIFY_ME_ID, note);
  }

}
