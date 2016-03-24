package com.rafaelgb.pascoafeliz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtQuantidade;
    TextView lblMensagem;
    ImageView imgOvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtQuantidade = (EditText)findViewById(R.id.txt_quantidade);
        lblMensagem = (TextView)findViewById(R.id.lbl_mensagem);
        imgOvo = (ImageView)findViewById(R.id.img_ovo);
    }

    public void calcular(View view){

        int qtdKgOvos = 0;
        try
        {
            qtdKgOvos = Integer.parseInt(txtQuantidade.getText().toString());
        }catch (NumberFormatException ex){

        }
        String mensagem = String.format("Com %skg de chocolate. dá pra fazer %d ovos de 500g",txtQuantidade.getText(), qtdKgOvos*2);
        lblMensagem.setText(mensagem);
        lblMensagem.setVisibility(View.VISIBLE);
        imgOvo.setVisibility(View.VISIBLE);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
