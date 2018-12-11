package com.demo.dynamicformpoc;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.demo.dynamicformpoc.R.drawable.default_capture_image_one;

public class MainActivity extends AppCompatActivity {

    private LinearLayout formLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String form = "[ { \"type\": \"textView\", \"text\": \"Title\", \"size\": \"25\" }, [ { \"type\": \"textView\", \"text\": \"Name\", \"size\": \"18\" }, { \"type\": \"editText\", \"content\": \"text\" } ], [ { \"type\": \"textView\", \"text\": \"Marks\", \"size\": \"18\" }, { \"type\": \"editText\", \"content\": \"number\" } ], { \"type\": \"button\", \"text\": \"Submit\" }, { \"type\": \"image\" } ]";

        formLinearLayout = (LinearLayout) findViewById(R.id.form_linear_layout);

        try {
            parseForm(new JSONArray(form));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void parseForm(JSONArray form) {
        for (int i=0; i<form.length(); i++) {
            try {
                if (form.get(i) instanceof JSONObject) {
                    elementCheckAndAdd((JSONObject) form.get(i), formLinearLayout);
                } else {
                    LinearLayout linearLayout = new LinearLayout(this);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    for (int j=0; j<((JSONArray)(form.get(i))).length(); j++) {
                        elementCheckAndAdd((JSONObject) ((JSONArray)form.get(i)).get(j), linearLayout);
                    }
                    formLinearLayout.addView(linearLayout);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void elementCheckAndAdd(JSONObject element, LinearLayout formLinearLayout) throws JSONException {
        switch (element.get("type").toString()) {
            case "textView" :
                TextView textView = new TextView(this);
                textView.setText(element.get("text").toString());
                textView.setTextSize(Float.parseFloat(element.get("size").toString()));
                formLinearLayout.addView(textView);
                break;
            case "editText" :
                EditText editText = new EditText(this);
                formLinearLayout.addView(editText);
                break;
            case "button" :
                Button button = new Button(this);
                button.setText(element.get("text").toString());
                formLinearLayout.addView(button);
                break;
//            case "image" :
//                ImageView imageView = new ImageView(this);
//                imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.default_capture_image_one));
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//                formLinearLayout.addView(imageView);
//                break;
        }
    }
}
