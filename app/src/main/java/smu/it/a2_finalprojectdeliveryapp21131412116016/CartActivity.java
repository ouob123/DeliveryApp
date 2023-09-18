package smu.it.a2_finalprojectdeliveryapp21131412116016;

import static smu.it.a2_finalprojectdeliveryapp21131412116016.ChineseFoodActivity.count31;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.ChineseFoodActivity.count32;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.ChineseFoodActivity.count33;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.ChineseFoodActivity.count34;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.ChineseFoodActivity.count35;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.ChineseFoodActivity.order_list3;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.DessertActivity.count61;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.DessertActivity.count62;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.DessertActivity.count63;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.DessertActivity.count64;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.DessertActivity.order_list6;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.JanpaneseFoodActivity.count41;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.JanpaneseFoodActivity.count42;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.JanpaneseFoodActivity.count43;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.JanpaneseFoodActivity.count44;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.JanpaneseFoodActivity.count45;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.JanpaneseFoodActivity.order_list4;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.KoreanFoodActivity.count11;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.KoreanFoodActivity.count12;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.KoreanFoodActivity.count13;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.KoreanFoodActivity.count14;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.KoreanFoodActivity.order_list1;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.SnackFoodActivity.count51;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.SnackFoodActivity.count52;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.SnackFoodActivity.count53;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.SnackFoodActivity.count54;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.SnackFoodActivity.count55;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.SnackFoodActivity.order_list5;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.WesternFoodActivity.count21;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.WesternFoodActivity.count22;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.WesternFoodActivity.count23;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.WesternFoodActivity.count24;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.WesternFoodActivity.count25;
import static smu.it.a2_finalprojectdeliveryapp21131412116016.WesternFoodActivity.order_list2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    // 전역 변수 선언
    ImageButton homeButton;
    Integer totalPrice_store1 = 0,totalPrice_store2 = 0,totalPrice_store3 = 0
            ,totalPrice_store4 = 0,totalPrice_store5 = 0,totalPrice_store6 = 0;
    static Integer total_Price = 0;
    TextView orderList, total_price;
    Button ok;
    String order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // 객체 생성
        orderList = findViewById(R.id.orderList); // 주문내역
        total_price = findViewById(R.id.total_Price);// 총 금액

        // 홈(메인화면) 버튼
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 총 금액 (한식 가게)
        totalPrice_store1 = (9700*count11)+(10700*count12)+(10700*count13)+(11100*count14);
        // 총 금액 (양식 가게)
        totalPrice_store2 = (10200*count21)+(8600*count22)+(20900*count23)+(2700*count24)+(2600*count25);
        // 총 금액 (중식 가게)
        totalPrice_store3 = (6500*count31)+(7500*count32)+(8500*count33)+(14900*count34)+(8500*count35);
        // 총 금액 (일식 가게)
        totalPrice_store4 = (14900*count41)+(25000*count42)+(11900*count43)+(13500*count44)+(8000*count45);
        // 총 금액 (분식 가게)
        totalPrice_store5 = (4500*count51)+(4500*count52)+(4500*count53)+(7500*count54)+(3000*count55);
        // 총 금액 (디저트 가게)
        totalPrice_store6 = (5000*count61)+(5000*count62)+(5500*count63)+(6500*count64);

        // 주문내역
        order = order_list1+"\n"+order_list2+"\n"+order_list3+"\n"+order_list4+"\n"+order_list5+"\n"+order_list6+"\n";
        orderList.setText(order);

        // 총 금액
        total_Price = totalPrice_store1+totalPrice_store2+totalPrice_store3+totalPrice_store4+totalPrice_store5+totalPrice_store6;
        total_price.setText("총 결제금액: "+total_Price+" 원");

        // 주문하기 버튼
        ok = findViewById(R.id.ok_button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, OrderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 장바구니 비우기 버튼 - 구현 실패
        /*delete = findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = "";
                orderList.setText(order);
                total_Price = 0;
                total_price.setText("총 결제금액: "+total_Price+" 원");
            }
        });*/
    }
}