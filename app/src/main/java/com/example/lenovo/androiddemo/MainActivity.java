package com.example.lenovo.androiddemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);

        TextView textView=(TextView)findViewById(R.id.textView);

        textView.setText(getResources().getString(R.string.app_name));

        textView.setTextColor(Color.BLUE);

        if(Build.VERSION.SDK_INT<= Build.VERSION_CODES.KITKAT)
        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        else
        textView.setTextColor(getResources().getColor(R.color.colorAccent,getResources().newTheme()));

        textView.setText(Html.fromHtml("<h1>Hello</h1>"));
       // textView.setText(Html.fromHtml("<font color='#181AA9'>Pay</font><font color='#2E7CE1'>tm</font>"));
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linear1);

        TextView textView1=new TextView(this);
        textView1.setText("Hello");
        textView1.setTextSize(20);
        textView1.setBackgroundColor(Color.BLUE);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int)getResources().getDimension(R.dimen.textHeight),1f);

        textView1.setLayoutParams(params);


      /*  for(int i=1;i<10;i++)*/
        linearLayout.addView(textView1);
       // linearLayout.addView(textView1);




    }




}
