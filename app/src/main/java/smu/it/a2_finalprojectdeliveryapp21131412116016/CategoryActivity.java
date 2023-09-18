package smu.it.a2_finalprojectdeliveryapp21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CategoryActivity extends AppCompatActivity {
    // 변수 선언
    Button cancelButton;
    ImageButton cartButton, myPageButton, callingButton,
            noticeButton, inquiryButton, recommendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // 닫기 버튼
        cancelButton = findViewById(R.id.cancelButton);
        // 카테고리 화면 닫기
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); } // 현재 화면 닫기(종료)
        });

        // 장바구니 버튼
        cartButton = findViewById(R.id.cartButton);
        // 장바구니 페이지로 이동
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        // 마이페이지 버튼
        myPageButton = findViewById(R.id.mypageButton);
        // 마이페이지로 이동
        myPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });

        // 고객안심센터(전화) 버튼
        callingButton = findViewById(R.id.callButton);
        // 고객안심센터로 전화연결 (다이얼 화면 띄우기)
        callingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = "tel: 01049136799"; // 전화번호 지정
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
            }
        });

        // 공지사항 버튼
        noticeButton = findViewById(R.id.noticeButton);
        // 공지사항 페이지로 이동
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        // 1:1 문의 버튼
        inquiryButton = findViewById(R.id.inquiryButton);
        // 1:1 문의 페이지로 이동
        inquiryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });

        // 추천메뉴 버튼
        recommendButton = findViewById(R.id.recommendButton);
        // 추천메뉴 페이지로 이동
        recommendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });
    }
}
