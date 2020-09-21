package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The OptionsMenu is available on the MainMenu and currently has two options.
 * There is an EditText field where the player may set a name. This is how debug may be enabled.
 * And there is a reset save button where the player may reset the game save back to default values.
 */
public class OptionsMenu extends AppCompatActivity {

    Controller cont;
    EditText nameField;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        cont = ((Controller) this.getApplication());

        Button resetButton = findViewById(R.id.resetButton);
        Button doneButton = findViewById(R.id.goBackButton);
        nameField = findViewById(R.id.editTextTextPersonName);

        nameField.setText(""+cont.getPlayerName(), TextView.BufferType.EDITABLE);


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Do you want to reset your save?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                cont.resetSave();
                                Toast.makeText(getApplicationContext(), "Your save has been reset",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.setPlayerName(nameField.getText().toString());
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        cont.playSound(R.raw.papers_down_short);
    }
}