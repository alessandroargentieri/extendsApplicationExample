package mawashi.alex.globalstate.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mawashi.alex.globalstate.R;
import mawashi.alex.globalstate.application.GlobalState;
import mawashi.alex.globalstate.domain.ChangeSchermata;
import mawashi.alex.globalstate.domain.MaximumSchermataException;
import mawashi.alex.globalstate.domain.PreviousSchermataException;

public class MainActivity extends AppCompatActivity {

    EditText Score;
    TextView Schermata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Score = (EditText)findViewById(R.id.gameScore);
        Schermata = (TextView)findViewById(R.id.schermata);
    }

    @Override
     protected void onResume() {
         super.onResume();
         GlobalState state = ((GlobalState) getApplicationContext());
         Score.setText(String.valueOf(state.getScore()));
         Schermata.setText(String.valueOf(state.getSchermata()));
     }


    public void Previous(View view) {
        int score = Integer.parseInt(Score.getText().toString());

        GlobalState state = ((GlobalState) getApplicationContext());
        state.setScore(score);


        try{
            ChangeSchermata change = new ChangeSchermata(getApplicationContext());
            change.decrease();
        }catch(PreviousSchermataException e){
            Toast.makeText(this.getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
            state.setSchermata(state.getSchermata());
        }
        state.setSchermata(state.getSchermata());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


     public void Next(View view) {
         int score = Integer.parseInt(Score.getText().toString());

         GlobalState state = ((GlobalState) getApplicationContext());
         state.setScore(score);

         try{
             ChangeSchermata change = new ChangeSchermata(getApplicationContext());
             change.increase();
         }catch(MaximumSchermataException e){
             Toast.makeText(this.getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
             state.setSchermata(state.getSchermata());
         }
         state.setSchermata(state.getSchermata());

         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
         finish();
     }




}
