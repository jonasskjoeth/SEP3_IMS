package com.example.sep3forsoeg5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;

public class ApplicationIMS extends Application
{
  ObservableList<Country> countries = FXCollections.observableArrayList();

  private final String filename = "countrylist.dat";

  @Override public void init()
  {
    try
    {
      countries = FXCollections.observableArrayList();
      FileInputStream fstream = new FileInputStream(filename);
      ObjectInputStream inputFile = new ObjectInputStream(fstream);
      boolean endOfFile = false;
      while (!endOfFile)
      {
        try
        {
          Country country = (Country) inputFile.readObject();
          countries.add(country);
        }
        catch (EOFException e)
        {
          endOfFile = true;
        }
      }
    }
    catch (FileNotFoundException e)
    {
      countries = FXCollections.observableArrayList();
    }
    catch (IOException | ClassNotFoundException e)
    {
      JOptionPane.showMessageDialog(null, "Could not read data file",
          "An error occurred", JOptionPane.ERROR_MESSAGE);
      Platform.exit();
    }
  }









  @Override public void start(Stage stage) throws IOException
  {
    FXMLLoader fxmlLoader1 = new FXMLLoader(
        ApplicationIMS.class.getResource("hello-view.fxml"));
    Scene scene1 = new Scene(fxmlLoader1.load(), 1100, 400);
HelloController helloController = (HelloController) fxmlLoader1.getController();

    FXMLLoader fxmlLoader2 = new FXMLLoader(
        ApplicationIMS.class.getResource("add-new.fxml"));
    Scene scene2 = new Scene(fxmlLoader2.load(), 1100, 400);
    AddNewController addNewController = (AddNewController) fxmlLoader2.getController();

    FXMLLoader fxmlLoader3 = new FXMLLoader(
        ApplicationIMS.class.getResource("edit-view.fxml"));
    Scene scene3 = new Scene(fxmlLoader3.load(), 1100, 400);
    EditController editController = (EditController) fxmlLoader3.getController();

    FXMLLoader fxmlLoader4 = new FXMLLoader(
        ApplicationIMS.class.getResource("about-view.fxml"));
    Scene scene4 = new Scene(fxmlLoader4.load(), 1100, 400);
    AboutController aboutController = (AboutController) fxmlLoader4.getController();

    helloController.setCountries(countries);
    helloController.setAppStage(stage);
    helloController.setNormalScene(scene1);
    helloController.setEditScene(scene3);
    helloController.setAddNewScene(scene2);
    helloController.setAboutScene(scene4);
    helloController.init();

    addNewController.setCountries(countries);
    addNewController.setAppStage(stage);
    addNewController.setNormalScene(scene1);
    addNewController.setAddNewScene(scene2);

    editController.setCountries(countries);
    editController.setNormalScene(scene1);
    editController.setAppStage(stage);

    aboutController.setCountries(countries);
    aboutController.setAppStage(stage);
    aboutController.setAboutScene(scene4);
    aboutController.setNormalScene(scene1);

    helloController.setEditController(editController);

    // add icon for toolbar as well as top-left icon
    Image image = new Image("C:\\Users\\jonas\\IdeaProjects\\SEP3forsoeg5\\src\\main\\resources\\com\\example\\sep3forsoeg5\\icon.png");
    stage.getIcons().add(image);

    // set stage
    stage.setTitle("IMS Application");
    stage.setScene(scene1);
    stage.setResizable(false);
    stage.show();
  }



  @Override public void stop()
  {
    try
    {
      FileOutputStream fstream = new FileOutputStream(filename);
      ObjectOutputStream outputFile = new ObjectOutputStream(fstream);
      for (Country country : countries)
        outputFile.writeObject(country);
    }
    catch (IOException e)
    {
      JOptionPane.showMessageDialog(null, "Could not write data file",
          "An error occurred", JOptionPane.ERROR_MESSAGE);
    }
  }



  public static void main(String[] args)
  {
    launch();
  }
}