package JavaFXApplication;

import Business.Student;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * Juan Rodriguez 
 * Lab 10
 * Java 2
 * 4-3-2021
 */
public class JavaFXApplication extends Application implements EventHandler<ActionEvent> {
    
        Button fBtn = new Button("Find");
        Button iBtn = new Button("Insert");
        Button dBtn = new Button("Delete");
        Button uBtn = new Button("Update");
        Button eBtn = new Button("Exit");
        Label titleLabel = new Label("Student Information");
        Label idLabel = new Label("ID");
        Label firstNameLabel = new Label("First Name");
        Label lastNameLabel = new Label("Last Name");
        Label emailLabel = new Label("Email");
        Label gpaLabel = new Label("GPA");
        TextField txtID = new TextField();
        TextField txtFirstName = new TextField();
        TextField txtLastName = new TextField();
        TextField txtEmail = new TextField();
        TextField txtGPA = new TextField();
        
    
    public void start(Stage primaryStage) {

        fBtn.setOnAction(this);
        iBtn.setOnAction(this);
        dBtn.setOnAction(this);
        uBtn.setOnAction(this);
        eBtn.setOnAction(this);
        
        FlowPane fPanTitle = new FlowPane();
        fPanTitle.getChildren().add(titleLabel);
        titleLabel.getStyleClass().add("titleFont");
        
        GridPane gridInfo = new GridPane();
        gridInfo.add(idLabel, 2, 1, 1, 1);
        gridInfo.add(txtID,5,1,1,1);
        gridInfo.add(firstNameLabel, 2, 2, 1, 1);
        gridInfo.add(txtFirstName,5,2,1,1);
        gridInfo.add(lastNameLabel, 2, 3, 1, 1);
        gridInfo.add(txtLastName,5,3,1,1);
        gridInfo.add(emailLabel, 2, 4, 1, 1);
        gridInfo.add(txtEmail,5,4,1,1);
        gridInfo.add(gpaLabel, 2, 5, 1, 1);
        gridInfo.add(txtGPA,5,5,1,1);
        
        gridInfo.setHgap(10);
        gridInfo.setVgap(8);
        
        FlowPane fPan = new FlowPane();
        fPan.getChildren().add(fBtn);
        fPan.getChildren().add(iBtn);
        fPan.getChildren().add(dBtn);
        fPan.getChildren().add(uBtn);
        fPan.getChildren().add(eBtn);
        
        fPan.setHgap(15);
        
        BorderPane bPan = new BorderPane();
        bPan.setTop(fPanTitle);
        bPan.setCenter(gridInfo);
        bPan.setBottom(fPan);
        
        Scene scene = new Scene(bPan, 350, 250);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.setTitle("Student Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
      
    public void handle(ActionEvent ae){
    if (ae.getSource() == fBtn){
       String  id = txtID.getText();
        Student s1 = new Student();
        s1.selectDB(Integer.parseInt(id));
        s1.Display();
        txtFirstName.setText(s1.getFirstName());
        txtLastName.setText(s1.getLastName());
        txtEmail.setText(s1.getEmail());
        txtGPA.setText(s1.getGpa()+"");
        
    System.out.println("Find button clicked");
    }
    if (ae.getSource() == iBtn){
       String id = txtID.getText();
       String firstName = txtFirstName.getText();
       String lastName = txtLastName.getText();
       String email = txtEmail.getText();
       String Gpa = txtGPA.getText();
      
       Student s2 = new Student();
       s2.insertDB(Integer.parseInt(id), firstName, lastName,"123 Main street", "Atlanta", "GA", "30100" , email, Double.parseDouble(Gpa));
       s2.Display();
      
    System.out.println("Insert button clicked");
    }
    if (ae.getSource() == dBtn){
        String  id = txtID.getText();
        Student s3 = new Student();
        s3.selectDB(Integer.parseInt(id));
        s3.deleteDB();
        s3.Display();
        
    System.out.println("Delete button was clicked");
    }
    if (ae.getSource() == uBtn){
        String id = txtID.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String Gpa = txtGPA.getText();
        Student s4 = new Student();
        
       
        
        s4.selectDB(Integer.parseInt(id));
        s4.setFirstName(firstName);
        s4.setLastName(lastName);
        s4.setEmail(email);
        s4.setGpa(Double.parseDouble(Gpa));
        
        s4.updateDB();
        
    System.out.println("Update button was clicked");
    }
    if (ae.getSource() == eBtn){
    boolean result = ConfirmBox.display("Confirmation ", "Do you want to exit application?");
    
    System.out.println(result);
    }
    }

    
    

// Is displayed when user hits exit button
    private static class ConfirmBox {

            static boolean answer;
    
    public static boolean display(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label label = new Label();
        label.setText(message);
        
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        
        yesBtn.setOnAction(e-> {
            answer = true;
            window.close();
            System.exit(0);
        });
        
        noBtn.setOnAction(e-> {
            answer = false;
            window.close();
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesBtn, noBtn);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }
   
    }
    
      public static void main(String args[]) {
        launch(args);
    
}


    
}
