package smu.it.a2_finalprojectdeliveryapp21131412116016;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.addressText;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.phoneNumber;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.userId;

import androidx.appcompat.app.AppCompatActivity;

public class MyPageActivity extends AppCompatActivity {
    // 전역 변수 선언
    TextView info, address;
    ImageButton backButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        info = findViewById(R.id.personal_info);
        address = findViewById(R.id.tvAddress);

        // 변수 값 가져오기
        info.setText(userId+" 님\n"+phoneNumber);
        address.setText(addressText);

        // 뒤로가기 버튼
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 홈(메인화면) 버튼
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}