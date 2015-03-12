package com.example.usuario.funfacts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class FunFactsActivity extends ActionBarActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName(); // Even if we change the name of the class it will be change automatically

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare our View variables

        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // The Button was clicked, so update the fact label with a new fact

                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();

                factLabel.setText(fact);
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);

            }
        };
        showFactButton.setOnClickListener(listener);

        //Toast notification
        //Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_LONG).show();

        //Log

        Log.d(TAG, "We are logging from the onCreate() method!");
}

}
