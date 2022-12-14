package com.example.sep3forsoeg5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.swing.*;

import javafx.event.EventHandler;

public class AddNewController extends BaseController
{
  @FXML private Button addNewDoneBtn;

  @FXML private TextField countryName;

  @FXML private TextField competitiveSituation;

  @FXML private TextField culturalDifference;

  @FXML private TextField currentMarketShare;

  @FXML private TextField economicStability;

  @FXML private TextField inflation;

  @FXML private TextField marketGrowth;

  @FXML private TextField marketSize;

  @FXML private TextField needOfProduct;

  @FXML private TextField politicalStability;

  @FXML private TextField productsFit;

  @FXML private TextField uniquenessOfProduct;

  private void clearFields()
  {
    countryName.clear();
    marketSize.clear();
    competitiveSituation.clear();
    politicalStability.clear();
    economicStability.clear();
    inflation.clear();
    culturalDifference.clear();
    currentMarketShare.clear();
    productsFit.clear();
    uniquenessOfProduct.clear();
    marketGrowth.clear();
    needOfProduct.clear();
  }

  @FXML void onAddNewDoneButtonClick()
  {
    if (countryName.getText().length() < 1
        || marketSize.getText().length() < 1
        || competitiveSituation.getText().length() < 1
        || politicalStability.getText().length() < 1
        || economicStability.getText().length() < 1
        || inflation.getText().length() < 1
        || culturalDifference.getText().length() < 1
        || currentMarketShare.getText().length() < 1
        || productsFit.getText().length() < 1
        || uniquenessOfProduct.getText().length() < 1
        || marketGrowth.getText().length() < 1
        || needOfProduct.getText().length() < 1)
    {
      JOptionPane.showMessageDialog(null,
          "All fields must be filled out before continuing!",
          "An error occurred", JOptionPane.ERROR_MESSAGE);
      return;
    }

    {
      int scoreMA = ((Integer.parseInt(marketSize.getText())
          + Integer.parseInt(marketGrowth.getText())
          + Integer.parseInt(economicStability.getText())
          + Integer.parseInt(politicalStability.getText())
          + Integer.parseInt(inflation.getText())
          + Integer.parseInt(culturalDifference.getText())
          + Integer.parseInt(competitiveSituation.getText())
            ) / 7);

      int scoreCS = ((Integer.parseInt(currentMarketShare.getText())
          + Integer.parseInt(productsFit.getText())
          + Integer.parseInt(uniquenessOfProduct.getText())
          + Integer.parseInt(needOfProduct.getText())
            ) / 4);


      countries.add(new Country(countryName.getText(),scoreMA, scoreCS,
          Integer.parseInt(competitiveSituation.getText()),
          Integer.parseInt(economicStability.getText()),
          Integer.parseInt(politicalStability.getText()),
          Integer.parseInt(inflation.getText()),
          Integer.parseInt(culturalDifference.getText()),
          Integer.parseInt(currentMarketShare.getText()),
          Integer.parseInt(productsFit.getText()),
          Integer.parseInt(uniquenessOfProduct.getText()),
          Integer.parseInt(needOfProduct.getText())
            ));
      clearFields();
      appStage.setScene(normalScene);
    }
  }

  @FXML public void onAddNewCancelButtonClick()
  {
    clearFields();
    appStage.setScene(normalScene);
  }
}
