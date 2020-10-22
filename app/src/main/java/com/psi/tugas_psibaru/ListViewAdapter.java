package com.psi.tugas_psibaru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<dataPengguna> listPengguna;
    private Context context;
    TextView tv_nama, tv_alamat, tv_tglLahir;

    public ListViewAdapter(List<dataPengguna> listPengguna, Context context) {
        this.listPengguna = listPengguna;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPengguna.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_pengguna, null);
        tv_nama = v.findViewById(R.id.tv_nama);
        tv_alamat = v.findViewById(R.id.tv_alamat);
        tv_tglLahir = v.findViewById(R.id.tv_tglLahir);

        tv_nama.setText(listPengguna.get(position).getNAMA());
        tv_alamat.setText(listPengguna.get(position).getALAMAT());
        tv_tglLahir.setText(listPengguna.get(position).getTGLlahir());
        return v;
    }
}
