package com.example.lenovo.androiddemo;

import android.graphics.Color;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

public class EditTextExample extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_example);

        linearLayout = (LinearLayout)findViewById(R.id.activity_edit_text_example);  // using to add view @end of LinearLayout
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "shivam");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        editText();
        button();
        radioGroup();
        spinner();



    }


    void editText()
    {
        EditText editText=(EditText)findViewById(R.id.editText);
        EditText pass=(EditText)findViewById(R.id.editText2);

        String s=editText.getText().toString();
        String s2=pass.getText().toString();
        Log.e("MSG",""+s+"--"+s2);

        EditText editText1=new EditText(this);
        editText1.setHint("E-Mail");
        editText1.setHintTextColor(Color.CYAN);

        editText1.setInputType(InputType.TYPE_CLASS_PHONE); // set type of input accept from user

        editText1.setFilters(
                new InputFilter[]{new InputFilter.LengthFilter(10)
                });     /*  new InputFilter.LengthFilter(10) meanse Length to be entered will not be >10, OR
                you can also replace or add in above array - new InputFilter.AllCaps()- to accept input in Capital
                letters

                */

        editText1.setCompoundDrawables(getResources().getDrawable(R.mipmap.ic_launcher),null,null,null);
        // set drawable @ left of edittext, parameter above follows as left-top-right-bottom, if passed null
        // no image will be shown

        linearLayout.addView(editText1);

    }

    void button()
    {
        Button button=(Button)findViewById(R.id.button21);
        Button button1=(Button)findViewById(R.id.button22);
        Button button2=(Button)findViewById(R.id.button23);
        Button button3=(Button)findViewById(R.id.button24);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MSG","HELLO");
            }
        });

        button3.setOnClickListener(onClickListener);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        ToggleButton toggleButton=new ToggleButton(this);

        toggleButton.setTextOn("PLAY");
        toggleButton.setTextOff("STOP");

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // buttonView contains the view button-  maniplulate its contents like background
                if(isChecked)
                    Log.e("MSG","ON");
                else
                    Log.e("MSG","OFF");
            }
        });

        linearLayout.addView(toggleButton);  // add the view to parent layout

    }


    void radioGroup()
    {
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radio);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton)
                    Log.e("MSG","MALE");
                else
                    Log.e("MSG","Female");
            }
        });
    }


    void spinner()
    {
        Spinner spinner=(Spinner)findViewById(R.id.spinner);

        final String[] data= getResources().getStringArray(R.array.state);  // getting data from string-array in string.xml

        spinner.setAdapter(new ArrayAdapter<String>(EditTextExample.this,
                android.R.layout.simple_spinner_dropdown_item,data));
        // pass context, layout to be set on each item,data as (Array OR ArrayList mostly Integer and)

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("MSG",data[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e("MSG","NOTHING");

            }
        });
    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button22)
        {
            Log.e("MSG","111");
        }
        else if(v.getId()==R.id.button23)
        {
            Log.e("MSG","222");

        }
    }


    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("MSG","3333");
        }
    };
}
