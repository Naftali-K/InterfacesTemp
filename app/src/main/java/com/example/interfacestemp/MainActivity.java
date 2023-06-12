package com.example.interfacestemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.interfacestemp.dialogs.AgeDialog;
import com.example.interfacestemp.dialogs.FamilyDialog;
import com.example.interfacestemp.dialogs.NameDialog;
import com.example.interfacestemp.interfaces.FirstInterface;
import com.example.interfacestemp.interfaces.SecondInterface;

/**
 * Project Idea:
 * Check/test/try and make use 2 options of interface. By "implements" and by anonymous using interface.
 * Successfully use both options. Working well.
 */

public class MainActivity extends AppCompatActivity implements FirstInterface {

    private TextView userNameTextView, userFamilyTextView, userAgeTextView;
    private Button openNameDialogBtn, openFamilyDialogBtn, openAgeDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setReferences();

        openNameDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNameDialog();
            }
        });
        openFamilyDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFamilyDialog();
            }
        });
        openAgeDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAgeDialog();
            }
        });
    }

    private void setReferences() {
        userNameTextView = findViewById(R.id.user_name_text_view);
        userFamilyTextView = findViewById(R.id.user_family_text_view);
        userAgeTextView = findViewById(R.id.user_age_text_view);
        openNameDialogBtn = findViewById(R.id.open_name_dialog_btn);
        openFamilyDialogBtn = findViewById(R.id.open_family_dialog_btn);
        openAgeDialogBtn = findViewById(R.id.open_age_dialog_btn);
    }

    private void openNameDialog() {
        NameDialog dialog = new NameDialog(this);
        dialog.show(getSupportFragmentManager(), NameDialog.DIALOG_TAG);
    }

    private void openFamilyDialog() {
        FamilyDialog dialog = new FamilyDialog(this);
        dialog.show(getSupportFragmentManager(), FamilyDialog.DIALOG_TAG);
    }

    private void openAgeDialog() {
        AgeDialog dialog = new AgeDialog(new SecondInterface() {
            @Override
            public void userAge(String age) {
                userAgeTextView.setText(age);
            }
        });
        dialog.show(getSupportFragmentManager(), AgeDialog.DIALOG_TAG);
    }

    @Override
    public void backPress() {

    }

    @Override
    public void userName(String userName) {
        userNameTextView.setText(userName);
    }

    @Override
    public void familyName(String familyName) {
        userFamilyTextView.setText(familyName);
    }
}