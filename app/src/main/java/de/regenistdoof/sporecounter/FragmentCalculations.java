package de.regenistdoof.sporecounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// In this case, the fragment displays simple text based on the page
public class FragmentCalculations extends Fragment{


    public static EditText numberOfSquaresRef, countedCellsRef, dilutionRef;
    TextView resultRef;
    Button calculate;
    String TAG = "sporecounter";
    final double ten_k = 10000;




    public static FragmentCalculations newInstance(int page) {
        FragmentCalculations fragCalc = new FragmentCalculations();
        return fragCalc;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculation, container, false);
        resultRef = (TextView) view.findViewById(R.id.result);
        numberOfSquaresRef = (EditText) view.findViewById(R.id.number_of_squares);
        countedCellsRef = (EditText) view.findViewById(R.id.counted_cells);
        dilutionRef = (EditText) view.findViewById(R.id.dilution_factor);
        calculate = (Button) view.findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // newValue = ((MainActivity)getActivity()).getLastcount();
                // Log.d("sporecounter", "fragcalc value: " + newValue);

                int numberOfSquares = Integer.parseInt(numberOfSquaresRef.getText().toString());
                int countedCells = Integer.parseInt(countedCellsRef.getText().toString());
                int dilutionFactor = Integer.parseInt(dilutionRef.getText().toString());
                double concentration = ((countedCells * ten_k)/ (numberOfSquares * dilutionFactor))/10000;
                Log.d(TAG,""+concentration);
                resultRef.setText("" + concentration);
            }
        });

        return view;
    }



    public void updateCall(int count){
        Log.d(TAG, "fragcalc value: " + count);
        countedCellsRef.setText(""+count);
    }
}

