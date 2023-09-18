package smu.it.a2_finalprojectdeliveryapp21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static smu.it.a2_finalprojectdeliveryapp21131412116016.CartActivity.total_Price;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.addressText;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.LoginActivity.phoneNumber;

public class OrderActivity extends AppCompatActivity {
    // 전역 변수 선언
    ImageButton backButton;
    Button okButton;
    TextView address_Text, phoneNumText, price, totalPrice;
    EditText detail_addressText, requestText;
    CheckBox plasticCheck;
    RadioButton payBtn1, payBtn2, payBtn3, payBtn4, payBtn5, payBtn6, payBtn7;

    static String plasticStatus;
    String payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // 뒤로가기 버튼
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, MainActivity.class); // 해당 Activity로 변경할 것
                startActivity(intent);
            }
        });

        // 주문정보를 받아오기 위한 객체 생성
        // 주소
        address_Text = findViewById(R.id.address);
        address_Text.setText(addressText); // 변수로 설정된 값 가져와서 넣기
        detail_addressText = findViewById(R.id.detailAddress);
        // 전화번호
        phoneNumText = findViewById(R.id.phoneNum);
        phoneNumText.setText(phoneNumber);
        // 금액
        price = findViewById(R.id.price);
        price.setText("주문금액 " + total_Price + " 원" + " + 배달팁 3000원");
        totalPrice = findViewById(R.id.totalPrice);
        totalPrice.setText((3000+total_Price)+" 원");
        // 결제방법
        payBtn1 = findViewById(R.id.payment1); // 배송페이
        payBtn2 = findViewById(R.id.payment2); // 네이버페이
        payBtn3 = findViewById(R.id.payment3); // 카카오페이
        payBtn4 = findViewById(R.id.payment4); // 카드결제
        payBtn5 = findViewById(R.id.payment5); // 휴대폰결제
        payBtn6 = findViewById(R.id.payment6); // 만나서 카드결제
        payBtn7 = findViewById(R.id.payment7); // 만나서 현금결제

        payBtn1.setOnClickListener(paymentMethod);
        payBtn2.setOnClickListener(paymentMethod);
        payBtn3.setOnClickListener(paymentMethod);
        payBtn4.setOnClickListener(paymentMethod);
        payBtn5.setOnClickListener(paymentMethod);
        payBtn6.setOnClickListener(paymentMethod);
        payBtn7.setOnClickListener(paymentMethod); // paymentMethod 따로 정의

        // 요청사항
        // 일회용품
        plasticCheck = findViewById(R.id.plastic_check);
        plasticCheck.setOnClickListener(checkStatus); // checkStatus 따로 정의
        // 내용
        requestText = findViewById(R.id.request);

        // 결제하기 버튼
        okButton = findViewById(R.id.okButton);
        okButton.setText((total_Price+3000)+" 원 결제하기");

        // 주문완료 창으로 이동
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detailAddress, request;

                // 값 받아오기
                detailAddress = detail_addressText.getText().toString();
                request = requestText.getText().toString();
                phoneNumber = phoneNumText.getText().toString();
                Intent intent = new Intent(OrderActivity.this, OrderCompleteActivity.class);
                Bundle extras = new Bundle();
                extras.putString("detailAddress", detailAddress);
                extras.putString("request", request);
                extras.putString("paymentMethod", payment);

                intent.putExtras(extras);

                startActivity(intent);
                finish(); // 창 닫기
            }
        });
    }

    //checkStatus 정의
    View.OnClickListener checkStatus = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (plasticCheck.isChecked()) {
                // 값 받아오기
                plasticStatus = plasticCheck.getText().toString();

            } else {
                plasticStatus = "일회용품(수저, 포크) O";
            }
        }
    };

        //paymentMethod 정의
        View.OnClickListener paymentMethod = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (payBtn1.isChecked()) {
                    // 값 받아오기
                    payment = payBtn1.getText().toString();

                } else if (payBtn2.isChecked()) {
                    payment = payBtn2.getText().toString();

                } else if (payBtn3.isChecked()) {
                    payment = payBtn3.getText().toString();

                } else if (payBtn4.isChecked()) {
                    payment = payBtn4.getText().toString();

                } else if (payBtn5.isChecked()) {
                    payment = payBtn5.getText().toString();

                } else if (payBtn6.isChecked()) {
                    payment = payBtn6.getText().toString();

                } else if (payBtn7.isChecked()) {
                    payment = payBtn7.getText().toString();

                } else {
                    Toast.makeText(OrderActivity.this, "결제수단을 선택하세요", Toast.LENGTH_SHORT).show();
                    onPause();
                }

            }
        };
    }