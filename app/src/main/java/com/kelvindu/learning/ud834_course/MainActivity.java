package com.kelvindu.learning.ud834_course;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method ini dipanggil saat tombol plus di click
     * */
    public void increment(View view){
        jumlah = jumlah +1 ;
        tampilkan(jumlah);
    }

    /**
     * */
    public void decrement(View view){
        jumlah = jumlah - 1;
        tampilkan(jumlah);
    }

    /**
     * Method ini dipanggil saat tombol order di click.
     * */
    public void submitOrder(View view){
        int harga = jumlah * 5;
        String pesan = "Total seluruhnya $" +harga+"\nTerima kasih!";
        //tampilkanHarga(jumlah * 5);
        tampilkanPesan(pesan);
    }

    /**
     * Method ini menampilkan nilai jumlah ke layar.
     * */
    private void tampilkan(int angka) {
        TextView jumlahTextView = (TextView) findViewById(
                R.id.jumlah_text_view);
        jumlahTextView.setText("" + angka);
    }

    /**
     * Method ini menampilkan pesan ke layar android
     * */
    private void tampilkanPesan(String pesan) {
        TextView hargaTextView = (TextView) findViewById(R.id.harga_text_view);
        hargaTextView.setText(pesan);
    }

    /**
     * Method ini menampilkan nilai harga ke layar
     * */
    private void tampilkanHarga(int angka){
        TextView hargaTextView = (TextView) findViewById(R.id.harga_text_view);
        hargaTextView.setText(NumberFormat.getCurrencyInstance().format(angka));
    }
}
