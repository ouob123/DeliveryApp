package smu.it.a2_finalprojectdeliveryapp21131412116016;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    // 전역 변수 선언
    EditText editText_ID, editText_Address, editText_Tel;
    Button btn_start;

    static String addressText;
    static String phoneNumber;
    static String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 객체 생성
        editText_ID = findViewById(R.id.editTextID);
        editText_Address = findViewById(R.id.editTextAddress);
        editText_Tel = findViewById(R.id.editTextTel);
        btn_start = findViewById(R.id.buttonStart);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // static으로 선언된 전역변수에 값 넣기
                userId = editText_ID.getText().toString();
                addressText = editText_Address.getText().toString();
                phoneNumber = editText_Tel.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MyPageActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}

