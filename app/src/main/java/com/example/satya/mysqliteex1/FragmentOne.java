package com.example.satya.mysqliteex1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    EditText et1,et2;
    TextView tv1;
    Button bt1,bt2;
    MyDataBase myDataBase;


    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //open database here
         myDataBase = new MyDataBase(getActivity());
        myDataBase.open();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_one, container, false);
        et1 = (EditText) v.findViewById(R.id.et1);
        et2 = (EditText) v.findViewById(R.id.et2);
        bt1 = (Button) v.findViewById(R.id.bt1);
        bt2 = (Button) v.findViewById(R.id.bt2);
        tv1 = (TextView) v.findViewById(R.id.tv1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we will insert data to table
                String name= et1.getText().toString();
                String course = et2.getText().toString();
            myDataBase.insertStudent(et1.getText().toString(),et2.getText().toString());
                et1.setText("");
                et2.setText("");
                et1.requestFocus();
                Toast.makeText(getActivity(), "INSERTED A ROW", Toast.LENGTH_SHORT).show();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we will read data from table/database
            }
        });
        return v;
    }

}
