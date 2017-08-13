package com.androidapp.elessar.andlearnapp;

import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Context application_context;
    public Toast toast;
    public Intent notificationIntent;
    public PendingIntent pendingIntent;
    public Notification notification;
    public NotificationManager notificationManager;
    public Resources application_resources;
    public Notification.Builder notification_builder;
    private static final int NOTIFY_ID = 101;

    public String long_text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        showToast("Connected!");
        showNotification();
        alertDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void showToast(String text) {
        if (application_context == null) {
            application_context = getApplicationContext();
        }
        toast = Toast.makeText(application_context,text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void showNotification() {
        if (application_context == null) {
            application_context = getApplicationContext();
        }
        application_resources = application_context.getResources();
        notificationIntent = new Intent(application_context,MainActivity.class);
//        notificationIntent = new Intent();
//        notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.1.13"));
        pendingIntent = PendingIntent.getActivity(application_context,0,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);
        notificationManager = (NotificationManager) application_context.getSystemService(Context.NOTIFICATION_SERVICE);
        notification_builder = new Notification.Builder(application_context);
        notification_builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.zombie_icream_icon)
                .setLargeIcon(BitmapFactory.decodeResource(application_resources,R.drawable.zombie_icream_icon))
                .setTicker("Hello,World!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentText("Hello,Petar")
                .setContentTitle("Hello,World!");
//        notification = notification_builder.build();
        notification = new Notification.BigTextStyle(notification_builder).bigText(long_text).build();
//        notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS;
//        notification.sound = Uri.parse();
        notificationManager.notify(NOTIFY_ID,notification);
    }

    public void alertDialog() {
        DialogInterface.OnClickListener dialog_listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == DialogInterface.BUTTON_NEGATIVE){
                    dialogInterface.cancel();
                } else {
                    showToast("Yes button!");
                }
            }
        };
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setCancelable(false)
                .setMessage("AlertDialog Message")
                .setPositiveButton("Yes",dialog_listener)
                .setNegativeButton("No",dialog_listener);
        AlertDialog alertDialog = alert_builder.create();
        alertDialog.setTitle("Alert dialog title");
        alertDialog.show();
    }

    public void setDateView(View view) {
        DialogFragment dateDialogFragment = new DatePicker();
        dateDialogFragment.show(getFragmentManager(),"datePicker");
    }

    public void setTimeView(View view) {
        DialogFragment timeDialogFragment = new TimePicker();
        timeDialogFragment.show(getFragmentManager(),"timePicker");

    }

    public void showSecondView(View view) {
        Intent showSecondView = new Intent(this,SecondActivity.class);
        startActivity(showSecondView);
    }
}
