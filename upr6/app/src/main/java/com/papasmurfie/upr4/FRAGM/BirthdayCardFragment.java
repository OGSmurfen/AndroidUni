package com.papasmurfie.upr4.FRAGM;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.papasmurfie.upr4.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BirthdayCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayCardFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private BirthdayCard birthdayCard;


    public BirthdayCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @BirthdayCard birthdayCard Parameter 1.
     * @return A new instance of fragment BirthdayCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BirthdayCardFragment newInstance(BirthdayCard card) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, card);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            birthdayCard = getArguments().getParcelable(ARG_PARAM1, BirthdayCard.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_birthday_card, container, false);

        if(birthdayCard != null){
            TextView tvName = view.findViewById(R.id.card_name);
            TextView tvAge = view.findViewById(R.id.card_age);
            TextView tvWish = view.findViewById(R.id.card_wish);
            tvName.setText(birthdayCard.getName());
            tvAge.setText(String.valueOf(birthdayCard.getAge()));
            tvWish.setText(birthdayCard.getWish());
        }

        return view;
    }
}