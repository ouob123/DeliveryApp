package smu.it.a2_finalprojectdeliveryapp21131412116016;

import static smu.it.a2_finalprojectdeliveryapp21131412116016.RecommendActivity.imageViewFood;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodGalleryAdapter extends BaseAdapter {
    Context context;
    ImageView imageView;
    static TextView toastText; // RecommendActivity에서 사용하기 위해 static으로 선언

    Integer[] foodID = {R.drawable.store4_menu2, R.drawable.store5_menu1, R.drawable.store3_menu1,
            R.drawable.store6_menu3, R.drawable.store2_menu1};
    String[] foodName = {"스시쿠니: 장어초밥", "우리 할매 떡볶이: 가래떡 떡볶이", "홍콩반점: 짜장면",
            "투썸플레이스: 카페 라떼", "버거킹: 기네스콰트로치즈와퍼"};

    public FoodGalleryAdapter(Context c) {
        context = c;
    } // context로 MainActivity의 this를 잡아줌
    @Override
    public int getCount() {
        return foodID.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(300, 400));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(foodID[position]); // 갤러리뷰에 이미지 넣기

        final int selectedPosition = position;

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imageViewFood.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageViewFood.setImageResource(foodID[selectedPosition]); // 이미지뷰에 선택한 음식 크게 띄우기
                // 토스트로 선택된 음식 이름 띄우기
                Toast toast = new Toast(context.getApplicationContext());
                View toastView = (View) View.inflate(context.getApplicationContext(), R.layout.toast_food_title,null);
                toastText = (TextView) toastView.findViewById(R.id.textViewToast);
                toastText.setText(foodName[selectedPosition]);
                toast.setView(toastView);
                toast.show();
                return false;
            }
        });
        return imageView;
    }
}
