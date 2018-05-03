package com.customconcern.awesomeapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.Map;

public class LoggedInActivity extends AppCompatActivity {
    private TextView loggedInTextView;
    private Marker marker;
    private static final String TAG = LoggedInActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        loggedInTextView = findViewById(R.id.textViewLoggedInMessage);

        BackendlessUser user = Backendless.UserService.CurrentUser();

        loggedInTextView.setText("Welcome, " + user.getEmail() + "!");

        marker = new Marker("Red", Marker.tipTypes.CHISEL);

        // save on a new thread and wait for the save to finish
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                Marker m = Backendless.Data.save(marker);
                Log.i(TAG, "Saving marker " + m.getColor() + " with objectId " + m.getObjectId());
            }
        });
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            Log.e(TAG, "Saving marker failed: " + e.getMessage());
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(LoggedInActivity.this);
            builder.setMessage(e.getMessage());
            builder.setTitle(R.string.bad_marker_save);
            builder.setPositiveButton(android.R.string.ok, null);
            android.app.AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
