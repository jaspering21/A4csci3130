package com.acme.a3csci3130;

import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {
    @NonNull
    public  String uid;
    @Size(min=2,max = 48)
    public  String name;
    @Size(min = 9,max = 9)
    public  int num;
    public  String pb;
    @Size(min = 0,max=49)
    public  String address;
    public  String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name,Integer num,String pb,String address,String province){
        this.uid = uid;
        this.name = name;
        this.num = num;
        this.pb = pb;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("num", num);
        result.put("pb",pb);
        result.put("address",address);
        result.put("province",province);
        return result;
    }
}
