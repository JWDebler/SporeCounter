package de.regenistdoof.sporecounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

// In this case, the fragment displays simple text based on the page
public class FragmentCalculations extends Fragment implements AdapterViewCompat.OnItemSelectedListener{


    public static EditText numberOfSquaresRef, countedCellsRef, dilutionRef;
    TextView resultRef;
    Button calculate;
    String TAG = "sporecounter";
    public int ten_to_the = 10000;
    public int numberOfSquares;
    public int countedCells;
    public int dilutionFactor;
    public double concentration;





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

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.cells, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();

                if (selected.equals("x 10^4")){
                    ten_to_the = 10000;
                    calculate();
                }
                if (selected.equals("x 10^5")){
                    ten_to_the = 100000;
                    calculate();
                }
                if (selected.equals("x 10^6")){
                    ten_to_the = 1000000;
                    calculate();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        return view;
    }

    //performs the actual calculations
public void calculate(){
    numberOfSquares = Integer.parseInt(numberOfSquaresRef.getText().toString());
    countedCells = Integer.parseInt(countedCellsRef.getText().toString());
    dilutionFactor = Integer.parseInt(dilutionRef.getText().toString());
    concentration = ((countedCells * 10000.00)/ (numberOfSquares * dilutionFactor))/ten_to_the;

    resultRef.setText("" + concentration);
}

    public void updateCall(int count){
        countedCellsRef.setText(""+count);
    }

    @Override
    public void onItemSelected(AdapterViewCompat<?> adapterViewCompat, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterViewCompat<?> adapterViewCompat) {

    }
}

