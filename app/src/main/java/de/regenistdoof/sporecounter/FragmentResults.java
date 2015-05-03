package de.regenistdoof.sporecounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 263522i on 1/05/2015.
 */
public class FragmentResults extends Fragment {


    public static FragmentResults newInstance(int page) {
        FragmentResults fragResult = new FragmentResults();
        return fragResult;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_results, container, false);

        return view;
    }
}
