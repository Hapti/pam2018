package pl.pkits.simplecalc;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private int HORIZONTAL_MAX = 25;
    private int VERTICAL_MAX = 15;

    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, multiplyButton, divideButton,
        equalsButton, plusButton, minusButton, bkspButton, clearButton, dot;

    Button ln, log, sqrt, pow, pow2, sin, cos, tan, perc;

    TextView expression, result;

    String rawInput;

    boolean isHorizontal = false;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("expressionValue", expression.getText() != null ? expression.getText().toString() : null);
        savedInstanceState.putString("resultValue", result.getText() != null ? result.getText().toString()  : null);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            isHorizontal = false;
            setContentView(R.layout.activity_main);
            setupBasicButtons();
        } else {
            isHorizontal = true;
            setContentView(R.layout.horizontal_advanced_layout);
            setupBasicButtons();
            setupHorizontalAdditionalButtons();
        }

        if(savedInstanceState != null){
            expression.setText(savedInstanceState.getString("expressionValue"));
            result.setText(savedInstanceState.getString("resultValue"));
        }




    }

    private void setupBasicButtons(){
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
        dot = (Button) findViewById(R.id.dotButton);
        expression = (TextView) findViewById(R.id.tvExp);
        result = (TextView) findViewById(R.id.tvRes);



        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )){
                    result.setText(currentText.concat("0"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "0";
                    }
                }
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("1"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "1";
                    }
                }
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("2"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "2";
                    }
                }
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("3"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "3";
                    }
                }
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("4"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "4";
                    }
                }
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("5"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "5";
                    }
                }
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("6"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "6";
                    }
                }
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("7"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "7";
                    }
                }
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("8"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "8";
                    }
                }
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() <= VERTICAL_MAX || (isHorizontal && currentText.length() <= HORIZONTAL_MAX )) {
                    result.setText(currentText.concat("9"));
                    if(rawInput != null && rawInput.length() > 0){
                        rawInput = rawInput + "9";
                    }
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if ((currentText.length() <= VERTICAL_MAX
                            || (isHorizontal && currentText.length() <= HORIZONTAL_MAX ))
                        && (rawInput == null || rawInput.length() == 0)) {
                    result.setText(currentText.concat("*"));
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if((currentText.length() <= VERTICAL_MAX
                            || (isHorizontal && currentText.length() <= HORIZONTAL_MAX ))
                        && (rawInput == null || rawInput.length() == 0))
                    result.setText(currentText.concat("/"));
            }
        });


        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if((currentText.length() <= VERTICAL_MAX
                            || (isHorizontal && currentText.length() <= HORIZONTAL_MAX ))
                        && (rawInput == null || rawInput.length() == 0))
                    result.setText(currentText.concat("+"));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if((currentText.length() <= VERTICAL_MAX
                            || (isHorizontal && currentText.length() <= HORIZONTAL_MAX ))
                        && (rawInput == null || rawInput.length() == 0))
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
                if((currentText.length() <= VERTICAL_MAX
                            || (isHorizontal && currentText.length() <= HORIZONTAL_MAX ))
                        && !currentText.contains("."))
                    result.setText(currentText.concat("."));
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                currentText = trimInput(currentText);
                if(!currentText.isEmpty()) {
                    String jresult;
                    if(rawInput != null && rawInput.length() > 0) {
                        if(Character.isDigit(rawInput.charAt(rawInput.length()-1))) {
                            jresult = evaluateString(rawInput + ")");
                            currentText = currentText + ")";
                        } else {
                            jresult = evaluateString(rawInput + "0)");
                            currentText = currentText + "0)";
                        }
                    } else {
                        jresult = evaluateString(currentText);
                    }
                    rawInput = null;
                    result.setText(jresult);
                    expression.setText(currentText);
                }
            }
        });
    }

    private void setupHorizontalAdditionalButtons(){
        ln =  (Button) findViewById(R.id.lnButton);
        log =  (Button) findViewById(R.id.logButton);
        sin =  (Button) findViewById(R.id.sinButton);
        cos =  (Button) findViewById(R.id.cosButton);
        tan =  (Button) findViewById(R.id.tanButton);
        sqrt =  (Button) findViewById(R.id.sqrtButton);
        pow =  (Button) findViewById(R.id.powButton);
        pow2 =  (Button) findViewById(R.id.pow2Button);
        perc =  (Button) findViewById(R.id.percButton);

        pow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String currentText = "Math.pow(2,2)";
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    String jresult = evaluateString("Math.pow(" + currentText + ",2)");
                    if(isNumeric(jresult)) {
                        result.setText(jresult);
                        expression.setText("(" + currentText + ")^2");
                    } else {
                        result.setText("");
                        expression.setText("");
                    }
                }
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    rawInput = "Math.pow(" + currentText + ",";
                    String visibleText = "("+currentText+")^(";
                    result.setText(visibleText);
                }
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    String jresult = evaluateString("Math.sqrt(" + currentText + ")");
                    if(isNumeric(jresult)) {
                        result.setText(jresult);
                        expression.setText("sqrt(" + currentText + ")");
                    } else {
                        result.setText("");
                        expression.setText("");
                    }
                }
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    String jresult = evaluateString("Math.sin(" + currentText + ")");
                    if(isNumeric(jresult)) {
                        result.setText(jresult);
                        expression.setText("sin(" + currentText + ")");
                    } else {
                        result.setText("");
                        expression.setText("");
                    }
                }
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    String jresult = evaluateString("Math.cos(" + currentText + ")");
                    if(isNumeric(jresult)) {
                        result.setText(jresult);
                        expression.setText("cos(" + currentText + ")");
                    } else {
                        result.setText("");
                        expression.setText("");
                    }
                }
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    String jresult = evaluateString("Math.tan(" + currentText + ")");
                    if(isNumeric(jresult)) {
                        result.setText(jresult);
                        expression.setText("tan(" + currentText + ")");
                    } else {
                        result.setText("");
                        expression.setText("");
                    }
                }
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    String jresult = evaluateString("Math.log(" + currentText + ")");
                    if(isNumeric(jresult)) {
                        result.setText(jresult);
                        expression.setText("ln(" + currentText + ")");
                    } else {
                        result.setText("");
                        expression.setText("");
                    }
                }
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            // Math.log(n) / Math.log(base);
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(isNumeric(currentText)){
                    rawInput = "1/Math.log(" + currentText + ") * Math.log(";
                    String visibleText = "log"+currentText+"(";
                    result.setText(visibleText);
                }
            }
        });

        perc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if(currentText.length() > 0 && (rawInput == null || rawInput.length() ==0)){
                    String regex = "(\\d++\\.?\\d*?)\\D*+$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(currentText);
                    if(matcher.find()){
                        String lastNumber = matcher.group(1);
                        BigDecimal numberToPerc = new BigDecimal(lastNumber);
                        numberToPerc = numberToPerc.divide(new BigDecimal(100));
                        numberToPerc = numberToPerc.stripTrailingZeros();

                        int index = currentText.lastIndexOf(lastNumber);
                        if (index >= 0) {
                            String temp = currentText.substring(0, index);
                            temp = temp + numberToPerc.toPlainString();
                            temp = temp + currentText.substring(index + lastNumber.length(), currentText.length());
                            if(temp.length() <= HORIZONTAL_MAX) {
                                result.setText(temp);
                            } else {
                                android.content.Context context = getApplicationContext();
                                Toast.makeText(context, "too long text", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }

    private String trimResult(String s){
        if(((s.endsWith("0") && s.contains(".") ) || s.endsWith(".")) && s.length() > 1){
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

    private boolean isNumeric(String s){
        if(s == null || s.length() == 0) return false;
        try{
            double d = Double.parseDouble(s);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private String evaluateString(String s){
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            ScriptableObject scope = rhino.initStandardObjects();
            String input = "Number(" + s + ").toPrecision()";
            String jsResult = rhino.evaluateString(scope, input, "JavaScript", 1, null).toString();
            if(isHorizontal && jsResult.length() > HORIZONTAL_MAX){
                jsResult = jsResult.substring(0, HORIZONTAL_MAX);
            } else if (jsResult.length() > VERTICAL_MAX) {
                jsResult = jsResult.substring(0, VERTICAL_MAX);
            }
            jsResult = trimResult(jsResult);
            return jsResult;
        } finally {
            Context.exit();
        }
    }
}
