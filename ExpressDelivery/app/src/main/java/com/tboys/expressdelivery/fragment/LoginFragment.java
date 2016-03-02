package com.tboys.expressdelivery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.tboys.expressdelivery.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText editText_phone;
    EditText editText_password;
    CheckBox checkBox;
    Button button_login;

    Button button_other_login_type;
    Spinner spinner_other_login_type;
    ArrayAdapter<String> adapter;
    String[] types = {"QQ登录", "微博登录"};

    int count = 0;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editText_phone = (EditText) view.findViewById(R.id.editText_phone);
        editText_password = (EditText) view.findViewById(R.id.editText_psd);
        checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        button_login = (Button) view.findViewById(R.id.button_login);
        button_other_login_type = (Button) view.findViewById(R.id.button_other_login_type);
        spinner_other_login_type = (Spinner) view.findViewById(R.id.spinner_other_login_type);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,
                types);
        spinner_other_login_type.setAdapter(adapter);
        String phoneNum = editText_phone.getText().toString();
        String pwd = editText_password.getText().toString();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()) {
                    editText_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editText_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_other_login_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count % 2 == 0) {
                    spinner_other_login_type.setVisibility(View.INVISIBLE);
                } else {

                    spinner_other_login_type.setVisibility(View.VISIBLE);
                }
            }
        });

        spinner_other_login_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = types[position];
                switch (type) {
                    case "QQ登录":
                        break;
                    case "微博登录":
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }


}
