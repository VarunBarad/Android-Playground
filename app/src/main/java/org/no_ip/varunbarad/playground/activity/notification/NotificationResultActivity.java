package org.no_ip.varunbarad.playground.activity.notification;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.no_ip.varunbarad.playground.R;

public class NotificationResultActivity extends AppCompatActivity {
  
  private String message;

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
    this.setContentView(R.layout.activity_notification_result);

    // Initialise and set the toolbar for the Activity
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    this.setSupportActionBar(toolbar);
    ActionBar actionBar = this.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    // Extract the message from notification
    this.message = this.getIntent().getExtras().getString("MESSAGE", "No message received");
    ((TextView) this.findViewById(R.id.textView_message)).setText(this.message);
  }
  
}
