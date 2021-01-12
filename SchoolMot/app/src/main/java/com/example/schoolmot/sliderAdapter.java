package com.example.schoolmot;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public sliderAdapter(Context context){
        this.context = context;

    }

    //Arrays
    public int[] slide_images = {
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo

    };

    public String[] slide_header = {
            "Registrasi Data semua siswa",
            "Pasangkan alat pada lengan siswa",
            "Penggantian Baterai"

    };

    public String[] slide_desc = {
           "1. Masukkan Nama dan Nomor Induk siswa serta id alat yang akan digunakan siswa pada menu registasi \n" +
                    "2. Lihat pada menu monitoring, apakah siswa tersebut sudah terdaftar dalam sistem Scheeko \n" +
                   "3. Apabila nama tersebut tidak tercamtum, periksa kembali jaringan gawai yang digunakan\n",
            "1. Alat adalah sebuah gelang yang pada umumnya dipasang pada tangan siswa \n" +
                    "2. Akan tetapi tidak menjadi masalah jika dipasang pada bagian tubuh yang lain asalkan tetap menempel" +
                    " pada bagian tubuh siswa",
            "1. Buka tutup alat bagian bawah untuk mengambil baterai yang ingin diganti \n" +
                    "2. baterai adalah baterai kotak dengan tegangan maksimal 9V \n"

    };

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_header);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_header[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);
    }
}
