package com.example.myfirsthelloapplication.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FireDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
//        dialog.setTitle("着火了").setMessage("跑不跑?").setPositiveButton("跑",new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        return null;
    }
}
