package com.bluetooth.bluetoothintermec;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    Context _context;

    byte FONT_TYPE;
    private static BluetoothSocket btsocket;
    private static OutputStream btoutputstream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _context = MainActivity.this;
        setContentView(getView());
    }

    protected void connect() {
        if(btsocket == null){
            Intent BTIntent = new Intent(getApplicationContext(), BTDeviceClass.class);
            this.startActivityForResult(BTIntent, BTDeviceClass.REQUEST_CONNECT_BT);
        }
        else{

            OutputStream opstream = null;
            try {
                opstream = btsocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            btoutputstream = opstream;
            print_bt();

        }

    }
    private void print_bt() {
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            btoutputstream = btsocket.getOutputStream();

            byte[] printformat = { 0x1B, 0x21, FONT_TYPE };
            btoutputstream.write(printformat);
            String msg = "";
            btoutputstream.write(msg.getBytes());
            btoutputstream.write(0x0D);
            btoutputstream.write(0x0D);
            btoutputstream.write(0x0D);
            btoutputstream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public View getView() {
        LinearLayout lyt = new LinearLayout(_context);

        LinearLayout.LayoutParams lytParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lyt.setLayoutParams(lytParams);
        lyt.setOrientation(LinearLayout.VERTICAL);

        TextView txtMAC = new TextView(_context);
        txtMAC.setText("MAC Address : 11:11:11:11:11");
        txtMAC.setGravity(Gravity.RIGHT | Gravity.TOP | Gravity.END);
        txtMAC.setPadding(0, 15, 20, 0);
        txtMAC.setTextSize(15.0f);
        lyt.addView(txtMAC);


        LinearLayout.LayoutParams lytParamsButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lytParamsButton.gravity = Gravity.CENTER_HORIZONTAL;
        lytParams.setMargins(0, 35, 0, 0);

        Button btnConnect = new Button(_context);
        btnConnect.setLayoutParams(lytParamsButton);
        btnConnect.setText("Bağlan");
        btnConnect.setGravity(Gravity.CENTER_HORIZONTAL);
        btnConnect.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        lyt.addView(btnConnect);

        Button btnPrint = new Button(_context);
        btnPrint.setLayoutParams(lytParamsButton);
        btnPrint.setText("Yazdir");
        btnPrint.setGravity(Gravity.CENTER_HORIZONTAL);
        btnPrint.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        lyt.addView(btnPrint);

        return lyt;

    }

    public class Fatura {
        private String Tarih;
        private String SiparisNo;
        private String AlisSaati;
        private String VarisSaati;
        private String AyrilisSaati;
        private String AlisKM;
        private String VarisKM;
        private String BaglantiNesnesi;
        private String TuketimNoktasi;
        private String SayacNo;
        private String Adres;
        private String Cozum;
        private String IhbarNotu;

        public String getTarih() {
            return Tarih;
        }

        public void setTarih(String tarih) {
            Tarih = tarih;
        }

        public String getSiparisNo() {
            return SiparisNo;
        }

        public void setSiparisNo(String siparisNo) {
            SiparisNo = siparisNo;
        }

        public String getAlisSaati() {
            return AlisSaati;
        }

        public void setAlisSaati(String alisSaati) {
            AlisSaati = alisSaati;
        }

        public String getVarisSaati() {
            return VarisSaati;
        }

        public void setVarisSaati(String varisSaati) {
            VarisSaati = varisSaati;
        }

        public String getAyrilisSaati() {
            return AyrilisSaati;
        }

        public void setAyrilisSaati(String ayrilisSaati) {
            AyrilisSaati = ayrilisSaati;
        }

        public String getAlisKM() {
            return AlisKM;
        }

        public void setAlisKM(String alisKM) {
            AlisKM = alisKM;
        }

        public String getVarisKM() {
            return VarisKM;
        }

        public void setVarisKM(String varisKM) {
            VarisKM = varisKM;
        }

        public String getBaglantiNesnesi() {
            return BaglantiNesnesi;
        }

        public void setBaglantiNesnesi(String baglantiNesnesi) {
            BaglantiNesnesi = baglantiNesnesi;
        }

        public String getTuketimNoktasi() {
            return TuketimNoktasi;
        }

        public void setTuketimNoktasi(String tuketimNoktasi) {
            TuketimNoktasi = tuketimNoktasi;
        }

        public String getSayacNo() {
            return SayacNo;
        }

        public void setSayacNo(String sayacNo) {
            SayacNo = sayacNo;
        }

        public String getAdres() {
            return Adres;
        }

        public void setAdres(String adres) {
            Adres = adres;
        }

        public String getCozum() {
            return Cozum;
        }

        public void setCozum(String cozum) {
            Cozum = cozum;
        }

        public String getIhbarNotu() {
            return IhbarNotu;
        }

        public void setIhbarNotu(String ihbarNotu) {
            IhbarNotu = ihbarNotu;
        }
    }

}
