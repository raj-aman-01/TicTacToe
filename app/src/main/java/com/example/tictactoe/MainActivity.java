package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //view Declaration
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,newGame;

    //game variables
    String player1,player2;

    //to store values when buttons are clicked

    char[][] board;
    char currentPlayer;
    int moves;
    int count1=0;
    int count2=0;
    TextView p1,p2;

    //player1 initial
    char player1Initial,player2Initial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        //initialzing buttons

        bt1= findViewById(R.id.bt1);
        bt2= findViewById(R.id.bt2);
        bt3= findViewById(R.id.bt3);
        bt4= findViewById(R.id.bt4);
        bt5= findViewById(R.id.bt5);
        bt6= findViewById(R.id.bt6);
        bt7= findViewById(R.id.bt7);
        bt8= findViewById(R.id.bt8);
        bt9= findViewById(R.id.bt9);
        newGame= findViewById(R.id.newGame);



        //attach on click listener on buttons

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        newGame.setOnClickListener(this);



        //to setup game
        initalize();

        Intent res =getIntent();

        p1= findViewById(R.id.player1);
        p2=findViewById(R.id.player2);





        player1=res.getStringExtra("p1details");
        player2=res.getStringExtra("p2details");

        player1Initial=player1.charAt(0);
        player2Initial= player2.charAt(0);

        p1.setText(player1+"\n"+count1);
        p2.setText(player2+"\n"+count2);




    }


    //for game initialization or game setup

    void initalize()
    {

        currentPlayer='X';
        setButtonText(" ");
        board =new char[3][3];
        setButtonEnabled(true);
        moves=0;



    }

    void setButtonText(String txt)
    {
        bt1.setText(txt);
        bt2.setText(txt);
        bt3.setText(txt);
        bt4.setText(txt);
        bt5.setText(txt);
        bt6.setText(txt);
        bt7.setText(txt);
        bt8.setText(txt);
        bt9.setText(txt);



    }
    void  setButtonEnabled(boolean enable)
    {
        bt1.setEnabled(enable);
        bt2.setEnabled(enable);
        bt3.setEnabled(enable);
        bt4.setEnabled(enable);
        bt5.setEnabled(enable);
        bt6.setEnabled(enable);
        bt7.setEnabled(enable);
        bt8.setEnabled(enable);
        bt9.setEnabled(enable);


    }
    // to change player

    void changePlayer()
    {
        if(currentPlayer== 'X')
        {
            currentPlayer='0';
        }
        else
        {
            currentPlayer='X';
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bt1:
            {
                board[0][0]=currentPlayer;



                break;
            }


            case R.id.bt2:
            {
                board[0][1]=currentPlayer;

                break;

            }

            case R.id.bt3:
            {
                board[0][2]=currentPlayer;

                break;
            }

            case R.id.bt4:
            {
                board[1][0]=currentPlayer;

                break;
            }

            case R.id.bt5:
            {
                board[1][1]=currentPlayer;

                break;
            }

            case R.id.bt6:
            {
                board[1][2]=currentPlayer;

                break;
            }

            case R.id.bt7:
            {
                board[2][0]=currentPlayer;

                break;
            }

            case R.id.bt8:
            {
                board[2][1]=currentPlayer;

                break;
            }

            case R.id.bt9:
            {
                board[2][2]=currentPlayer;

                break;
            }

            case R.id.newGame:
            {
                initalize();
                return;

            }




        }

        //every buttons common functions

        //buttton mark
        Button bt= (Button) v;
        bt.setText(String.valueOf(currentPlayer));
        //mark button un enabled
        bt.setEnabled(false);
        //change player
        moves++;

        //check winning pattern

        checkForWin();

        changePlayer();
        //mark moves



    }

    // explicit intent-- jab hamara component app k andar ho

    //implicit intent- donot specify the name of component
    // it allow a component  from another app to handle it
    



//wiining Rules
    void checkForWin()
    {

        for( int i=0;i<3;i++)
        {

           //pattern check for rows
            patternCheck(board[i][0],board[i][1],board[i][2]);

            //pattern check for col
            patternCheck(board[0][i],board[1][i],board[2][i]);







        }
        //patetrn check for left diagonal

        patternCheck(board[0][0],board[1][1],board[2][2]);

        //pattern check for right diagional
        patternCheck(board[0][2],board[1][1],board[2][0]);

        //draw conditon
        if(moves==9)
        {
            Toast.makeText(this,"Match Draws",Toast.LENGTH_SHORT).show();

        }


    }

    //pattern check

    void patternCheck(char a, char b, char c)
    {

        if(a!='\u0000'&&a==b && a==c)
        {
            if(currentPlayer=='X')
            {
                count1++;
                p1.setText(player1+"\n"+count1);



                Toast.makeText(this,player1+" WINS",Toast.LENGTH_SHORT).show();
            }
            else
            {
                count2++;
                p2.setText(player2+"\n"+count2);
                Toast.makeText(this,player2+" WINS",Toast.LENGTH_SHORT).show();
            }


            //game over
            //button disable
            setButtonEnabled(false);


        }
    }


    public void reset(View view) {
        count1=0;
        p1.setText(player1+"\n"+count1);
        p2.setText(player2+"\n"+count2);
        count2=0;
        initalize();
    }
}