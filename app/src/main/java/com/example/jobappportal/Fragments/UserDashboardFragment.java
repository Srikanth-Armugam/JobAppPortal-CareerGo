package com.example.jobappportal.Fragments;


import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jobappportal.Fragments.UserPlacedApplicationsFragment;

import com.example.jobappportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserDashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserDashboardFragment extends Fragment {

    SwitchCompat mSwitch;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserDashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserDashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserDashboardFragment newInstance(String param1, String param2) {
        UserDashboardFragment fragment = new UserDashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_dashboard, container, false);

        //Switch to navigate between fragments
        mSwitch = (SwitchCompat) view.findViewById(R.id.UserDashBoardSwitch);
        mSwitch.setChecked(false);
        getFragmentManager().beginTransaction().replace(R.id.UserDashBoardContainer, new UserAllApplicationsFragment()).commit();
        mSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSwitch.isChecked()) {
                    //Navigates to all placed applications fragment
                    getFragmentManager().beginTransaction().replace(R.id.UserDashBoardContainer, new UserPlacedApplicationsFragment()).commit();
                } else {
                    //Navigates to all applications Fragment
                    getFragmentManager().beginTransaction().replace(R.id.UserDashBoardContainer, new UserAllApplicationsFragment()).commit();
                }
            }
        });

        return view;
    }
}