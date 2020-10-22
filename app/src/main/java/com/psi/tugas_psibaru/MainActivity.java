package com.psi.tugas_psibaru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab_add, fab_logout;
    private ListView list_view;
    private ListViewAdapter adapter;
    private ArrayList<dataPengguna> listPengguna = new ArrayList<>();
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_add = findViewById(R.id.fab_add);
        fab_logout = findViewById(R.id.fab_logout);
        list_view = findViewById(R.id.list_view);
        db = new Database(this);

        Boolean checkSession = db.checkSession("kosong");
        if(checkSession == true){
            Boolean updtSession = db.upgradeSession("ada", 1);
            Intent loginIntent = new Intent(MainActivity.this, Login.class);
            startActivity(loginIntent);
            finish();
        }
        //logout
        fab_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                Toast.makeText(getApplicationContext(), "berhasil keluar", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        });
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MasterPenggunaActivity.class));
            }
        });
        menampilkanData();
    }
    private void menampilkanData(){
        listPengguna.clear();
        Cursor res = db.getDataAll();
        while (res.moveToNext()){
            String id = res.getString(0);
            String nama = res.getString(1);
            String alamat = res.getString(2);
            String tglLahir = res.getString(3);

            listPengguna.add(new dataPengguna(id, nama, alamat, tglLahir));

        }
        adapter =new ListViewAdapter(listPengguna, MainActivity.this);
        list_view.setAdapter(adapter);
    }
}