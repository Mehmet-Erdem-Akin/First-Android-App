     package com.example.javatemelleri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Dikkat !");
        alert.setMessage("Kendimiz, sevdiklerimiz ve toplum sağlığı için; maske, sosyal mesafe ve hijyen kurallarına uyalım!");
        alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // save
                Toast.makeText(MainActivity.this, "Kurallara uyacağınız için teşekkürler",Toast.LENGTH_LONG).show();

            }
        });
        alert.show();


        EditText editText=(EditText) findViewById(R.id.yas);
        Button button=(Button) findViewById(R.id.btn);
        TextView sonuc=(TextView) findViewById(R.id.sonuc);
        View view=(View) findViewById(R.id.view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yas = yashesapla(Integer.parseInt(editText.getText().toString()));
                int saat = CurrentHour();
                boolean haftasonumu =HaftaSonu();
                if ( yas <= 20){

                    if ( saat>=13 && saat<16){
                        sonuc.setText("saat, 13 ile 16 arasında. 20 yaş altı serbest.");
                        view.setBackgroundColor(Color.rgb(34,139,34));


                    }else {
                        sonuc.setText("saat, 13 ile 16 arasında değil. 20 yaş altı yasaktır.");
                        view.setBackgroundColor(Color.RED);


                    }
                }else if(yas>20 && yas<65){
                    if ( haftasonumu ) {
                        if ( saat<10 || saat>20){
                            sonuc.setText("20-65 yaş arası için Yasaktır.");
                            view.setBackgroundColor(Color.RED);

                        }else {
                            sonuc.setText("20-65 yaş arası için Serbest.");
                            view.setBackgroundColor(Color.rgb(34,139,34));

                        }
                    }else {
                        sonuc.setText("20-65 yaş arası için Serbest.");
                        view.setBackgroundColor(Color.rgb(34,139,34));

                    }

                }else if ( yas >= 65){

                    if( saat>=10 && saat<13 ){
                        sonuc.setText("saat, 10 ile 13 arasında. 65 yaş üstü Serbest");
                        view.setBackgroundColor(Color.rgb(34,139,34));

                    }else {
                        sonuc.setText("saat, 10 ile 13 arasında değil. 65 yaş üstü yasaktır.");
                        view.setBackgroundColor(Color.RED);

                    }
                }
            }
        });
        


    }

    public int CurrentYear() {
        Date date= Calendar.getInstance().getTime();
        DateFormat dateFormat=new SimpleDateFormat("yyyy");
        String tarih =dateFormat.format(date);
        int tarihint = Integer.parseInt(tarih);
        return tarihint;
    }

    public int CurrentDay(){

        Date date= Calendar.getInstance().getTime();
        DateFormat dateFormat=new SimpleDateFormat("u");
        String tarih =dateFormat.format(date);
        int currentday = Integer.parseInt(tarih);

        return currentday;
    }
    public boolean HaftaSonu() {
        if (CurrentDay()==6 || CurrentDay()==7){
            return true;
        }else {
            return false;
        }
    }

    public int CurrentHour(){

        Date date= Calendar.getInstance().getTime();
        DateFormat dateFormat=new SimpleDateFormat("k");
        String tarih =dateFormat.format(date);
        int currenthour = Integer.parseInt(tarih);

        return currenthour;
    }


    public int yashesapla(int yil){
        //int tarih = 2020;
        return yil;
    }
}