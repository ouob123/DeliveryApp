package smu.it.a2_finalprojectdeliveryapp21131412116016;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    // 전역 변수 선언
    private ViewPager2 adViewPager;
    private FragmentStateAdapter pagerAdapter;
    private int page_num = 5; // 광고 페이지 5개
    private CircleIndicator3 myIndicator;
    GridView gridView;
    ImageButton categoryButton, cartButton;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 가로 슬라이드 뷰 Fragment
        // ViewPager2 객체 생성
        adViewPager = findViewById(R.id.adViewPager);
        // Adapter 생성, 적용
        pagerAdapter = new AdvertiseAdapter(this, page_num);
        adViewPager.setAdapter(pagerAdapter);
        // Indicator
        myIndicator = findViewById(R.id.indicator);
        myIndicator.setViewPager(adViewPager);
        myIndicator.createIndicators(page_num,0);
        // ViewPager 세팅
        adViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // 처음 시작하는 이미지 설정
        // 좌우로 슬라이딩 할 수 있도록 함. 무한대로.
        // 어댑터에서 이미지를 2000장 생성하였으므로 시작 지점을 1000으로
        adViewPager.setCurrentItem(1000); // 시작 지점
        adViewPager.setOffscreenPageLimit(5); // 최대 이미지 수

        // 오픈소스 사용
        adViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    adViewPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                myIndicator.animatePageSelected(position%page_num);
            }
        });

        // gridView로 배달음식 카테고리 배치
        gridView = findViewById(R.id.gridViewFood);
        //현재 돌고 있는 객체를 MyGridView에 Context로 정의
        FoodGridView foodGridView = new FoodGridView(this);
        gridView.setAdapter(foodGridView);

        // 카테고리 버튼
        categoryButton = findViewById(R.id.categoryButton);
        // 카테고리 뷰를 띄움
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 생성 후, 해당 액티비티로 이동
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        // 장바구니 버튼
        cartButton = findViewById(R.id.cartButton);
        // 장바구니 페이지로 이동
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class); // CartActivity로 변경할 것
                startActivity(intent);
            }
        });

    }
}