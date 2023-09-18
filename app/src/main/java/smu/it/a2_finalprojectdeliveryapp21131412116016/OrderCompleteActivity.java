package smu.it.a2_finalprojectdeliveryapp21131412116016;

import static smu.it.a2_finalprojectdeliveryapp21131412116016.CartActivity.total_Price;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.addressText;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.phoneNumber;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.OrderActivity.plasticStatus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderCompleteActivity extends AppCompatActivity {
    // 전역 변수 선언
    Button    homeButton;
    TextView  address, request1, request2, phoneNum, price, payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        address = findViewById(R.id.addressText);
        request1 = findViewById(R.id.requestText1);
        request2 = findViewById(R.id.requestText2);
        phoneNum = findViewById(R.id.phoneNumText);
        price = findViewById(R.id.priceText);
        payment = findViewById(R.id.paymentText);

        // 넘겨줬던 주문정보값 받아오기
        Bundle extras = getIntent().getExtras();
        address.setText("주소 | "+addressText+" "+extras.getString("detailAddress"));
        request1.setText(plasticStatus);
        request2.setText(extras.getString("request"));
        phoneNum.setText("주문자 번호 | "+phoneNumber);
        price.setText("총 금액 | "+(3000+total_Price)+" 원");
        payment.setText("결제방법 | "+extras.getString("paymentMethod"));

        // 홈 버튼
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // 창 닫기
            }
        });
    }
}