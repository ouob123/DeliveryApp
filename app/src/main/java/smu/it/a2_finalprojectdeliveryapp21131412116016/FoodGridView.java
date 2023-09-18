package smu.it.a2_finalprojectdeliveryapp21131412116016;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;

// BaseAdapter 사용해서 GridView에 음식 아이콘 붙이기
public class FoodGridView extends BaseAdapter {
    Context context;
    Integer[] foodID = {R.drawable.button_koreanfood, R.drawable.button_westernfood, R.drawable.button_chinesefood,
            R.drawable.button_japanesefood, R.drawable.button_snackfood, R.drawable.button_dessert};

    public FoodGridView(Context c) {context = c;}

    public int getCount() {
        return foodID.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // gridView에 이미지 붙이기
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(240, 300)); // 이미지 뷰의 가로,세로 크기
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 이미지 가운데 설정
        imageView.setPadding(20,20,20,20); // 여백 설정
        imageView.setImageResource(foodID[position]); // 보여줄 이미지 파일

        // 각 음식 아이콘을 클릭하였을 때 발생하는 이벤트 정의
        int selectedPosition = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (selectedPosition) {
                    case 0:
                        Intent intent = new Intent(context, KoreanFoodActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(context, WesternFoodActivity.class);
                        context.startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(context, ChineseFoodActivity.class);
                        context.startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(context, JanpaneseFoodActivity.class);
                        context.startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(context, SnackFoodActivity.class);
                        context.startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6 = new Intent(context, DessertActivity.class);
                        context.startActivity(intent6);
                        break;
                }
            }
        });
        return imageView;
    }
}
