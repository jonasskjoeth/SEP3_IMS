package com.example.sep3forsoeg5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;



public class AboutController extends BaseController
{

  @FXML
  private Button buttonBack;

  @FXML void onButtonBackClick(ActionEvent event)
  {
    appStage.setScene(normalScene);
  }

}
