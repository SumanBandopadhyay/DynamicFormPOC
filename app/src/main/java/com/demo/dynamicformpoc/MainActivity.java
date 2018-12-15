package com.demo.dynamicformpoc;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
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
    private Button btnSubmit;
    private ExpandableTextView expandableTextView;
    private com.ms.square.android.expandabletextview.ExpandableTextView expandableTextViewNew;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = "Earth work in excavation by manual means in foundation trenches or drains (not exceeding 1.5 m in width or 10 sqm on plan), including dressing of sides and ramming of bottoms, lift upto 1.5 m, including getting out the excavated soil and disposal of surplus excavated soil as directed, within a lead of 50 m.";

        expandableTextView = (ExpandableTextView) findViewById(R.id.expandable_txt);
        expandableTextView.setText(str);

        expandableTextViewNew = (com.ms.square.android.expandabletextview.ExpandableTextView) findViewById(R.id.expand_text_view);
        expandableTextViewNew.setText(str);


        final String initialForm = "[ { \"type\": \"textView\", \"text\": \"Earth Work\", \"size\": 25, \"visible\": true }, { \"type\": \"textView\", \"text\": \"Earth work in excavation by manual means in foundation trenches or drains (not exceeding 1.5 m in width or 10 sqm on plan), including dressing of sides and ramming of bottoms, lift upto 1.5 m, including getting out the excavated soil and disposal of surplus excavated soil as directed, within a lead of 50 m.\", \"size\": 10, \"visible\": true }, { \"type\": \"textView\", \"text\": \"All kinds of soil\", \"size\": 18, \"bold\": true, \"visible\": true }, { \"type\": \"textView\", \"text\": \"Boundary Wall\", \"size\": 14, \"bold\": true, \"visible\": true }, [ { \"type\": \"textView\", \"text\": \"Number\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 38, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Length\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": true, \"value\": 0, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Bredth\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": true, \"value\": 0, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Height\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": true, \"value\": 0, \"visible\": true } ], { \"type\": \"textView\", \"text\": \"Excavation work by manual means in foundation trenches or drains (not exceeding 1.5m in width or 10 sqm on plan), including dressing of sides and ramming of bottoms, lift upto 1.5 m, including getting out the excavated soil and disposal of surplus excavated soils as directed, within a lead of 50 m.\", \"size\": 10, \"visible\": false }, [ { \"type\": \"textView\", \"text\": \"Ordinary Rock (40% of total quantity)\", \"size\": 12, \"visible\": false }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0, \"visible\": false } ], [ { \"type\": \"textView\", \"text\": \"Hard Rock (10% of total quantity)\", \"size\": 12, \"visible\": false }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0, \"visible\": false } ], [ { \"type\": \"textView\", \"text\": \"Net quantity for ordinary soil\", \"size\": 12, \"visible\": false }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0, \"visible\": false } ] ]";
        final String submittedForm = "[ { \"type\": \"textView\", \"text\": \"Earth Work\", \"size\": 25, \"visible\": true }, { \"type\": \"textView\", \"text\": \"Earth work in excavation by manual means in foundation trenches or drains (not exceeding 1.5 m in width or 10 sqm on plan), including dressing of sides and ramming of bottoms, lift upto 1.5 m, including getting out the excavated soil and disposal of surplus excavated soil as directed, within a lead of 50 m.\", \"size\": 10, \"visible\": true }, { \"type\": \"textView\", \"text\": \"All kinds of soil\", \"size\": 18, \"bold\": true, \"visible\": true }, { \"type\": \"textView\", \"text\": \"Boundary Wall\", \"size\": 14, \"bold\": true, \"visible\": true }, [ { \"type\": \"textView\", \"text\": \"Number\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 38, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Length\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0.60, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Bredth\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0.60, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Height\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0.70, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Total Quantity\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 9.576, \"visible\": true } ], { \"type\": \"textView\", \"text\": \"Excavation work by manual means in foundation trenches or drains (not exceeding 1.5m in width or 10 sqm on plan), including dressing of sides and ramming of bottoms, lift upto 1.5 m, including getting out the excavated soil and disposal of surplus excavated soils as directed, within a lead of 50 m.\", \"size\": 10, \"visible\": true }, [ { \"type\": \"textView\", \"text\": \"Ordinary Rock (40% of total quantity)\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 3.830, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Hard Rock (10% of total quantity)\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 0.958, \"visible\": true } ], [ { \"type\": \"textView\", \"text\": \"Net quantity for ordinary soil\", \"size\": 12, \"visible\": true }, { \"type\": \"editText\", \"content\": \"number\", \"editable\": false, \"value\": 4.788, \"visible\": true } ] ]";

        formLinearLayout = (LinearLayout) findViewById(R.id.form_linear_layout);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    formLinearLayout.removeAllViews();
                    parseForm(new JSONArray(submittedForm));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            parseForm(new JSONArray(initialForm));
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
                if (!element.getBoolean("visible")) {
                    textView.setVisibility(View.GONE);
                }
                formLinearLayout.addView(textView);
                break;
            case "editText" :
                EditText editText = new EditText(this);
                editText.setText(element.get("value").toString());
                switch (element.get("content").toString()) {
                    case "number":
                        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        break;
                    default:
                        editText.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                if (!element.getBoolean("editable")) {
                    disableInput(editText);
                    editText.setTextIsSelectable(true);
                    editText.setBackground(null);
                }
                if (!element.getBoolean("visible")) {
                    editText.setVisibility(View.GONE);
                }
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

    void disableInput(EditText editText){
        editText.setInputType(InputType.TYPE_NULL);
        editText.setTextIsSelectable(false);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v,int keyCode,KeyEvent event) {
                return true;  // Blocks input from hardware keyboards.
            }
        });
    }

}
