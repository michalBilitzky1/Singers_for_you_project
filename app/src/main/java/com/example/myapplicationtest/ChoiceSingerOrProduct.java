package com.example.myapplicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class ChoiceSingerOrProduct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_singer_or_creator2);

        //http
      /*  try {
            String sol=new AsyncHTTP(this).execute().get();
            Log.d("D","SOLLLL "+ sol);
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.d("D","SOLLLL "+ e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.d("D","SOLLLL "+ e.getMessage());
        }*/
    }

    public void choiceClick(View view) {
        switch (view.getId()){
            case R.id.singers:
                Intent intent = new Intent(ChoiceSingerOrProduct.this, SingersActivity.class);
                startActivity(intent);
                break;
            case R.id.poets:
                Intent intent2 = new Intent(ChoiceSingerOrProduct.this, PoetsActivity.class);
                startActivity(intent2);
                break;
            case R.id.composer:
                Intent intent3 = new Intent(ChoiceSingerOrProduct.this, ComposersActivity.class);
                startActivity(intent3);
                break;
            case R.id.btregistration:
                Intent intent4 = new Intent(ChoiceSingerOrProduct.this, Registration.class);
                startActivity(intent4);
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }

    }

    public void exit_click(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

   /* public void updateTextView() {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(toThis);
    }*/
}
