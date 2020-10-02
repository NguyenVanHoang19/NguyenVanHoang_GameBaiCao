package com.example.nguyenvanhoang_gamebaicao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
///
public class MainActivity extends AppCompatActivity {
    private Button btnChoi,btnTinhDiem,btnChoi2May;
    private ImageView imageViewBaiNguoiChoi1,imageViewBaiNguoiChoi2,imageViewBaiNguoiChoi3;
    private ImageView imageViewBaiMay1,imageViewBaiMay2,imageViewBaiMay3;
    private TextView textViewDiemNguoiChoi,textViewDiemMay,textViewDiemTong,textViewSoVan,textViewBaiMay,textViewDiemTong_Nguoi,textViewBaiNguoiChoi;
    private List<Bai> listTatCaBai = new ArrayList<Bai>();
    private int tongDiemNguoiChoi = 0;
    private int tongDiemMay = 0;
    private int soVan =0;
    private Button btnKetThuc;
    private LinearLayout layoutMain,layoutThongBaoDiem,layoutBaiNguoiChoi,layoutBaiMay;
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
    private int mangThuTuBai[] = {
            1,5,9,13,17,21,25,29,33,37,41,45,49,2,6,10,14,18,22,26,30,34,38,42,46,50,3,7,11,15,19,23,27,
            31,35,39,43,47,51,4,8,12,16,20,24,28,32,36,40,44,48,52
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
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        layoutThongBaoDiem = (LinearLayout) findViewById(R.id.layoutThongBaoDiem);
        layoutBaiNguoiChoi = (LinearLayout) findViewById(R.id.layoutBaiNguoiChoi);
        layoutBaiMay = (LinearLayout) findViewById(R.id.layoutBaiMay);

        btnChoi = (Button) findViewById(R.id.btnChoi);
        imageViewBaiMay1 = (ImageView) findViewById(R.id.imageViewBaiMay1);
        imageViewBaiMay2 = (ImageView) findViewById(R.id.imageViewBaiMay2);
        imageViewBaiMay3 = (ImageView) findViewById(R.id.imageViewBaiMay3);
        imageViewBaiNguoiChoi1 = (ImageView) findViewById(R.id.imageViewBaiNguoiChoi1);
        imageViewBaiNguoiChoi2 = (ImageView) findViewById(R.id.imageViewBaiNguoiChoi2);
        imageViewBaiNguoiChoi3 = (ImageView) findViewById(R.id.imageViewBaiNguoiChoi3);
        textViewDiemNguoiChoi = (TextView) findViewById(R.id.textViewDiemNguoiChoi);
        textViewDiemMay = (TextView) findViewById(R.id.textViewDiemMay);
        textViewDiemTong = (TextView) findViewById(R.id.textViewDiemTong);
        textViewSoVan = (TextView) findViewById(R.id.textViewSoVan);
        textViewBaiMay = (TextView) findViewById(R.id.textViewBaiMay);
        textViewDiemTong_Nguoi = (TextView) findViewById(R.id.textViewDiemTong);
        textViewBaiNguoiChoi = (TextView) findViewById(R.id.textViewBaiNguoiChoi);
        btnKetThuc =  (Button) findViewById(R.id.btnKetThuc);
        btnTinhDiem =(Button) findViewById(R.id.btnTinhDiem);
        btnChoi2May =(Button) findViewById(R.id.btnChoi2May);

        int RED = 0xffFF0000;
        int BLUE = 0xffffff;
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(textViewDiemTong,"textColor",BLUE,RED);
        valueAnimator.setDuration(100);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
        getSupportActionBar().hide();
        setDuLieuBai();
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChoi.setEnabled(false);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       for(int i=0 ;i < 20;i++){
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
            Bai bai = null;
            if(i<=13){
                if (i < 10){
                    bai = new Bai(i,i);
                }
                else if(i >= 10){
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiBich[i-1]);
                bai.setTenBai(mangTenBaiBich[i-1]);

            }
            else if(i>=14 && i<=26){
                if ((i - 14) < 10){
                    bai = new Bai(i,i-13);
                }
                else if((i-14) >= 10){
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiChuon[i-14]);
                bai.setTenBai(mangTenBaiChuon[i-14]);
            }
            else if(i>=27 && i<=39){
                if ((i - 27) < 10){
                    bai = new Bai(i,i-26);
                }
                else if((i -27) >= 10){
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiRo[i-27]);
                bai.setTenBai(mangTenBaiRo[i-27]);
            }
            else if(i>=40 && i<=52){
                if ((i - 40) < 10){
                    bai = new Bai(i,i-39);
                }
                else if((i -40) >= 10){
                    bai = new Bai(i,10);
                }
                bai.setHinh(mangHinhBaiCo[i-40]);
                bai.setTenBai(mangTenBaiCo[i-40]);
            }
            ///
            bai.setThuTuBai(mangThuTuBai[i-1]);
            listTatCaBai.add(bai);
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
        final Bai baiNguoiChoi1 = getBaiById(soRanDom1);
        final Bai baiNguoiChoi2 = getBaiById(soRanDom2);
        final Bai baiNguoiChoi3 = getBaiById(soRanDom3);

        final Bai baiMay1 = getBaiById(soRanDom4);
        final Bai baiMay2 = getBaiById(soRanDom5);
        final Bai baiMay3 = getBaiById(soRanDom6);
        final boolean[] checkMoBai = {false,false,false};

////
        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                btnChoi.setEnabled(false);
                imageViewBaiNguoiChoi1.setEnabled(true);
                imageViewBaiNguoiChoi2.setEnabled(true);
                imageViewBaiNguoiChoi3.setEnabled(true);
                textViewDiemMay.setText("Máy: điểm");
                textViewDiemNguoiChoi.setText("Bạn: điểm");
                imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
                imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
                imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
                imageViewBaiNguoiChoi1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkMoBai[0] = true;
                        imageViewBaiNguoiChoi1.setEnabled(false);
                        imageViewBaiNguoiChoi1.setImageResource(baiNguoiChoi1.getHinh());
                        if(checkMoBai[0]== true && checkMoBai[1] ==  true && checkMoBai[2] == true){
                            xuLy(baiMay1,baiMay2,baiMay3,baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
                            btnChoi.setEnabled(true);
                        }

                    }
                });
                imageViewBaiNguoiChoi2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkMoBai[1] = true;
                        imageViewBaiNguoiChoi2.setEnabled(false);
                        imageViewBaiNguoiChoi2.setImageResource(baiNguoiChoi2.getHinh());
                        if(checkMoBai[0]== true && checkMoBai[1] ==  true && checkMoBai[2] == true){
                            xuLy(baiMay1,baiMay2,baiMay3,baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
                            btnChoi.setEnabled(true);
                        }
                    }
                });
                imageViewBaiNguoiChoi3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkMoBai[2] = true;
                        imageViewBaiNguoiChoi3.setEnabled(false);
                        imageViewBaiNguoiChoi3.setImageResource(baiNguoiChoi3.getHinh());
                        if(checkMoBai[0]== true && checkMoBai[1] ==  true && checkMoBai[2] == true){
                            xuLy(baiMay1,baiMay2,baiMay3,baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
                            btnChoi.setEnabled(true);
                        }
                    }
                });


                imageViewBaiMay1.setImageResource(baiMay1.getHinh());
                imageViewBaiMay2.setImageResource(baiMay2.getHinh());
                imageViewBaiMay3.setImageResource(baiMay3.getHinh());

                soVan ++;
                textViewSoVan.setText("Số ván: " +soVan);
                //////


            }
        });

    }
    public void xuLy(Bai baiMay1,Bai baiMay2,Bai baiMay3,Bai baiNguoiChoi1,Bai baiNguoiChoi2,Bai baiNguoiChoi3){
        int baLaTrungNguoiChoi = kiemTraBaLaTrung(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
        int baLaTrungMay = kiemTraBaLaTrung(baiMay1,baiMay2,baiMay3);
        int ktraBaTayMay  = kiemTraBaTay(baiMay1,baiMay2,baiMay3);
        int ktraBaTayNguoi = kiemTraBaTay(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);

        if(baLaTrungNguoiChoi != -1){
            textViewDiemNguoiChoi.setText("Ba lá trùng");
            if(baLaTrungMay != -1 ){
                textViewDiemMay.setText("Ba lá trùng");
                if(baLaTrungNguoiChoi > baLaTrungMay){
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    tongDiemMay += 1;
                    Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else{
                if(ktraBaTayMay != -1){
                    textViewDiemMay.setText("Ba Tây");
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    textViewDiemMay.setText("Máy: "+diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem())+" điểm");
                    tongDiemNguoiChoi +=1 ;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
        }
        else if(baLaTrungMay != -1){
            textViewDiemMay.setText("Ba lá trùng");
            if(baLaTrungNguoiChoi != -1 ){
                textViewDiemNguoiChoi.setText("Ba lá trùng");
                if(baLaTrungNguoiChoi > baLaTrungMay){
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    tongDiemMay += 1;
                    Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else{
                if(ktraBaTayNguoi != -1){
                    textViewDiemNguoiChoi.setText("Ba Tây");
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    textViewDiemNguoiChoi.setText("Bạn: "+diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem())+" điểm");
                    tongDiemMay +=1 ;
                    Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
        }
        else{
            if(ktraBaTayNguoi != -1 ){
                textViewDiemNguoiChoi.setText("Ba tây");
                if(ktraBaTayMay != -1){
                    textViewDiemMay.setText("Ba tây");
                    if(ktraBaTayNguoi >  ktraBaTayMay){
                        tongDiemNguoiChoi += 1;
                        Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                    else{
                        tongDiemMay +=1 ;
                        Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                }
                else{
                    textViewDiemMay.setText("Máy: "+diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem())+" điểm");
                    tongDiemNguoiChoi +=1;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else if(ktraBaTayMay != -1 ){
                textViewDiemMay.setText("Ba tây");
                if(ktraBaTayNguoi != -1){
                    textViewDiemNguoiChoi.setText("Ba tây");
                    if(ktraBaTayNguoi >  ktraBaTayMay){
                        tongDiemNguoiChoi += 1;
                        Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                    else{
                        tongDiemMay +=1 ;
                        Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                }
                else{
                    textViewDiemNguoiChoi.setText("Bạn: "+diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem())+" điểm");
                    tongDiemMay +=1;
                    Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else{
                int soDiemNguoiChoi = diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem());
                int soDiemMay = diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem());
                textViewDiemMay.setText("Máy: "+soDiemMay + " điểm");
                textViewDiemNguoiChoi.setText("Bạn: "+soDiemNguoiChoi + " điểm");

                if(soDiemNguoiChoi > soDiemMay){
                    tongDiemNguoiChoi += 1 ;
                    Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else if(soDiemMay > soDiemNguoiChoi){
                    tongDiemMay += 1;
                    Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                ////////////////
                else{
                    int laBaiCaoNhatNguoiChoi =  getLaBaiCaoNhat(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
                    int laBaiCaoNhatMay = getLaBaiCaoNhat(baiMay1,baiMay2,baiMay3);
                    if(laBaiCaoNhatNguoiChoi > laBaiCaoNhatMay){
                        tongDiemNguoiChoi += 1;
                        Snackbar.make(layoutMain, "Người chơi thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                    else{
                        tongDiemMay += 1;
                        Snackbar.make(layoutMain, "Máy thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                }
            }
        }
        textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay +"\n \t \t \t Click để mở bài");


        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewDiemTong.animate().rotation(360f).y(20f).setDuration(2000);
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Kết Quả");
                if(tongDiemNguoiChoi > tongDiemMay){
                    alertDialog.setMessage("Người chơi thắng: \n Người chơi: "+tongDiemNguoiChoi+" Điểm ---"+" Thắng <3 <3 <3"+" \n" +" Máy: "+tongDiemMay+" Điểm ---"+" Thua :(");
                }
                else if(tongDiemMay > tongDiemNguoiChoi){
                    alertDialog.setMessage("Máy thắng: \n Người chơi: "+tongDiemNguoiChoi+" Điểm ---"+" Thua :("+" \n" +" Máy: "+tongDiemMay+" Điểm ---"+" Thắng <3 <3 <3");
                }
                else{
                    alertDialog.setMessage("Hòa nhau \n Người chơi: "+tongDiemNguoiChoi+" Điểm ---"+""+" \n" +" Máy: "+tongDiemMay+" Điểm ---"+"");
                }


                alertDialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tongDiemMay = 0 ;
                        tongDiemNguoiChoi = 0;
                        soVan = 0;
                        textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay + "\n \t \t \t Click để mở bài");
                        textViewDiemNguoiChoi.setText("Bạn: ");
                        textViewDiemMay.setText("Máy: ");
                        imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
                        imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
                        imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
                        imageViewBaiMay1.setImageResource(R.drawable.hinhbaiup);
                        imageViewBaiMay2.setImageResource(R.drawable.hinhbaiup);
                        imageViewBaiMay3.setImageResource(R.drawable.hinhbaiup);
                        AlertDialog dialog =alertDialog.create();
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog =alertDialog.create();
                dialog.show();
            }
        });
        if(soVan == 20){
            textViewDiemTong.animate().rotation(360f).y(20f).setDuration(2000);
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Kết Quả");
            if(tongDiemNguoiChoi > tongDiemMay){
                alertDialog.setMessage("Người chơi thắng: \n Người chơi: "+tongDiemNguoiChoi+" Thắng <3 <3 <3"+" \n" +" Máy: "+tongDiemMay+" Thua :(");
            }
            else if(tongDiemMay > tongDiemNguoiChoi){
                alertDialog.setMessage("Máy thắng: \n Người chơi: "+tongDiemNguoiChoi+" Thua :("+" \n" +" Máy: "+tongDiemMay+" Thắng <3 <3 <3");
            }
            else{
                alertDialog.setMessage("Hòa nhau \n Người chơi: "+tongDiemNguoiChoi+""+" \n" +" Máy: "+tongDiemMay+"");
            }
            alertDialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    tongDiemMay = 0 ;
                    tongDiemNguoiChoi = 0;
                    soVan = 0;
                    textViewDiemTong.setText("Người chơi: "+tongDiemNguoiChoi+" || Máy : "+tongDiemMay + "\n \t \t \t Click để mở bài");
                    textViewDiemNguoiChoi.setText("Bạn: ");
                    textViewDiemMay.setText("Máy: ");
                    imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiMay1.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiMay2.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiMay3.setImageResource(R.drawable.hinhbaiup);
                    AlertDialog dialog =alertDialog.create();
                    dialog.dismiss();
                }
            });
            AlertDialog dialog =alertDialog.create();
            dialog.show();
        }
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
    public int kiemTraBaTay(Bai bai1,Bai bai2,Bai bai3){
        if(bai1.getDiem() == 10 && bai2.getDiem() == 10 && bai3.getDiem()==10){
            if(!bai1.getTenBai().equals("muoi co") && !bai1.getTenBai().equals("muoi ro")
                && !bai1.getTenBai().equals("muoi chuon") && !bai1.getTenBai().equals("muoi bich")
                && !bai2.getTenBai().equals("muoi co") && !bai2.getTenBai().equals("muoi ro")
                && !bai2.getTenBai().equals("muoi chuon") && !bai2.getTenBai().equals("muoi bich")
                && !bai3.getTenBai().equals("muoi co") && !bai3.getTenBai().equals("muoi ro")
                && !bai3.getTenBai().equals("muoi chuon") && !bai3.getTenBai().equals("muoi bich")) {
                return getLaBaiCaoNhat(bai1,bai2,bai3);
            }
        }
        return -1;
    }
    public int getLaBaiCaoNhat(Bai bai1,Bai bai2,Bai bai3){
        int maxBai1_Bai2 = Math.max(bai1.getThuTuBai(),bai2.getThuTuBai());
        int laBaiMax = Math.max(maxBai1_Bai2,bai3.getThuTuBai());
        return  laBaiMax;
    }
    public int kiemTraBaLaTrung(Bai bai1,Bai bai2,Bai bai3){
        int idKtra =  bai1.getId() - bai2.getId() ;
        if(Math.abs(idKtra) ==  13 || Math.abs(idKtra) == 26 || Math.abs(idKtra) == 39){
            int idKtra2 = bai1.getId() - bai3.getId();
            if(Math.abs(idKtra2) ==  13 || Math.abs(idKtra2) == 26 || Math.abs(idKtra2) == 39){
                return getLaBaiCaoNhat(bai1,bai2,bai3);
            }
        }
        return -1 ;
    }
    public void showPopupMenu(View v){
       final PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
       getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
       popupMenu.show();
       popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case R.id.menuTinhDiem :{
                       duLieuLayoutTinhDiem();
                        return true;
                   }
                   case R.id.menuNguoiVoiMay :{
                       textViewDiemMay.setText("Điểm: ");
                       layoutBaiMay.setVisibility(View.VISIBLE);
                       btnChoi.setVisibility(View.VISIBLE);
                       btnTinhDiem.setVisibility(View.GONE);
                       textViewBaiMay.setVisibility(View.VISIBLE);
                       btnKetThuc.setVisibility(View.VISIBLE);
                       textViewDiemTong_Nguoi.setVisibility(View.VISIBLE);
                       imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiMay1.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiMay2.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiMay3.setImageResource(R.drawable.hinhbaiup);
                       btnChoi2May.setVisibility(View.GONE);
                       soVan = 0;
                       return true;
                   }
                   case R.id.menuMayVoiMay :{
                       btnChoi2May.setEnabled(true);
                       textViewDiemMay.setText("Điểm: ");
                       textViewDiemNguoiChoi.setText("Điểm: ");
                       layoutBaiMay.setVisibility(View.VISIBLE);
                       btnTinhDiem.setVisibility(View.GONE);
                       textViewBaiMay.setVisibility(View.VISIBLE);
                       textViewDiemTong_Nguoi.setVisibility(View.VISIBLE);
                       btnChoi2May.setVisibility(View.VISIBLE);
                       btnChoi.setVisibility(View.GONE);
                       textViewDiemTong.setText("Máy 1: 0 điểm || Máy 2: 0 điểmm");
                       btnKetThuc.setVisibility(View.GONE);
                       textViewBaiNguoiChoi.setText("Bài máy 1");
                       textViewBaiMay.setText("Bài Máy 2");
                       imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiMay1.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiMay2.setImageResource(R.drawable.hinhbaiup);
                       imageViewBaiMay3.setImageResource(R.drawable.hinhbaiup);
                       soVan = 0;
                       chucNangMayVoiMay();
                       return true;
                   }
                   case R.id.menuThoat :{
                       return true;
                   }
                   default:return false;
               }
           }
       });
    }
    public void duLieuLayoutTinhDiem(){
        btnChoi2May.setVisibility(View.GONE);
        layoutBaiMay.setVisibility(View.GONE);
        textViewDiemMay.setText("");
        btnChoi.setVisibility(View.GONE);
        btnTinhDiem.setVisibility(View.VISIBLE);
        textViewBaiMay.setVisibility(View.GONE);
        btnKetThuc.setVisibility(View.GONE);
        textViewDiemTong_Nguoi.setVisibility(View.GONE);
        imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
        imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
        imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
        textViewDiemNguoiChoi.setText("Điểm: ");
        soVan = 0;
        btnTinhDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chucNangTinhDiem();
                soVan ++;
                textViewSoVan.setText("Ván: "+soVan +"");
            }
        });
    }
    public void chucNangTinhDiem(){
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
        final Bai baiNguoiChoi1 = getBaiById(soRanDom1);
        final Bai baiNguoiChoi2 = getBaiById(soRanDom2);
        final Bai baiNguoiChoi3 = getBaiById(soRanDom3);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViewDiemNguoiChoi.setText("Bạn: điểm");
                imageViewBaiNguoiChoi1.setImageResource(baiNguoiChoi1.getHinh());
                imageViewBaiNguoiChoi2.setImageResource(baiNguoiChoi2.getHinh());
                imageViewBaiNguoiChoi3.setImageResource(baiNguoiChoi3.getHinh());
                int baLaTrungNguoiChoi = kiemTraBaLaTrung(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
                int ktraBaTayNguoi = kiemTraBaTay(baiNguoiChoi1,baiNguoiChoi2,baiNguoiChoi3);
                if(baLaTrungNguoiChoi != -1){
                    textViewDiemNguoiChoi.setText("Ba lá trùng");
                    Snackbar.make(layoutMain, "Ba lá trùng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else if(ktraBaTayNguoi != -1){
                    textViewDiemNguoiChoi.setText("Ba tây");
                    Snackbar.make(layoutMain, "Ba tây", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else{
                    textViewDiemNguoiChoi.setText("Điểm: " + diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem()));
                    Snackbar.make(layoutMain, diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem()) + " điểm", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    Snackbar.make(layoutMain, diem(baiNguoiChoi1.getDiem(),baiNguoiChoi2.getDiem(),baiNguoiChoi3.getDiem()) + " điểm", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
        });
    }

    public void chucNangMayVoiMay(){

        btnChoi2May.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tongDiemNguoiChoi = 0;
                tongDiemMay = 0;
                soVan =0;

                textViewDiemTong.setText("Máy 1: "+tongDiemNguoiChoi+" || Máy 2 : "+tongDiemMay );
                showInputDialog();
                btnChoi2May.setEnabled(false);
            }
        });

////

    }
    public void showInputDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View view = layoutInflater.inflate(R.layout.dialog_input_sovan,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final EditText edtSoVan = (EditText) view.findViewById(R.id.edtSoVan);

        ////

        ///
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int k) {
                if(!edtSoVan.getText().toString().equals("")){
                    final int soVanChon = Integer.parseInt(edtSoVan.getText().toString());
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for(int i =1 ;i<=soVanChon;i++){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // random bai
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
                                        final Bai baiMay1 = getBaiById(soRanDom1);
                                        final Bai baiMay2 = getBaiById(soRanDom2);
                                        final Bai baiMay3 = getBaiById(soRanDom3);

                                        final Bai baiMay4 = getBaiById(soRanDom4);
                                        final Bai baiMay5 = getBaiById(soRanDom5);
                                        final Bai baiMay6 = getBaiById(soRanDom6);
                                        ///
                                        imageViewBaiNguoiChoi1.setImageResource(baiMay4.getHinh());
                                        imageViewBaiNguoiChoi2.setImageResource(baiMay5.getHinh());
                                        imageViewBaiNguoiChoi3.setImageResource(baiMay6.getHinh());
                                        imageViewBaiMay1.setImageResource(baiMay1.getHinh());
                                        imageViewBaiMay2.setImageResource(baiMay2.getHinh());
                                        imageViewBaiMay3.setImageResource(baiMay3.getHinh());
                                        xuLyMayVoiMay(baiMay1,baiMay2,baiMay3,baiMay4,baiMay5,baiMay6,soVanChon);

                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    btnChoi2May.setEnabled(true);
                                }
                            });
                        }
                    }).start();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Phải nhập số ván",Toast.LENGTH_SHORT).show();

                }

            }
        }).setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void xuLyMayVoiMay(Bai baiMay1,Bai baiMay2,Bai baiMay3,Bai baiMay4,Bai baiMay5,Bai baiMay6,int soVanChon){
        int baLaTrungNguoiChoi = kiemTraBaLaTrung(baiMay4,baiMay5,baiMay6);
        int baLaTrungMay = kiemTraBaLaTrung(baiMay1,baiMay2,baiMay3);
        int ktraBaTayMay  = kiemTraBaTay(baiMay1,baiMay2,baiMay3);
        int ktraBaTayNguoi = kiemTraBaTay(baiMay4,baiMay5,baiMay6);

        if(baLaTrungNguoiChoi != -1){
            textViewDiemNguoiChoi.setText("Ba lá trùng");
            if(baLaTrungMay != -1 ){
                textViewDiemMay.setText("Ba lá trùng");
                if(baLaTrungNguoiChoi > baLaTrungMay){
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    tongDiemMay += 1;
                    Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else{
                if(ktraBaTayMay != -1){
                    textViewDiemMay.setText("Ba Tây");
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    textViewDiemMay.setText("Máy: "+diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem())+" điểm");
                    tongDiemNguoiChoi +=1 ;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
        }
        else if(baLaTrungMay != -1){
            textViewDiemMay.setText("Ba lá trùng");
            if(baLaTrungNguoiChoi != -1 ){
                textViewDiemNguoiChoi.setText("Ba lá trùng");
                if(baLaTrungNguoiChoi > baLaTrungMay){
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    tongDiemMay += 1;
                    Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else{
                if(ktraBaTayNguoi != -1){
                    textViewDiemNguoiChoi.setText("Ba Tây");
                    tongDiemNguoiChoi += 1;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else {
                    textViewDiemNguoiChoi.setText("Bạn: "+diem(baiMay4.getDiem(),baiMay5.getDiem(),baiMay6.getDiem())+" điểm");
                    tongDiemMay +=1 ;
                    Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
        }
        else{
            if(ktraBaTayNguoi != -1 ){
                textViewDiemNguoiChoi.setText("Ba tây");
                if(ktraBaTayMay != -1){
                    textViewDiemMay.setText("Ba tây");
                    if(ktraBaTayNguoi >  ktraBaTayMay){
                        tongDiemNguoiChoi += 1;
                        Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                    else{
                        tongDiemMay +=1 ;
                        Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                }
                else{
                    textViewDiemMay.setText("Máy: "+diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem())+" điểm");
                    tongDiemNguoiChoi +=1;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else if(ktraBaTayMay != -1 ){
                textViewDiemMay.setText("Ba tây");
                if(ktraBaTayNguoi != -1){
                    textViewDiemNguoiChoi.setText("Ba tây");
                    if(ktraBaTayNguoi >  ktraBaTayMay){
                        tongDiemNguoiChoi += 1;
                        Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                    else{
                        tongDiemMay +=1 ;
                        Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                }
                else{
                    textViewDiemNguoiChoi.setText("Bạn: "+diem(baiMay4.getDiem(),baiMay5.getDiem(),baiMay6.getDiem())+" điểm");
                    tongDiemMay +=1;
                    Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
            }
            else{
                int soDiemNguoiChoi = diem(baiMay4.getDiem(),baiMay5.getDiem(),baiMay6.getDiem());
                int soDiemMay = diem(baiMay1.getDiem(),baiMay2.getDiem(),baiMay3.getDiem());
                textViewDiemMay.setText("Máy: "+soDiemMay + " điểm");
                textViewDiemNguoiChoi.setText("Bạn: "+soDiemNguoiChoi + " điểm");

                if(soDiemNguoiChoi > soDiemMay){
                    tongDiemNguoiChoi += 1 ;
                    Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                else if(soDiemMay > soDiemNguoiChoi){
                    tongDiemMay += 1;
                    Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                }
                ////////////////
                else{
                    int laBaiCaoNhatNguoiChoi =  getLaBaiCaoNhat(baiMay4,baiMay5,baiMay6);
                    int laBaiCaoNhatMay = getLaBaiCaoNhat(baiMay1,baiMay2,baiMay3);
                    if(laBaiCaoNhatNguoiChoi > laBaiCaoNhatMay){
                        tongDiemNguoiChoi += 1;
                        Snackbar.make(layoutMain, "Máy 1 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                    else{
                        tongDiemMay += 1;
                        Snackbar.make(layoutMain, "Máy 2 thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                    }
                }
            }
        }
        textViewDiemTong.setText("Máy 1: "+tongDiemNguoiChoi+" || Máy 2 : "+tongDiemMay );
        soVan ++ ;
        textViewSoVan.setText("Ván: " +soVan);
        if(soVan == soVanChon){
            textViewDiemTong.animate().rotation(360f).y(20f).setDuration(2000);
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Kết Quả");
            if(tongDiemNguoiChoi > tongDiemMay){
                alertDialog.setMessage("Máy 1 thắng: \n Máy 1: "+tongDiemNguoiChoi+ " Điểm ---"+" Thắng <3 <3 <3"+" \n" +" Máy 2: "+tongDiemMay+" Điểm ---"+" Thua :(");
            }
            else if(tongDiemMay > tongDiemNguoiChoi){
                alertDialog.setMessage("Máy 2 thắng: \n Máy 1: "+tongDiemNguoiChoi+ " Điểm ---"+" Thua :("+" \n" +" Máy 2: "+tongDiemMay+" Điểm ---"+" Thắng <3 <3 <3");
            }
            else{
                alertDialog.setMessage("Hòa nhau \n Máy 1: "+tongDiemNguoiChoi+" Điểm ---"+" \n" +" Máy 2: "+tongDiemMay+" Điểm ---"+"");
            }
            alertDialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    tongDiemMay = 0 ;
                    tongDiemNguoiChoi = 0;
                    soVan = 0;
                    textViewDiemTong.setText("Máy 1: "+tongDiemNguoiChoi+" || Máy 2 : "+tongDiemMay + "");
                    textViewDiemNguoiChoi.setText("Máy 1: ");
                    textViewDiemMay.setText("Máy 2: ");
                    imageViewBaiNguoiChoi1.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiNguoiChoi2.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiNguoiChoi3.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiMay1.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiMay2.setImageResource(R.drawable.hinhbaiup);
                    imageViewBaiMay3.setImageResource(R.drawable.hinhbaiup);
                    AlertDialog dialog =alertDialog.create();
                    dialog.dismiss();
                }
            });
            AlertDialog dialog =alertDialog.create();
            dialog.show();
        }
    }
}