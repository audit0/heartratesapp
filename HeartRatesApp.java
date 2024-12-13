/*
* Most of the code is taken from my assignment 6 submission, particularly the get/set methods
* and the calculation methods.
*/


// Importing javaFX libraries necessary to launch the application
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HeartRatesApp extends Application { //initialize the HeartRatesApp class that will be used in the controller

    // declare the variables necessary
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public HeartRatesApp(int birthMonth, int birthDay, int birthYear){
        // initialize the constructor for all the variables
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public HeartRatesApp(){}

    // Setters that will take in the values when used in the other file and set the variables

    public void setBirthDay(int birthDay){
        this.birthDay = birthDay;
    }
    public void setBirthMonth(int birthMonth){
        this.birthMonth = birthMonth;
    }
    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }


    // getters that will allow for obtaining the variables once defined


    public int getBirthDay(){
        return birthDay;
    }
    public int getBirthMonth(){
        return birthMonth;
    }
    public int getBirthYear(){
        return birthYear;
    }

    // this is random separator text to make it look good lol
    
    public int getAge(){  // getAge method that returns the age of the person
        return 2024 - birthYear;
    }

    public int getMaxHeartRate(){ // obtains the maximum heart rate for someone's age
        return 220 - getAge();
    }

    public String getTargetHeartRateRange(){ // method that utilizes age and multipliers to find out the
        // optimal heart range for an age.
        int maxHeartRate = getMaxHeartRate();
        int lowTarget = (int) (maxHeartRate * 0.5);
        int highTarget = (int)(maxHeartRate * 0.85);

        return  lowTarget + " - " + highTarget + "bpm"; // returns the low end and high end of the heart rate range
    }

    // Start of JavaFX code - creating a "start" class
    @Override
    public void start(Stage stage) throws Exception{ // beginning start class used by javafx to set up the launch
        Parent root = FXMLLoader.load(getClass().getResource("HeartRatesApp.fxml")); // getting the fxml
        Scene scene = new Scene(root); // attaching scene graph to scene
        stage.setTitle("Heart Rates App"); // setting the title of the application
        stage.setScene(scene); // attaching the scene to the stage
        stage.show(); // displaying the scene
    }

    public static void main(String[] args){
        launch(args); // main class that will launch the heartratesapp application
    }
}


/* Citations:Java How To Program, Late Objects
Paul Deitel; Harvey Deitel Chapter 12,13
*/