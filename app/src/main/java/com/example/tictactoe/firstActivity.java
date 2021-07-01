package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class firstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view)
    {
        EditText et1 = findViewById(R.id.p1);
        EditText et2 = findViewById(R.id.p2);

        String p1= et1.getText().toString();




        String p2= et2.getText().toString();


        Intent intent = new Intent(this,MainActivity.class);

        intent.putExtra("p1details",p1);
        intent.putExtra("p2details",p2);
        if(TextUtils.isEmpty(et1.getText()))
        {
            et1.setError(" Please Enter Player 1 Name ");
        }else if (TextUtils.isEmpty(et2.getText())){
            et2.setError(" Please Enter Player 2 Name ");
        }
        else
        {
            startActivity(intent);
            finish();
        }




    }
}