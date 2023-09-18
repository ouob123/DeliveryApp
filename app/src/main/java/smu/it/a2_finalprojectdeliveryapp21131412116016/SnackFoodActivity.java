package smu.it.a2_finalprojectdeliveryapp21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackFoodActivity extends AppCompatActivity {
    // 전역 변수 선언
    ImageButton backButton, homeButton;
    Button food1,food2,food3,food4,food5,ok;
    TextView orderProduct;
    LinearLayout listView;

    static int count51 = 0, count52 = 0, count53 = 0, count54 = 0, count55 = 0;
    TextView textView_1,textView_2,textView_3,textView_4,textView_5;

    static StringBuilder order_list5 = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_food);

        // 장바구니 레이아웃 객체 생성
        listView = findViewById(R.id.listView);

        // 뒤로가기 버튼
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnackFoodActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 홈(메인화면) 버튼
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnackFoodActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 주문하기 버튼
        ok = findViewById(R.id.ok_button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnackFoodActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 각 메뉴의 버튼 객체 생성
        food1 = findViewById(R.id.button1);
        food2 = findViewById(R.id.button2);
        food3 = findViewById(R.id.button3);
        food4 = findViewById(R.id.button4);
        food5 = findViewById(R.id.button5);
        // 버튼에 이벤트 리스너 등록
        food1.setOnClickListener(addCart);
        food2.setOnClickListener(addCart);
        food3.setOnClickListener(addCart);
        food4.setOnClickListener(addCart);
        food5.setOnClickListener(addCart);

        // 장바구니를 이루는 객체 생성
        orderProduct = findViewById(R.id.orderProduct);
    }

    // addCart 정의
    View.OnClickListener addCart = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    if (count51==0) {
                        // 수량 입력
                        count51 = 1;
                        textView_1 = new TextView(getApplicationContext());
                        textView_1.setText("x " + count51);
                        textView_1.setTextSize(17);
                        textView_1.setTypeface(null, Typeface.BOLD);
                        textView_1.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_1.setLineSpacing(3,0);
                        listView.addView(textView_1);
                        // 메뉴 입력
                        order_list5.append("가래떡 떡볶이 \n");
                        orderProduct.setText(order_list5);
                    } else {
                        count51++;
                        textView_1.setText("x " + count51);
                    }
                    break;
                case R.id.button2:
                    if (count52==0) {
                        // 수량 입력
                        count52 = 1;
                        textView_2 = new TextView(getApplicationContext());
                        textView_2.setText("x " + count52);
                        textView_2.setTextSize(17);
                        textView_2.setTypeface(null, Typeface.BOLD);
                        textView_2.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_2.setLineSpacing(3,0);
                        listView.addView(textView_2);
                        // 메뉴 입력
                        order_list5.append("밀 떡볶이 \n");
                        orderProduct.setText(order_list5);
                    } else {
                        count52++;
                        textView_2.setText("x " + count52);
                    }
                    break;
                case R.id.button3:
                    if (count53==0) {
                        // 수량 입력
                        count53 = 1;
                        textView_3 = new TextView(getApplicationContext());
                        textView_3.setText("x " + count53);
                        textView_3.setTextSize(17);
                        textView_3.setTypeface(null, Typeface.BOLD);
                        textView_3.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_3.setLineSpacing(3,0);
                        listView.addView(textView_3);
                        // 메뉴 입력
                        order_list5.append("순대 \n");
                        orderProduct.setText(order_list5);
                    } else {
                        count53++;
                        textView_3.setText("x " + count53);
                    }
                    break;
                case R.id.button4:
                    if (count54==0) {
                        // 수량 입력
                        count54 = 1;
                        textView_4 = new TextView(getApplicationContext());
                        textView_4.setText("x " + count54);
                        textView_4.setTextSize(17);
                        textView_4.setTypeface(null, Typeface.BOLD);
                        textView_4.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_4.setLineSpacing(3,0);
                        listView.addView(textView_4);
                        // 메뉴 입력
                        order_list5.append("할매튀김 \n");
                        orderProduct.setText(order_list5);
                    } else {
                        count54++;
                        textView_4.setText("x " + count54);
                    }
                    break;
                case R.id.button5:
                    if (count55==0) {
                        // 수량 입력
                        count55 = 1;
                        textView_5 = new TextView(getApplicationContext());
                        textView_5.setText("x " + count55);
                        textView_5.setTextSize(17);
                        textView_5.setTypeface(null, Typeface.BOLD);
                        textView_5.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_5.setLineSpacing(3,0);
                        listView.addView(textView_5);
                        // 메뉴 입력
                        order_list5.append("꼬치어묵 \n");
                        orderProduct.setText(order_list5);
                    } else {
                        count55++;
                        textView_5.setText("x " + count55);
                    }
                    break;
            }
        }
    };

    /*private void createTextView(int count) {
        textView = new TextView(getApplicationContext());
        textView.setText("x " + count);
        textView.setId(i);
        textView.setTextSize(17);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.parseColor("#4E4E4D"));
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setLineSpacing(3,0);
        listView.addView(textView);
        i++;
    }*/
}