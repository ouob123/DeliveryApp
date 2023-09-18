package smu.it.a2_finalprojectdeliveryapp21131412116016;

import static smu.it.a2_finalprojectdeliveryapp21131412116016.FoodGalleryAdapter.toastText;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecommendActivity extends AppCompatActivity {
    // 객체 선언
    ImageButton btn_back, btn_home;
    Gallery gallery;
    static ImageView imageViewFood; // static: 바꿀 수 없음

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        // 객체 생성
        btn_back= findViewById(R.id.backButton);
        btn_home = findViewById(R.id.homeButton);
        gallery = findViewById(R.id.galleryFood);
        imageViewFood = findViewById(R.id.recommendFood);

        // 갤러리에 들어갈 내용
        FoodGalleryAdapter galleryAdapter = new FoodGalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);

        // 뒤로 가기 버튼
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecommendActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 홈으로 돌아가기 버튼
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecommendActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}