package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField,busnum,pbField,addressField,provinceField;
    private MyApplicationData appState;
    private ArrayList<String> provincearray = new ArrayList<>(Arrays.asList("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK"));
    private ArrayList<String> pbarray = new ArrayList<>(Arrays.asList("Fisher", "Distributor", "Processor", "Fish Monger"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        busnum = (EditText) findViewById(R.id.num);
        pbField = (EditText) findViewById(R.id.pb);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        Integer num = busnum.getText().length();
        String address =addressField.getText().toString();
        boolean pass=true;
        if(!provincearray.contains(provinceField.getText())) {
            pbField.setText("Primary Business is not valid");
            pass = false;
        }
        if (!pbarray.contains(pbField.getText())) {
            pbField.setText("Province is not valid");
            pass=false;
        }

        if(pass=true) {
            String pb = pbField.getText().toString();
            String province = provinceField.getText().toString();
            Contact person = new Contact(personID, name, num, pb, address, province);
            appState.firebaseReference.child(personID).setValue(person);
        }
        finish();
    }
}
