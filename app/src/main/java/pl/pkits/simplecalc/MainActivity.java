package pl.pkits.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class MainActivity extends AppCompatActivity {

    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, multiplyButton, divideButton,
        equalsButton, plusButton, minusButton, bkspButton, clearButton, dot;

    TextView expression, result;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("expressionValue", expression.getText().toString());
        savedInstanceState.putString("resultValue", result.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        equalsButton = (Button) findViewById(R.id.resultButton);
        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        bkspButton = (Button) findViewById(R.id.bkspButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        expression = (TextView) findViewById(R.id.tvExp);
        result = (TextView) findViewById(R.id.tvRes);
        dot = (Button) findViewById(R.id.dotButton);

        if(savedInstanceState != null){
            expression.setText(savedInstanceState.getString("expressionValue"));
            result.setText(savedInstanceState.getString("resultValue"));
        }

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("0"));
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("1"));
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("2"));
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("3"));
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("4"));
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("5"));
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("6"));
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("7"));
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("8"));
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("9"));
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.endsWith("/"))
                    currentText = currentText.substring(0, currentText.length()-1);
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("*"));
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.endsWith("*"))
                    currentText = currentText.substring(0, currentText.length()-1);
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("/"));
            }
        });


        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("+"));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= 15)
                    result.setText(currentText.concat("-"));
            }
        });


        bkspButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                int length = currentText.length();
                if(length > 0) {
                    result.setText(currentText.substring(0, currentText.length() - 1));
                    expression.setText("");
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                expression.setText("");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                String toConcat;

                if(currentText.length() <= 15){
                    if(currentText.isEmpty() || !Character.isDigit(currentText.charAt(currentText.length()-1))) {
                        toConcat = "0.";
                    } else {
                        toConcat = ".";
                    }
                    result.setText(currentText.concat(toConcat));
                }
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                currentText = trimInput(currentText);
                if(currentText != null && !currentText.isEmpty()) {
                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);
                    try {
                        ScriptableObject scope = rhino.initStandardObjects();
                        String jsResult = rhino.evaluateString(scope, currentText, "JavaScript", 1, null).toString();
                        if (jsResult.length() > 15) {
                            jsResult = jsResult.substring(0, 15);
                        }
                        jsResult = trimResult(jsResult);
                        expression.setText(currentText);
                        result.setText(jsResult);
                    } finally {
                        Context.exit();
                    }
                }
            }
        });

    }

    private String trimResult(String s){
        if((s.endsWith("0") || s.endsWith(".")) && s.length() > 1){
            s = s.substring(0, s.length() - 1);
            s = trimResult(s);
        }
        return  s;
    }

    private String trimInput(String s){
        if(s.length() >=1 && !Character.isDigit(s.charAt(s.length() - 1))){
            s = s.substring(0, s.length() - 1);
            s = trimInput(s);
        }
        if(s.length() > 0 && !Character.isDigit(s.charAt(0))){
            s = "0" + s;
        }
        return  s;
    }
}
