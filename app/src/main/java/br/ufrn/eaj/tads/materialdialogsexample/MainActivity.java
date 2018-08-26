package br.ufrn.eaj.tads.materialdialogsexample;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Integer[] selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1 (View v){

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Titulo")
                .content("Conteúdo")
                .positiveText("Sim")
                .negativeText("Não")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MainActivity.this, "Sim", Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        dialog.show();
    }

    public void onClick2(View v){

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Selecione uma cor")
                .items(R.array.cores)
                .positiveText("Ok")
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        ConstraintLayout fundo = findViewById(R.id.layout);
                        switch (which){
                            case 0:{
                                fundo.setBackgroundResource(android.R.color.holo_red_dark);
                                break;
                            }
                            case 1:{
                                fundo.setBackgroundResource(android.R.color.holo_orange_dark);
                                break;
                            }
                            case 2:{
                                fundo.setBackgroundResource(android.R.color.holo_blue_light);
                                break;
                            }
                        }
                        return true;
                    }
                })
                .build();
        dialog.show();
    }

    public void onClick3 (View v){

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Selecione as frutas:")
                .items(R.array.frutas)
                .positiveText("Ok")
                .itemsCallbackMultiChoice(selected, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                        Toast.makeText(MainActivity.this, Arrays.toString(which) + " " + Arrays.toString(text), Toast.LENGTH_SHORT).show();
                        selected = which;
                        return true;
                    }
                })
                .build();

        dialog.show();
    }
}
