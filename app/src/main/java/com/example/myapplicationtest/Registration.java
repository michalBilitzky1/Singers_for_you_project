package com.example.myapplicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;


import com.example.myapplicationtest.RegistrationP.PoetsRegistration;
import com.example.myapplicationtest.RegistrationP.SingersRegistration;
//import com.example.myapplicationtest.RegistrationP.PoetsRegistration;
import com.example.myapplicationtest.RegistrationP.ComposerRegistration;

public class Registration extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

    }

    public void registration_click(View view) {

        switch (view.getId()){
            case R.id.singers2:
                Intent intent = new Intent(Registration.this, SingersRegistration.class);
                startActivity(intent);
                break;
            case R.id.poets2:
                Intent intent2 = new Intent(Registration.this, PoetsRegistration.class);
                startActivity(intent2);
                break;
            case R.id.composer2:
                Intent intent3 = new Intent(Registration.this, ComposerRegistration.class);
                startActivity(intent3);
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

    }
    public void back_choice_click(View view) {
        Intent intent = new Intent(this, ChoiceSingerOrProduct.class);
        startActivity(intent);
    }


}
