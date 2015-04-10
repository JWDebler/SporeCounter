package de.regenistdoof.sporecounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

// In this case, the fragment displays simple text based on the page
public class FragmentCounter extends Fragment implements View.OnClickListener,GestureDetector.OnGestureListener{

int count = 0;
TextView counter;
LinearLayout layout;
View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_counter, container, false);

        layout = (LinearLayout) view.findViewById(R.id.layout);

        layout.setOnClickListener(this);

        counter = (TextView) view.findViewById(R.id.counter);




        return view;
    }

    @Override
    public void onClick(View v) {
        switch (view.getId()){
            case R.id.layout:
                count ++;
                counter.setText(Integer.toString(count));
        }


    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}