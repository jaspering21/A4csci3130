package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        String num = busnum.getText().toString();
        String address =addressField.getText().toString();
        String pb = pbField.getText().toString();
        String province = provinceField.getText().toString();

        if(!checkNum(num))
            Toast.makeText(this,"Business not valid",Toast.LENGTH_SHORT).show();
        if(!checkName(name))
            Toast.makeText(this,"Name is not valid",Toast.LENGTH_SHORT).show();
        if(!checkPb(pb))
            Toast.makeText(this,"Primary Business is not valid",Toast.LENGTH_SHORT).show();
        if(!checkAddress(address))
            Toast.makeText(this,"Address not valid",Toast.LENGTH_SHORT).show();
        if (!checkProvince(province))
            Toast.makeText(this,"Province not valid",Toast.LENGTH_SHORT).show();
        if(checkNum(num)&&checkName(name)&&checkPb(pb)&&checkAddress(address)&&checkProvince(province)) {
            Contact person = new Contact(personID, name, num, pb, address, province);
            appState.firebaseReference.child(personID).setValue(person);
        }
        finish();
    }

    public boolean checkNum(String num){
        boolean pass=true;
        if(num.length()!=9) {
            pass = false;
        }
        return pass;
    }
    public boolean checkName(String name){
        boolean pass=true;
        if (name.length()<2||name.length()>49) {
            pass = false;
        }
        return pass;
    }

    public boolean checkPb(String pb){
        boolean pass=true;
        if(!pbarray.contains(pb)) {
            pass = false;
        }
        return pass;
    }

    public boolean checkAddress(String address) {
        boolean pass=true;
        if(address.length()>50) {
            pass = false;
        }
        return pass;
    }

    public boolean checkProvince(String province) {
        boolean pass=true;
        if(!provincearray.contains(province)) {
            pass = false;
        }
        return pass;
    }
}
