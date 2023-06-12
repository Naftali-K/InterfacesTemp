package com.example.interfacestemp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.interfacestemp.R;
import com.example.interfacestemp.interfaces.SecondInterface;

/**
 * @Author: naftalikomarovski
 * @Date: 2023/06/12
 */

public class AgeDialog extends DialogFragment {

    public static final String DIALOG_TAG = "AgeDialog";

    private SecondInterface callback;

    private EditText inputEditText;
    private Button cancelBtn, okBtn;

    public AgeDialog(SecondInterface callback) {
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_age, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        setReferences(view);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.userAge(inputEditText.getText().toString());
                dismiss();
            }
        });

        return builder.create();
    }

    private void setReferences(View view) {
        inputEditText = view.findViewById(R.id.input_edit_text);
        cancelBtn = view.findViewById(R.id.cancel_btn);
        okBtn = view.findViewById(R.id.ok_btn);
    }
}
