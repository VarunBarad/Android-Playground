package org.no_ip.varunbarad.playground.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.no_ip.varunbarad.playground.R;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

  private int numberOfMessages;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.initialiseElements(savedInstanceState);
  }

  /**
   * @param savedInstanceState Bundle containing state information when Activity is resumed
   */
  private void initialiseElements(Bundle savedInstanceState) {
    // Set the activity layout
    this.setContentView(R.layout.activity_notification);

    // Initialise and set the toolbar for the Activity
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    this.setSupportActionBar(toolbar);
    ActionBar actionBar = this.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    // Set the initial number of displayed notifications to 0
    this.numberOfMessages = 0;
  }
  
  /**
   * Called when a view has been clicked.
   *
   * @param view The view that was clicked.
   */
  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.button_small_notifications:
        this.showSmallNotification(this);
        break;
    }
  }

  private void showSmallNotification(Context context) {
    NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
    int notificationID = 1;
    builder.setSmallIcon(R.drawable.notification_icon);
    builder.setContentTitle("Small notification");
    builder.setContentText("This is a small notification, friends!!");
    builder.setNumber(++this.numberOfMessages);
    builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
    builder.setAutoCancel(true);

    // Creates explicit intent for an Activity in app
    Intent resultIntent = new Intent(context, NotificationActivity.class);

    // Create a task stack for the notification Activity handling
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
    stackBuilder.addParentStack(NotificationActivity.class);
    stackBuilder.addNextIntent(resultIntent);

    // Find the resultant pending intent to launch on clicking the notification
    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

    // Assign the notification with the intent to launch on click
    builder.setContentIntent(resultPendingIntent);

    // Pass the notification to system
    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(notificationID, builder.build());
  }
}
