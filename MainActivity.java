package com.example.kadimachat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private String[] SexList, AgeList, AreaList;
    private AutoCompleteTextView SexSpiner,AgeSpiner,AreaSpiner;
    private ArrayAdapter<String> SexAdapter,AgeAdapter,AreaAdapter;
    private TextView NickName,UserLogin, Contact;
    private CheckBox AgeAgree,TermsOfUseAgree;
    private Button GuestLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        GuestLogin = findViewById(R.id.GuestLogin);
        Contact = findViewById(R.id.Contact);
        UserLogin = findViewById(R.id.UserLogin);
        AgeAgree = findViewById(R.id.AgeAgree);
        TermsOfUseAgree = findViewById(R.id.TermsOfUseAgree);
        NickName = findViewById(R.id.NickName);
        SexSpiner = findViewById(R.id.SexSpiner);
        AgeSpiner = findViewById(R.id.AgeSpiner);
        AreaSpiner = findViewById(R.id.AreaSpiner);
        SetSex();
        SetAge();
        SetArea();
        GuestLogin();
        Contact();
        UserLogin();
    }
    public void Contact(){
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void UserLogin(){
        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
    private void SetSex(){
        SexList = new String[]{"זכר", "נקבה"};
        SexSpiner.setText("מין");
        SexAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.dropdown_item, SexList);
        SexSpiner.setAdapter(SexAdapter);
    }
    private void SetAge(){
        AgeList = new String[103];
        for(int i=18;i<121;i++)
            AgeList[i-18]=i+"";
        AgeSpiner.setText("גיל");
        AgeAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.dropdown_item, AgeList);
        AgeSpiner.setAdapter(AgeAdapter);
    }
    private void SetArea(){
        AreaList = new String[]{"דרום","מרכז","ירושלים","צפון"};
        AreaSpiner.setText("אזור");
        AreaAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.dropdown_item, AreaList);
        AreaSpiner.setAdapter(AreaAdapter);
    }
    private void GuestLogin(){
        GuestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NickName.getText().length() > 0 && AgeAgree.isChecked() && TermsOfUseAgree.isChecked() && !SexSpiner.getText().toString().equals("מין") && !AgeSpiner.getText().toString().equals("גיל") && !AreaSpiner.getText().toString().equals("אזור"))
                    ;
                else if(NickName.getText().length() <1)
                    Toast.makeText(MainActivity.this, "נא לבחור כינוי", Toast.LENGTH_LONG).show();
                else if(SexSpiner.getText().toString().equals("מין"))
                    Toast.makeText(MainActivity.this, "נא לבחור מין", Toast.LENGTH_LONG).show();
                else if(AgeSpiner.getText().toString().equals("גיל"))
                    Toast.makeText(MainActivity.this, "נא לבחור גיל", Toast.LENGTH_LONG).show();
                else if(AreaSpiner.getText().toString().equals("אזור"))
                    Toast.makeText(MainActivity.this, "נא לבחור אזור", Toast.LENGTH_LONG).show();
                else if(!AgeAgree.isChecked())
                    Toast.makeText(MainActivity.this, "נא לאשר שהגיל שלך 18 ומעלה", Toast.LENGTH_LONG).show();
                else if(!TermsOfUseAgree.isChecked())
                    Toast.makeText(MainActivity.this, "נא לאשר שקראת את התקנון", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "בעיה בהתחברות נסה שוב בעוד כמה שניות", Toast.LENGTH_LONG).show();
            }
        });
    }
}