package mawashi.alex.globalstate.domain;


import android.content.Context;
import android.content.IntentFilter;

import mawashi.alex.globalstate.application.GlobalState;

public class ChangeSchermata {

    private Context c;
    public ChangeSchermata(Context context){
        c = context;
    }

    public void increase() throws MaximumSchermataException{
        GlobalState state = ((GlobalState) c);
        int schermata = state.getSchermata();
        if (schermata>=5)
            throw new MaximumSchermataException("Raggiunto il numero massimo di schermate");
        state.setSchermata(schermata+1);
    }

    public void decrease()throws PreviousSchermataException{
        GlobalState state = ((GlobalState) c);
        int schermata = state.getSchermata();
        if (schermata==1)
            throw new PreviousSchermataException("Non si può andare indietro");
        state.setSchermata(schermata-1);
    }


}
