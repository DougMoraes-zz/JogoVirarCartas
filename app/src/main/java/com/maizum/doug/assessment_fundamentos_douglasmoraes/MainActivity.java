package com.maizum.doug.assessment_fundamentos_douglasmoraes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int cartaAs = random.nextInt(3) + 1;
    int cartaEscolhida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView cartaUm = (ImageView) findViewById(R.id.imgCarta1);
        final ImageView cartaDois = (ImageView) findViewById(R.id.imgCarta2);
        final ImageView cartaTres = (ImageView) findViewById(R.id.imgCarta3);
        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        final TextView txtMensagem = (TextView) findViewById(R.id.txtMensagem);
        final Button btnNovamente = (Button) findViewById(R.id.btnNovamente);

        View.OnClickListener cliqueCartaUm = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartaEscolhida = 1;
            }
        };

        View.OnClickListener cliqueCartaDois = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartaEscolhida = 2;
            }
        };

        View.OnClickListener cliqueCartaTres = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartaEscolhida = 3;
            }
        };

        View.OnClickListener cliqueConfirmar = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (cartaEscolhida) {
                    case 1:
                        if (cartaEscolhida == cartaAs) {
                            cartaUm.setImageResource(R.drawable.carta_as);
                            txtMensagem.setText(R.string.txt_vitoria);
                        } else {
                            cartaUm.setImageResource(R.drawable.carta_coringa);
                            txtMensagem.setText(R.string.txt_derrota);
                        }
                        cartaDois.setClickable(false);
                        cartaTres.setClickable(false);
                        break;
                    case 2:
                        if (cartaEscolhida == cartaAs) {
                            cartaDois.setImageResource(R.drawable.carta_as);
                            txtMensagem.setText(R.string.txt_vitoria);
                        } else {
                            cartaDois.setImageResource(R.drawable.carta_coringa);
                            txtMensagem.setText(R.string.txt_derrota);
                        }
                        cartaUm.setClickable(false);
                        cartaTres.setClickable(false);
                        break;
                    case 3:
                        if (cartaEscolhida == cartaAs) {
                            cartaTres.setImageResource(R.drawable.carta_as);
                            txtMensagem.setText(R.string.txt_vitoria);
                        } else {
                            cartaTres.setImageResource(R.drawable.carta_coringa);
                            txtMensagem.setText(R.string.txt_derrota);
                        }
                        cartaDois.setClickable(false);
                        cartaUm.setClickable(false);
                        break;
                }

                btnNovamente.setVisibility(View.VISIBLE);
            }
        };

        View.OnClickListener cliqueNovamente = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartaUm.setImageResource(R.drawable.carta_verso);
                cartaDois.setImageResource(R.drawable.carta_verso);
                cartaTres.setImageResource(R.drawable.carta_verso);
                cartaUm.setClickable(true);
                cartaDois.setClickable(true);
                cartaTres.setClickable(true);
                cartaAs = random.nextInt(3) + 1;
                txtMensagem.setText("");
                btnNovamente.setVisibility(View.INVISIBLE);
            }
        };

        cartaUm.setOnClickListener(cliqueCartaUm);
        cartaDois.setOnClickListener(cliqueCartaDois);
        cartaTres.setOnClickListener(cliqueCartaTres);

        btnConfirmar.setOnClickListener(cliqueConfirmar);
        btnNovamente.setOnClickListener(cliqueNovamente);

    }

}
