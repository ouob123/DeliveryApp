package smu.it.a2_finalprojectdeliveryapp21131412116016;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

// 각 이미지를 받아서 화면에 뷰를 표시해주는 Fragment 생성
public class Fragment_4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_ad4, container, false);

        return rootView;
    }

}
