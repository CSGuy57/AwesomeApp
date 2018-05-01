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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        loggedInTextView = findViewById(R.id.textViewLoggedInMessage);

        BackendlessUser user = Backendless.UserService.CurrentUser();

        loggedInTextView.setText("Welcome, " + user.getEmail() + "!");

        Marker marker = new Marker("Red", Marker.tipTypes.CHISEL);
    }
}
