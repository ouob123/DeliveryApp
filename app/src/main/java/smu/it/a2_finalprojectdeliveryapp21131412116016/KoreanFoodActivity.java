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

public class KoreanFoodActivity extends AppCompatActivity {
    // 전역 변수 선언
    ImageButton backButton, homeButton;
    Button food1,food2,food3,food4,ok;
    TextView orderProduct;
    LinearLayout listView;

    // 각 메뉴의 수량을 static 전역 변수로 선언: 장바구니에서 총 금액 계산을 위해
    static int count11 = 0, count12 = 0, count13 = 0, count14 = 0;
    // 수량 표시를 위해 동적으로 생성될 텍스트뷰
    TextView textView_1,textView_2,textView_3,textView_4;

    static StringBuilder order_list1 = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean_food);

        // 장바구니 레이아웃 객체 생성
        listView = findViewById(R.id.listView);

        // 뒤로가기 버튼
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanFoodActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 홈(메인화면) 버튼
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanFoodActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 주문하기 버튼
        ok = findViewById(R.id.ok_button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanFoodActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 각 메뉴의 버튼 객체 생성
        food1 = findViewById(R.id.button1);
        food2 = findViewById(R.id.button2);
        food3 = findViewById(R.id.button3);
        food4 = findViewById(R.id.button4);
        // 버튼에 이벤트 리스너 등록
        food1.setOnClickListener(addCart);
        food2.setOnClickListener(addCart);
        food3.setOnClickListener(addCart);
        food4.setOnClickListener(addCart);

        // 장바구니를 이루는 객체 생성
        orderProduct = findViewById(R.id.orderProduct);
    }



    // addCart 정의
    View.OnClickListener addCart = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    if (count11==0) {
                        // 수량 입력
                        count11 = 1;
                        textView_1 = new TextView(getApplicationContext());
                        textView_1.setText("x " + count11);
                        textView_1.setTextSize(17);
                        textView_1.setTypeface(null, Typeface.BOLD);
                        textView_1.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_1.setLineSpacing(3,0);
                        listView.addView(textView_1);
                        // 메뉴 입력
                        order_list1.append("1인 보쌈 \n");
                        orderProduct.setText(order_list1);
                    } else {
                        count11++;
                        textView_1.setText("x " + count11);
                    }
                    break;
                case R.id.button2:
                    if (count12==0) {
                        // 수량 입력
                        count12 = 1;
                        textView_2 = new TextView(getApplicationContext());
                        textView_2.setText("x " + count12);
                        textView_2.setTextSize(17);
                        textView_2.setTypeface(null, Typeface.BOLD);
                        textView_2.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_2.setLineSpacing(3,0);
                        listView.addView(textView_2);
                        // 메뉴 입력
                        order_list1.append("마늘 보쌈 \n");
                        orderProduct.setText(order_list1);
                    } else {
                        count12++;
                        textView_2.setText("x " + count12);
                    }
                    break;
                case R.id.button3:
                    if (count13==0) {
                        // 수량 입력
                        count13 = 1;
                        textView_3 = new TextView(getApplicationContext());
                        textView_3.setText("x " + count13);
                        textView_3.setTextSize(17);
                        textView_3.setTypeface(null, Typeface.BOLD);
                        textView_3.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_3.setLineSpacing(3,0);
                        listView.addView(textView_3);
                        // 메뉴 입력
                        order_list1.append("간장 보쌈 \n");
                        orderProduct.setText(order_list1);
                    } else {
                        count13++;
                        textView_3.setText("x " + count13);
                    }
                    break;
                case R.id.button4:
                    if (count14==0) {
                        // 수량 입력
                        count14 = 1;
                        textView_4 = new TextView(getApplicationContext());
                        textView_4.setText("x " + count14);
                        textView_4.setTextSize(17);
                        textView_4.setTypeface(null, Typeface.BOLD);
                        textView_4.setTextColor(Color.parseColor("#4E4E4D"));
                        textView_4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        textView_4.setLineSpacing(3,0);
                        listView.addView(textView_4);
                        // 메뉴 입력
                        order_list1.append("불 족발 \n");
                        orderProduct.setText(order_list1);
                    } else {
                        count14++;
                        textView_4.setText("x " + count14);
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