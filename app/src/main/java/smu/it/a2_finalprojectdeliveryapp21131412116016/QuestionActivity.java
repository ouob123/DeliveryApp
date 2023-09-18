package smu.it.a2_finalprojectdeliveryapp21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class QuestionActivity extends AppCompatActivity {
    // 전역 변수 선언
    ImageButton backButton, homeButton;
    Button ok;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // 뒤로가기 버튼
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 홈(메인화면) 버튼
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 이름 객체 생성
        name = findViewById(R.id.editTextName);

        // 문의하기 버튼
        ok = findViewById(R.id.okButton);
        // '문의하기' 버튼 클릭 시 다이얼로그 창 띄움
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(QuestionActivity.this);
                dialogBuilder.setTitle("1:1 문의"); // 다이얼로그 제목
                dialogBuilder.setMessage(name.getText().toString()+" 님\n문의가 접수되었습니다"); // 내용
                dialogBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent confirm = new Intent(QuestionActivity.this, CategoryActivity.class);
                        startActivity(confirm);
                        finish();
                    }
                }); dialogBuilder.show();
            }
        });
    }
}