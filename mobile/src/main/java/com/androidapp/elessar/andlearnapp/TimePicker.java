package com.androidapp.elessar.andlearnapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;


public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes  = calendar.get(Calendar.MINUTE);

        Dialog time_picker = new TimePickerDialog(getActivity(),this,hour,minutes,true);
        time_picker.setTitle(getResources().getString(R.string.choose_time));
        return time_picker;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = ((AlertDialog) getDialog()) .getButton(DialogInterface.BUTTON_POSITIVE);
        button.setText(getResources().getString(R.string.choose_time));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int hours, int minutes) {
        TextView timeView = (TextView) getActivity().findViewById(R.id.timeView);
        timeView.setText(hours + ":" + minutes);
    }
}
