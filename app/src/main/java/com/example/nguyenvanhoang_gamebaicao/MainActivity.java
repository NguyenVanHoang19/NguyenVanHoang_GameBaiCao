package com.example.nguyenvanhoang_gamebaicao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
///
public class MainActivity extends AppCompatActivity {
    private ImageView btnChoi;
    private ImageView imageViewBaiNguoiChoi1,imageViewBaiNguoiChoi2,imageViewBaiNguoiChoi3;
    private ImageView imageViewBaiMay1,imageViewBaiMay2,imageViewBaiMay3;
    private TextView textViewDiemNguoiChoi,textViewDiemMay,textViewDiemTong;
    private List<Bai> listTatCaBai = new ArrayList<Bai>();
    private int tongDiemNguoiChoi = 0;
    private int tongDiemMay = 0;
    private int soVan =0;
    private String mangTenBaiCo[] = {
            "ach co","hai co","ba co","bon co","nam co",
            "sau co","bay co","tam co","chin co","muoi co",
            "boi co","dam co","gia co"
    };
    private String mangTenBaiRo[] = {
        "ach ro","hai ro","ba ro","bon ro","nam ro",
                "sau ro","bay ro","tam ro","chin ro","muoi ro",
                "boi ro","dam ro","gia ro"
    };
    private String mangTenBaiChuon[] = {
            "ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
            "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
            "boi chuon","dam chuon","gia chuon"
    };
    private String mangTenBaiBich[] = {
            "ach bich","hai bich","ba bich","bon bich","nam bich",
            "sau bich","bay bich","tam bich","chin bich","muoi bich",
            "boi bich","dam bich","gia bich"
    };
    private int mangTatCaHinh[] = {
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk
    };
    private int mangHinhBaiCo[] = {
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk
    };
    private int mangHinhBaiRo[] = {
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk
    };
    private int mangHinhBaiChuon[] = {
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck
    };
    private int mangHinhBaiBich[] = {
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChoi = (ImageView) findViewById(R.id.btnChoi);
        imageViewBaiMay1 = (ImageView) findViewById(R.id.imageViewBaiMay1);
        imageViewBaiMay2 = (ImageView) findViewById(R.id.imageViewBaiMay2);
        imageViewBaiMay3 = (ImageView) findViewById(R.id.imageViewBaiMay3);
        imageViewBaiNguoiChoi1 = (ImageView) findViewById(R.id.imageViewBaiNguoiChoi1);
        imageViewBaiNguoiChoi2 = (ImageView) findViewById(R.id.imageViewBaiNguoiChoi2);
        imageViewBaiNguoiChoi3 = (ImageView) findViewById(R.id.imageViewBaiNguoiChoi3);
        textViewDiemNguoiChoi = (TextView) findViewById(R.id.textViewDiemNguoiChoi);
        textViewDiemMay = (TextView) findViewById(R.id.textViewDiemMay);
        textViewDiemTong = (TextView) findViewById(R.id.textViewDiemTong);
        getSupportActionBar().hide();
        setDuLieuBai();
        for (Bai bai :listTatCaBai){
            System.out.println(bai.getId());
            System.out.println(bai.getTenBai());
            System.out.println(bai.getDiem());
        }
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       for(int i=0 ;i < mangTatCaHinh.length;i++){
                            try {
                                final int finalI = i;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageViewBaiMay1.setImageResource(mangTatCaHinh[finalI]);
                                        imageViewBaiMay2.setImageResource(mangTatCaHinh[finalI]);
                                        imageViewBaiMay3.setImageResource(mangTatCaHinh[finalI]);
                                        imageViewBaiNguoiChoi1.setImageResource(mangTatCaHinh[finalI]);
                                        imageViewBaiNguoiChoi2.setImageResource(mangTatCaHinh[finalI]);
                                        imageViewBaiNguoiChoi3.setImageResource(mangTatCaHinh[finalI]);
                                    }
                                });
                                Thread.sleep(50);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                       }
                        playChiaBai();
                    }
                }).start();

            }
        });
    }
    public void setDuLieuBai(){
        for (int i = 1;i<=52;i++ ){
            if(i<=13){
                Bai bai = null;
                if (i < 10){
                    bai = new Bai(i,i);
                }
                else if(i >= 10){
                    int diem = 10;
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiCo[i-1]);
                bai.setTenBai(mangTenBaiCo[i-1]);
                listTatCaBai.add(bai);
            }
            else if(i>=14 && i<=26){
                Bai bai = null;
                if ((i - 14) < 10){
                    bai = new Bai(i,i-13);
                }
                else if((i-14) >= 10){
                    int diem = 10;
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiRo[i-14]);
                bai.setTenBai(mangTenBaiRo[i-14]);
                listTatCaBai.add(bai);
            }
            else if(i>=27 && i<=39){
                Bai bai = null;
                if ((i - 27) < 10){
                    bai = new Bai(i,i-26);
                }
                else if((i -27) >= 10){
                    int diem = 10;
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiChuon[i-27]);
                bai.setTenBai(mangTenBaiChuon[i-27]);
                listTatCaBai.add(bai);
            }
            else if(i>=40 && i<=52){
                Bai bai = null;
                if ((i - 40) < 10){
                    bai = new Bai(i,i-39);
                }
                else if((i -40) >= 10){
                    int diem = 10;
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiBich[i-40]);
                bai.setTenBai(mangTenBaiBich[i-40]);
                listTatCaBai.add(bai);
            }
        }
    }
    public void playChiaBai(){
        Random random = new Random();
        int soRanDom1 =  random.nextInt(52) + 1;
        int soRanDom2 = random.nextInt(52) + 1;
        while (true){
            if(soRanDom1 != soRanDom2){
                break;
            }else {
              soRanDom2 =  random.nextInt(52) + 1;
            }
        }
        int soRanDom3 = random.nextInt(52) + 1;
        while (true){
            if((soRanDom1 != soRanDom2) && (soRanDom1!=soRanDom3) && (soRanDom2 != soRanDom3)){
                break;
            }else {
                soRanDom3 =  random.nextInt(52) + 1;
            }
        }
        int listSoRanDomCuaNguoiChoi [] = {soRanDom1,soRanDom2,soRanDom3};
        int soRanDom4 = random.nextInt(52) + 1;
        for(int i = 0 ; i< listSoRanDomCuaNguoiChoi.length ; i++){
            while (true){
                if(soRanDom4 != listSoRanDomCuaNguoiChoi[i]){
                    break;
                }else {
                    soRanDom4 = random.nextInt(52) + 1;
                }
            }
        }
        int soRanDom5 = random.nextInt(52) + 1;
        for(int i = 0 ; i< listSoRanDomCuaNguoiChoi.length ; i++){
            while (true){
                if((soRanDom5 != listSoRanDomCuaNguoiChoi[i]) && (soRanDom5!= soRanDom4)){
                    break;
                }else {
                    soRanDom5 = random.nextInt(52) + 1;
                }
            }
        }
        int soRanDom6 = random.nextInt(52) + 1;
        for(int i = 0 ; i< listSoRanDomCuaNguoiChoi.length ; i++){
            while (true){
                if((soRanDom6 != listSoRanDomCuaNguoiChoi[i]) && (soRanDom6 != soRanDom4) && (soRanDom6 != soRanDom5)){
                    break;
                }else {
                    soRanDom6 = random.nextInt(52) + 1;
                }
            }
        }
        System.out.println(soRanDom1);
        System.out.println(soRanDom2);
        System.out.println(soRanDom3);

        System.out.println(soRanDom4);
        System.out.println(soRanDom5);
        System.out.println(soRanDom6);
        final Bai baiNguoiChoi1 = getBaiById(soRanDom1);
        final Bai baiNguoiChoi2 = getBaiById(soRanDom2);
        final Bai baiNguoiChoi3 = getBaiById(soRanDom3);

        final Bai baiMay1 = getBaiById(soRanDom4);
        final Bai baiMay2 = getBaiById(soRanDom5);
        final Bai baiMay3 = getBaiById(soRanDom6);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageViewBaiNguoiChoi1.setImageResource(baiNguoiChoi1.getHinh());
                imageViewBaiNguoiChoi2.setImageResource(baiNguoiChoi2.getHinh());
                imageViewBaiNguoiChoi3.setImageResource(baiNguoiChoi3.getHinh());
                imageViewBaiMay1.setImageResource(baiMay1.getHinh());
                imageViewBaiMay2.setImageResource(baiMay2.getHinh());
                imageViewBaiMay3.setImageResource(baiMay3.getHinh());

                soVan ++;
                int diemNguoiChoi =0;
                diemNguoiChoi += diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem());
                int diemMay = 0;
                diemMay += diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem());

//                if(kiemTraBaTay(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3)){
//                    textViewDiemNguoiChoi.setText("Ba Tây");
//                }
//                else{
//                    textViewDiemNguoiChoi.setText("Bạn: "+diemNguoiChoi+"");
//                }
//                if (kiemTraBaTay(baiMay1,baiMay2,baiMay3)){
//                    textViewDiemMay.setText("Ba Tây");
//                }
//                else{
//                    textViewDiemMay.setText("Máy: "+diemMay+"");
//                }

                // may 3 tay
                if(kiemTraBaTay(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3)){
                    tongDiemNguoiChoi += 1;
                    textViewDiemNguoiChoi.setText("Ba Tây");
                    textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay);
                }else{

                    textViewDiemNguoiChoi.setText("Bạn: "+diemNguoiChoi+"");
                    if(diemNguoiChoi > diemMay){
                        tongDiemNguoiChoi += 1;
                        textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay);
                    }
                }

                if(kiemTraBaTay(baiMay1,baiMay2,baiMay3)){
                    tongDiemMay += 1;
                    textViewDiemMay.setText("Ba Tây");
                    textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay);
                }else{
                    textViewDiemMay.setText("Máy: "+diemMay+"");
                    if(diemNguoiChoi < diemMay){
                        tongDiemMay += 1;
                        textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay);
                    }
                }

                if(soVan == 20){
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Kết Quả");
                    alertDialog.setMessage("Tổng điểm: \n Người chơi: "+tongDiemNguoiChoi+" \n" +" Máy: "+tongDiemMay+"");
                    alertDialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tongDiemMay = 0 ;
                            tongDiemNguoiChoi = 0;
                            AlertDialog dialog =alertDialog.create();
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog =alertDialog.create();
                    dialog.show();
                }
//                if((diemNguoiChoi > diemMay) && !kiemTraBaTay(baiMay1,baiMay2,baiMay3)){
//                    tongDiemNguoiChoi += 1;
//                    textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay);
//                }
//                else if((diemNguoiChoi < diemMay) && !kiemTraBaTay(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3)){
//                    tongDiemMay += 1;
//                    textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay);
//                }
            }
        });

    }
    public Bai getBaiById(int id){
        Bai baiTimDuoc = null;
        for(Bai bai : listTatCaBai){
            if(bai.getId() == id){
                baiTimDuoc = bai;
            }
        }
        return baiTimDuoc;
    }
    public int diem(int diem1,int diem2,int diem3){
        int diem = 0 ;
        diem += (diem1+diem2+diem3) % 10;
        return diem;
    }
    public boolean kiemTraBaTay(Bai bai1,Bai bai2,Bai bai3){
        if(bai1.getDiem() == 10 && bai2.getDiem() == 10 && bai3.getDiem()==10){
            if(!bai1.getTenBai().equals("muoi co") && !bai1.getTenBai().equals("muoi ro")
                && !bai1.getTenBai().equals("muoi chuon") && !bai1.getTenBai().equals("muoi bich")
                && !bai2.getTenBai().equals("muoi co") && !bai2.getTenBai().equals("muoi ro")
                && !bai2.getTenBai().equals("muoi chuon") && !bai2.getTenBai().equals("muoi bich")
                && !bai3.getTenBai().equals("muoi co") && !bai3.getTenBai().equals("muoi ro")
                && !bai3.getTenBai().equals("muoi chuon") && !bai3.getTenBai().equals("muoi bich")) {
                return true;
            }
        }
        return false;
    }
}