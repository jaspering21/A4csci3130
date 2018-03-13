package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField,busnum,name,pb,address,province;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        busnum = (EditText) findViewById(R.id.num);
        pb = (EditText) findViewById(R.id.pb);
        address = (EditText) findViewById(R.id.address);
        province = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            busnum.setText(receivedPersonInfo.num);
            pb.setText(receivedPersonInfo.pb);
            address.setText(receivedPersonInfo.address);
            province.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String uid = receivedPersonInfo.uid;
        appState.firebaseReference.child(uid).removeValue();
        finish();;
    }
}
