/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxcalculatorsimulation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * COMP 2243-31-Assignment 12
 * @author Jian Wang
 * 
 *  Additional thinking: 
 * if there is no input space and more than one operators
 * input at the same time, I try to use stack to solve it
 * comment these codes.
 * 
 */
public class CalculatorSimulationFXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textField;
    
    @FXML
    private void handleOneButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("1");
        } else {
            String left = textField.getText();
            textField.setText(left + "1");
        }
    }
    
    @FXML
    private void handleTwoButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("2");
        } else {
            String left = textField.getText();
            textField.setText(left + "2");
        }
    }
    
    @FXML
    private void handleThreeButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("3");
        } else {
            String left = textField.getText();
            textField.setText(left + "3");
        }
    }
    
    @FXML
    private void handleFourButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("4");
        } else {
            String left = textField.getText();
            textField.setText(left + "4");
        }
    }
    
    @FXML
    private void handleFiveButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("5");
        } else {
            String left = textField.getText();
            textField.setText(left + "5");
        }
    }
    
    @FXML
    private void handleSixButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("6");
        } else {
            String left = textField.getText();
            textField.setText(left + "6");
        }
    }
    
    @FXML
    private void handleSevenButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("7");
        } else {
            String left = textField.getText();
            textField.setText(left + "7");
        }
    }
    
    @FXML
    private void handleEightButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("8");
        } else {
            String left = textField.getText();
            textField.setText(left + "8");
        }
    }
    
    @FXML
    private void handleNineButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("9");
        } else {
            String left = textField.getText();
            textField.setText(left + "9");
        }
    }
    
    @FXML
    private void handleZeroButtonAction(ActionEvent event) {
        if(textField.getText().equals("")) {
            textField.appendText("0");
        } else {
            String left = textField.getText();
            textField.setText(left + "0");
        }
    }
    
    @FXML
    private void handleDotButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")) {
            String left = textField.getText();
            textField.setText(left + ".");
        }
    }
    
    @FXML
    private void handlePlusButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")) {
            String left = textField.getText();
            textField.setText(left + " + ");
        }
    }
    
    @FXML
    private void handleMinusButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")) {
            String left = textField.getText();
            textField.setText(left + " - ");
        }
    }
    
    @FXML
    private void handleDivideButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")) {
            String left = textField.getText();
            textField.setText(left + " / ");
        }
    }
    
    @FXML
    private void handleMutiplyButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")) {
            String left = textField.getText();
            textField.setText(left + " * ");
        }
    }
    
    @FXML
    private void handleEqualButtonAction(ActionEvent event) {
        String res = textField.getText();
        int first = res.indexOf(" ");
        int last = first + 2;
        double front = Double.parseDouble(res.substring(0, first));
        double second = Double.parseDouble(res.substring(last + 1));
        char op = res.charAt(first + 1);
        
        double result = 0;
        if(op == '+') {
            result = front + second;
        }
        if(op == '-') {
            result = front - second;
        }
        
        if(op == '*') {
            result = front * second;
        }
        
        if(op == '/') {
            result = front / second;
        }
        
        textField.setText("" + result);
    }
            // if there is no space input
            // try stack to solve the problem
            // if user input +,-,*,/ at the same time;
            
//        char operator = '+';
//        double n = 0;
//        double m = 0;
//        double exp = 10;
//        Stack<Double> stack = new Stack<>();
//
//        for(int i = 0; i < res.length(); i++) {
//            if(Character.isDigit(res.charAt(i))) {
//                if(exp == 10) n = n * exp + res.charAt(i) - '0';
//                else m = m + (res.charAt(i) - '0') * exp; exp /= 10;
//            } 
//            
//            if(res.charAt(i) == '.') {
//                exp = 0.1;
//            } 
//            
//            if(!Character.isDigit(res.charAt(i)) && res.charAt(i) != '.' || i == res.length() - 1){
//                double r = n + m;
//                if(operator == '+') stack.push(r); 
//                if(operator == '-') stack.push(-r);
//                if(operator == '*') stack.push(stack.pop() * r);
//                if(operator == '/') stack.push(stack.pop() / r);
//                operator = res.charAt(i);
//                n = 0;
//                m = 0;
//                exp = 10;
//            }
//        }
//        
//        double sum = 0;
//        while(!stack.isEmpty()) {sum += stack.pop();}
//        displayField.setText("" + sum); 
//        
//    }
    
    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        textField.setText("");
    }
    
    @FXML
    private void handleCEButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")) {
            String left = textField.getText();
            left = left.substring(0, left.length() - 1);
            textField.setText(left);
        }
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
