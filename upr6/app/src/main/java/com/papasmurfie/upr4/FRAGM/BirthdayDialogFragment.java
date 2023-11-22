package com.papasmurfie.upr4.FRAGM;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.papasmurfie.upr4.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BirthdayDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayDialogFragment extends DialogFragment {
private EditText name, age, wish;
private Button btnSave, btnCancel;
private AddCardListener listener;


    public BirthdayDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.dialog_name);
        age = view.findViewById(R.id.dialog_age);
        wish = view.findViewById(R.id.dialog_wigh);

        btnSave = view.findViewById(R.id.dialog_btnSave);
        btnCancel = view.findViewById(R.id.dialog_btn2Cancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BirthdayCard card = new BirthdayCard(name.getText().toString(),
                        Integer.parseInt(age.getText().toString()), wish.getText().toString(), 1);
                listener.onFinishAddCard(card);
                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        name.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public static BirthdayDialogFragment newInstance() {
       return new BirthdayDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (AddCardListener) context;
    }
}