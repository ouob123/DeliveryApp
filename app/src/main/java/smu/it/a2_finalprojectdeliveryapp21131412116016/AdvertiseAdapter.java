package smu.it.a2_finalprojectdeliveryapp21131412116016;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// 어댑터에서 이미지 갯수를 return
// 이미지를 약 2000장 생성하여 사실상 무한대로 스크롤 가능하도록
public class AdvertiseAdapter extends FragmentStateAdapter {
    public int mCount;

    public AdvertiseAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        // 5장의 광고 페이지를 표시해주는 것을 Fragment.java로 각각 생성하여 return
        if(index==0) return new Fragment_1();
        else if(index==1) return new Fragment_2();
        else if(index==2) return new Fragment_3();
        else if(index==3) return new Fragment_4();
        else return new Fragment_5();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }
    public int getRealPosition(int position) { return position % mCount; }

}
