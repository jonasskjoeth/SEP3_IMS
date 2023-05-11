package com.example.sep3forsoeg5;

  import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseController
{
  protected Stage appStage;
  protected Scene normalScene;
  protected Scene addNewScene;
  protected Scene editScene;
  protected Scene aboutScene;
  protected EditController editController;
  protected AboutController aboutController;


  public void setAboutScene(Scene aboutScene)
  {
    this.aboutScene = aboutScene;
  }

  public void setAboutController(AboutController aboutController)
  {
    this.aboutController = aboutController;
  }
  public void setEditController(EditController editController)
  {
    this.editController = editController;
  }
  public void setEditScene(Scene editScene)
  {
    this.editScene = editScene;
  }
  public void setAddNewScene(Scene addNewScene)
  {
    this.addNewScene = addNewScene;
  }

  public void setAppStage(Stage appStage)
  {
    this.appStage = appStage;
  }

  public void setNormalScene(Scene normalScene)
  {
    this.normalScene = normalScene;
  }

  protected ObservableList<Country> countries;

  public void setCountries(ObservableList<Country> countries)
  {
    this.countries = countries;
  }
}
