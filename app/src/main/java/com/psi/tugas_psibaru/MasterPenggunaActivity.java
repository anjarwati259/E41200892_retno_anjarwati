package com.psi.tugas_psibaru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MasterPenggunaActivity extends AppCompatActivity {
private EditText et_nama, et_alamat, et_tglLahir;
private Database db;
private FloatingActionButton fab_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_pengguna);
        et_nama = findViewById(R.id.et_nama);
        et_alamat = findViewById(R.id.et_alamat);
        et_tglLahir =findViewById(R.id.et_tglLahir);
        fab_done = findViewById(R.id.fab_done);

        db = new Database(this);

        fab_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = et_nama.getText().toString();
                String alamat = et_alamat.getText().toString();
                String tglLahir = et_tglLahir.getText().toString();

                if(TextUtils.isEmpty(nama)){
                    et_nama.setError("Data Tidak Boleh Kosong");
                    et_nama.requestFocus();
                } else if(TextUtils.isEmpty(alamat)) {
                    et_alamat.setError("Data Tidak Boleh Kosong");
                    et_alamat.requestFocus();
                } else if(TextUtils.isEmpty(tglLahir)) {
                    et_tglLahir.setError("Data Tidak Boleh Kosong");
                    et_tglLahir.requestFocus();
                }else {
                    boolean isInsert = db.insertMasterPengguna(nama, alamat, tglLahir);
                    if(isInsert == true){
                        Toast.makeText(MasterPenggunaActivity.this, "Data Berhasil disimpan", Toast.LENGTH_SHORT).show();
                        kosong();
                        startActivity(new Intent(MasterPenggunaActivity.this, MainActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(MasterPenggunaActivity.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                        kosong();
                        startActivity(new Intent(MasterPenggunaActivity.this, MainActivity.class));
                        finish();
                    }
                }
            }
        });
    }
    private void kosong(){
        et_nama.setText(null);
        et_alamat.setText(null);
        et_tglLahir.setText(null);
    }
}