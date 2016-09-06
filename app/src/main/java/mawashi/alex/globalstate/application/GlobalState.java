package mawashi.alex.globalstate.application;

 import android.app.Application;
 import android.widget.Toast;

public class GlobalState extends Application {

     private int gameScore = 0;
     private int schermata = 1;

     @Override
     public void onCreate(){
         super.onCreate();
         Toast.makeText(GlobalState.this, "Creation of the APP", Toast.LENGTH_LONG).show();

     }

     public int getSchermata(){
         return schermata;
     }

     public void setSchermata(int schermata){
         this.schermata = schermata;
     }

     public int getScore() {
         return gameScore;
     }

     public void setScore(int gameScore) {
         this.gameScore = gameScore;
     }


}