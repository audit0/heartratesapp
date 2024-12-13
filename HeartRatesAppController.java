/**
 * Sample Skeleton for 'HeartRatesApp.fxml' Controller Class gained from the fxml
 * Final Project Assignment made by Ari!
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class HeartRatesAppController {

    @FXML // fx:id="birthdayTextField"
    private TextField birthdayTextField; // Value injected by FXMLLoader

    @FXML // fx:id="mhrTextField"
    private TextField mhrTextField; // Value injected by FXMLLoader

    @FXML // fx:id="calculateButton"
    private Button calculateButton; // Value injected by FXMLLoader

    @FXML // fx:id="ageTextField"
    private TextField ageTextField; // Value injected by FXMLLoader

    @FXML // fx:id="thrTextField"
    private TextField thrTextField; // Value injected by FXMLLoader

    @FXML
    void onCalculateButtonClicked(ActionEvent event) {
        String birthdayInput = birthdayTextField.getText(); // get the text from the text field

        try{
            String[] birthdayDMY = birthdayInput.split("/"); // store all elements into an array, 
            //separating the m,d, and y. elements will be the month, day and the year, so length should be 3

            if (birthdayDMY.length != 3){
                throw new IllegalArgumentException("incorrect format, use mm/dd/yyyy");
            } // Check to make sure user isnt just putting random numbers or something else, or characters, etc.

            // Converting the strings of month day and year to integers, and storing them accordingly.
            int month = Integer.parseInt(birthdayDMY[0]);
            int day = Integer.parseInt(birthdayDMY[1]);
            int year = Integer.parseInt(birthdayDMY[2]);

            // Checking for incorrect date components like 0 or negative numbers, 
            // and larger days than exist in a month. Also checks for anyone using age > historical maximum (122)
            if (month > 12 || month < 1 || day < 1 || day > 31 || year <= 1901){
                throw new IllegalArgumentException("invalid date components");
            }

            // instance an object from heartratesapp that uses the values we got for m,d,and y
            HeartRatesApp user = new HeartRatesApp(month,day,year);
            // When you don't have birth date information (e.g., for default values):
            HeartRatesApp defaultUser = new HeartRatesApp();
            // Assign variables to the age, maximum heart rate, and the target heart rate
            int age = user.getAge();
            int maxheartrate = user.getMaxHeartRate();
            String targetheartrate = user.getTargetHeartRateRange();

            // Show the variables as the results on button press, 
            ageTextField.setText(String.valueOf(age));
            mhrTextField.setText(String.valueOf(maxheartrate));
            thrTextField.setText(targetheartrate);


        } catch (Exception err){ // Catch and handle the invalid inputs like using a character instead of number, etc.
            ageTextField.setText("invalid format");
            mhrTextField.setText("or invalid");
            thrTextField.setText("date components");
        }
    }
}

/* Citations:Java How To Program, Late Objects
Paul Deitel; Harvey Deitel Chapter 12,13
*/
