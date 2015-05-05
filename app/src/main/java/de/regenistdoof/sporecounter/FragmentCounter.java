package de.regenistdoof.sporecounter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// In this case, the fragment displays simple text based on the page
public class FragmentCounter extends Fragment implements View.OnClickListener,GestureDetector.OnGestureListener{


    public static FragmentCounter newInstance(int page) {
        FragmentCounter fragCount = new FragmentCounter();
        return fragCount;
    }

    int count = 0;
    TextView counter;
    LinearLayout layout;
    View view;
    boolean swipe = false;
    String TAG = "sporecounter";
    Vibrator vibrator;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_counter, container, false);
        layout = (LinearLayout) view.findViewById(R.id.layout);
        layout.setOnClickListener(this);
        counter = (TextView) view.findViewById(R.id.counter);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);


        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return false;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                        final int SWIPE_MIN_DISTANCE = 300;

                        try {   //swipe up
                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MIN_DISTANCE && e1.getY() > e2.getY()){
                                Log.d(TAG, "swipe up");
                                resetCounter();
                            }   //swipe down
                            else if ((Math.abs(e1.getY() - e2.getY()) > SWIPE_MIN_DISTANCE && e2.getY() > e1.getY())){
                                Log.d(TAG, "swipe down");
                                resetCounter();
                            }


                        } catch (Exception e) {
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void resetCounter(){
        count = 0;
        swipe = true;
        counter.setText(Integer.toString(count));
        ((MainActivity)getActivity()).setLastCount(count);
    }

    @Override
    public void onClick(View v) {




         if (swipe) {
             counter.setText("0");
             swipe = false;
         } else {
             count++;
             counter.setText(Integer.toString(count));
             ((MainActivity)getActivity()).setLastCount(count);
             vibrator.vibrate(30);
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