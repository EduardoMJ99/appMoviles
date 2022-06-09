package com.example.proyectofinal.utilidades;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.sql.Time;
import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private TimePickerDialog.OnTimeSetListener listener;

    public static TimePickerFragment newInstance(TimePickerDialog.OnTimeSetListener listener){
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.setListiner(listener);
        return timePickerFragment;
    }

    public void setListiner(TimePickerDialog.OnTimeSetListener listiner){
        this.listener = listiner;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), listener,hora,min,true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}
