package com.kelvindu.learning.ud834_course;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method ini dipanggil saat tombol plus diclick.
     * */
    public void increment(View view){
        if(jumlah == 100)
            return;
        jumlah = jumlah +1 ;
        tampilkan(jumlah);
    }

    /**
     * Method ini dipanggil saat tombol minus diclick.
     * */
    public void decrement(View view){
        if(jumlah == 1)
            return;
        jumlah = jumlah - 1;
        tampilkan(jumlah);
    }

    /**
     * Method ini dipanggil saat tombol order di click.
     * */
    public void submitOrder(View view){
        EditText fieldNama = (EditText) findViewById(R.id.nama_edit_view);
        String nama = fieldNama.getText().toString();

        //memastikan jika user ingin topping whipped cream
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean pesanWhippedCream = whippedCreamCheckBox.isChecked();

        //memastikan jika user ingin topping cokelat
        CheckBox cokelatCheckBox = (CheckBox) findViewById(R.id.cokelat_checkbox);
        boolean pesanCokelat = cokelatCheckBox.isChecked();

        int harga = hitungHarga(pesanWhippedCream,pesanCokelat);

        String pesan = buatOrderSummary(nama,harga);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java pesanan "+nama);
        intent.putExtra(Intent.EXTRA_TEXT, pesan);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Method ini membuat summary dari pesanan pelanggan.
     *
     * @param nama adalah nama dari pelanggan.
     * @param harga adalah harga dari pesanan kopi.
     * @return pesan
     * */
    private String buatOrderSummary(String nama, int harga) {
        return "Nama: " + getString(R.string.order_summary_name, nama) +
                "\nJumlah Kopi: " + jumlah +
                "\nTotal $" + harga +
                getString(R.string.thank_you);
    }

    /**
     * Method ini dipanggil untuk menghitung harga kopi.
     *
     * @param tambahWhippedCream adalah jika pelanggan ingin menambah topping whipped cream.
     * @param tambahCokelat adalah jika pelanggan ingin menambah topping cokelat.
     * @return harga kopi setelah dihitung.
     * */
    private int hitungHarga(boolean tambahWhippedCream, boolean tambahCokelat){
        //Harga secangkir kopi
        int hargaDasar = 5;

        //Tambah 1 jika pelanggan ingin whipped cream
        if(tambahWhippedCream)
            hargaDasar += 1;
        //Tambah 2 jika pelanggan ingin cokelat
        if(tambahCokelat)
            hargaDasar +=2 ;

        return jumlah*hargaDasar;
    }

    /**
     * Method ini menampilkan nilai jumlah ke layar.
     * */
    private void tampilkan(int angka) {
        TextView jumlahTextView = (TextView) findViewById(
                R.id.jumlah_text_view);
        jumlahTextView.setText("" + angka);
    }
}
