package com.example.cm.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView res = (TextView) findViewById(R.id.res);
        final TextView num1 = (EditText) findViewById(R.id.num1);
        final TextView num2 = (EditText) findViewById(R.id.num2);
        //final TextView ans = (EditText) findViewById(R.id.ans);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operation, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                /*Toast.makeText(parent.getContext(), "Item is " +
                        parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show(); */

/*
                Spinner sp =	(Spinner)findViewById(R.id.spinner);
                String spinnerString = null;
                spinnerString = sp.getSelectedItem().toString();
                int nPos = sp.getSelectedItemPosition();

*/
                double number1 = 0;
                double number2 = 0;
                double answer = 0;

                String o = num1.getText().toString();
                String o1 = num2.getText().toString();
                try{
                    number1 = Double.parseDouble(o);
                    number2 = Double.parseDouble(o1);
                }catch(NumberFormatException ex){ // handle your exception

                }
                //res.setText(Double.toString(number1+number2));
                switch ( parent.getItemAtPosition(pos).toString() ){
                    case "+" :

                        answer = number1 + number2 ;
                        res.setText(Double.toString(answer));
                        break;

                    case "-" :
                        answer = number1 - number2 ;
                        res.setText(Double.toString(answer));
                        break;

                    case "*" :
                        answer = number1 * number2 ;
                        res.setText(Double.toString(answer));
                        break;
                    case "/" :
                        if (number2 == 0) res.setText("Infinity");
                        else {
                            answer = number1 / number2 ;
                            res.setText(Double.toString(answer));
                        }
                        break;
                    case "%" :
                        answer = number1 % number2 ;
                        res.setText(Double.toString(answer));
                        break;
                    case "^" :
                        answer = Math.pow(number1, number2) ;
                        res.setText(Double.toString(answer));
                        break;
                    default:
                        res.setText("code needed !");

                }


            }

            public void onNothingSelected(AdapterView parent) {
                // Do nothing.
            }

                                          }
        );
/*
        Spinner sp =	(Spinner)findViewById(R.id.spinner);
        String operation = null;
        operation = sp.getSelectedItem().toString();
        int nPos = sp.getSelectedItemPosition();
*/


        Button Do =(Button)findViewById(R.id.Do);
        Do.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                Spinner sp =	(Spinner)findViewById(R.id.spinner);
                String spinnerString = null;
                spinnerString = sp.getSelectedItem().toString();
                int nPos = sp.getSelectedItemPosition();


                String o = num1.getText().toString();
                int number1 = Integer.parseInt(o);

                String o1 = num2.getText().toString();
                int number2 = Integer.parseInt(o1);

                double answer = 0;

                switch ( spinnerString ){
                    case "+" :

                        answer = number1 + number2 ;
                        res.setText(Double.toString(answer));
                        break;

                    case "-" :
                        answer = number1 - number2 ;
                        res.setText(Double.toString(answer));
                        break;

                    case "*" :
                        answer = number1 * number2 ;
                        res.setText(Double.toString(answer));
                        break;
                    case "/" :
                        if (number2 == 0) res.setText("Infinity");
                        else {
                            answer = number1 / number2 ;
                            res.setText(Double.toString(answer));
                        }
                        break;
                    case "%" :
                        answer = number1 % number2 ;
                        res.setText(Double.toString(answer));
                        break;
                    case "^" :
                        answer = Math.pow(number1, number2) ;
                        res.setText(Double.toString(answer));
                        break;
                    default:
                        res.setText("code needed !");

                }


                Toast.makeText(getApplicationContext(), "getSelectedItem=" + spinnerString,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "getSelectedItemPosition=" + nPos,
                        Toast.LENGTH_LONG).show();


            }
        });


        Button Reset = (Button) findViewById(R.id.Reset);


        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("0");
            }
        });


    }
}
/*
class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        Toast.makeText(parent.getContext(), "Item is " +
                parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();

        final TextView res = (TextView) findViewById(R.id.res);
        final TextView num1 = (EditText) findViewById(R.id.num1);
        final TextView num2 = (EditText) findViewById(R.id.num2);

        Spinner sp =	(Spinner)findViewById(R.id.spinner);
        String spinnerString = null;
        spinnerString = sp.getSelectedItem().toString();
        int nPos = sp.getSelectedItemPosition();


        String o = num1.getText().toString();
        int number1 = Integer.parseInt(o);

        String o1 = num2.getText().toString();
        int number2 = Integer.parseInt(o1);

        double answer = 0;

        switch ( spinnerString ){
            case "+" :

                answer = number1 + number2 ;
                res.setText(Double.toString(answer));
                break;

            case "-" :
                answer = number1 - number2 ;
                res.setText(Double.toString(answer));
                break;

            case "*" :
                answer = number1 * number2 ;
                res.setText(Double.toString(answer));
                break;
            case "/" :
                if (number2 == 0) res.setText("Infinity");
                else {
                    answer = number1 / number2 ;
                    res.setText(Double.toString(answer));
                }
                break;
            case "%" :
                answer = number1 % number2 ;
                res.setText(Double.toString(answer));
                break;
            case "^" :
                answer = Math.pow(number1, number2) ;
                res.setText(Double.toString(answer));
                break;
            default:
                res.setText("code needed !");

        }
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}
*/
/*
class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        System.out.println("----------------------------------------------------------------------");
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

*/