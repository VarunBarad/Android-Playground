package org.no_ip.varunbarad.playground.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.no_ip.varunbarad.playground.R;
import org.no_ip.varunbarad.playground.activity.notification.NotificationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Snackbar snackbar;
  private FloatingActionButton floatingActionButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set and initialise different components of the Activity
    this.initialiseElements(savedInstanceState);
  }

  private void initialiseElements(Bundle savedInstanceState) {
    // Set the activity layout
    this.setContentView(R.layout.activity_main);

    // Initialise and set the toolbar for the Activity
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    this.setSupportActionBar(toolbar);

    // Initialise the FAB
    this.floatingActionButton = (FloatingActionButton) this.findViewById(R.id.floating_action_button_about_us);
    this.floatingActionButton.setOnClickListener(this);
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    this.getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    
    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }
    
    return super.onOptionsItemSelected(item);
  }

  /**
   * Called when a view has been clicked.
   *
   * @param view The view that was clicked.
   */
  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.floating_action_button_about_us:
        this.showSnackBar(view);
        break;
      case R.id.button_notification:
        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        this.startActivity(notificationIntent);
        break;
    }
  }

  private void showSnackBar(View view) {
    if (this.snackbar != null && this.snackbar.isShownOrQueued()) {
      this.snackbar.dismiss();
      this.floatingActionButton.setImageResource(android.R.drawable.ic_dialog_info);
    } else {
      this.snackbar = Snackbar.make(view, "Snackbar text goes here", Snackbar.LENGTH_INDEFINITE);
      this.snackbar.show();
      this.floatingActionButton.setImageResource(android.R.drawable.ic_menu_delete);
    }
  }
}
