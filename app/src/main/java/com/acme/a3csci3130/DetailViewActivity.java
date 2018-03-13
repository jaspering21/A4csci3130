package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField,busnum,pbField,addressField,provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        busnum = (EditText) findViewById(R.id.num);
        pbField = (EditText) findViewById(R.id.pb);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            busnum.setText(receivedPersonInfo.num);
            pbField.setText(receivedPersonInfo.pb);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        CreateContactAcitivity contact= new CreateContactAcitivity();
        //String personID = appState.firebaseReference.push().getKey();
        String personID = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String num = busnum.getText().toString();
        String address =addressField.getText().toString();
        String pb = pbField.getText().toString();
        String province = provinceField.getText().toString();

        if(!contact.checkNum(num))
            Toast.makeText(this,"Business not valid",Toast.LENGTH_LONG).show();
        if(!contact.checkName(name))
            Toast.makeText(this,"Name is not valid",Toast.LENGTH_LONG).show();
        if(!contact.checkPb(pb))
            Toast.makeText(this,"Primary Business is not valid",Toast.LENGTH_LONG).show();
        if(!contact.checkAddress(address))
            Toast.makeText(this,"Address not valid",Toast.LENGTH_LONG).show();
        if (!contact.checkProvince(province))
            Toast.makeText(this,"Province not valid",Toast.LENGTH_LONG).show();
        if(contact.checkNum(num)&&contact.checkName(name)&&contact.checkPb(pb)&&contact.checkAddress(address)&&contact.checkProvince(province)) {
            Contact person = new Contact(personID, name, num, pb, address, province);
            appState.firebaseReference.child(personID).setValue(person);
        }
        finish();
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String uid = receivedPersonInfo.uid;
        appState.firebaseReference.child(uid).removeValue();
        finish();;
    }
}
