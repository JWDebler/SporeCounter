package de.regenistdoof.sporecounter;

import android.app.Activity;
import android.os.Bundle;
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

    public interface CounterValueListener {
        public void onCounterIncrement(int count);
    }

private int page;

    public static FragmentCounter newInstance(int page) {
        FragmentCounter fragCount = new FragmentCounter();
        Bundle args = new Bundle();
        fragCount.setArguments(args);
        return fragCount;
    }

    int count = 0;
    TextView counter;
    LinearLayout layout;
    View view;
    boolean swipe = false;
    String TAG = "sporecounter";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_counter, container, false);
        layout = (LinearLayout) view.findViewById(R.id.layout);
        layout.setOnClickListener(this);

        counter = (TextView) view.findViewById(R.id.counter);

        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {


                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {

                        return false;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {

                        final int SWIPE_MIN_DISTANCE = 300;

                        try {
                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MIN_DISTANCE && e1.getY() > e2.getY()){
                                Log.d(TAG, "swipe up");
                                count = 0;
                                swipe = true;
                                counter.setText(Integer.toString(count));
                            }
                            else if ((Math.abs(e1.getY() - e2.getY()) > SWIPE_MIN_DISTANCE && e2.getY() > e1.getY())){
                                Log.d(TAG, "swipe down");
                                count = 0;
                                swipe = true;
                                counter.setText(Integer.toString(count));
                            }

                        } catch (Exception e) {
                            // nothing
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

    CounterValueListener counterValueListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            counterValueListener = (CounterValueListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onButtonPressed");
        }
    }

    @Override
    public void onClick(View v) {

         if (swipe) {
             counter.setText("0");
             swipe = false;
         } else {
             count++;
             counter.setText(Integer.toString(count));
             counterValueListener.onCounterIncrement(count);



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