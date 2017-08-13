package com.androidapp.elessar.andlearnapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;


public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Dialog picker = new DatePickerDialog(getActivity(),this,year,month,day);
        picker.setTitle(getResources().getString(R.string.choose_date));
        return picker;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = ((AlertDialog) getDialog()) .getButton(DialogInterface.BUTTON_POSITIVE);
        button.setText(getResources().getString(R.string.ready));
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        TextView dateView = (TextView) getActivity().findViewById(R.id.dateView);
        dateView.setText(day + "-" + month + "-" + year);
    }
}
