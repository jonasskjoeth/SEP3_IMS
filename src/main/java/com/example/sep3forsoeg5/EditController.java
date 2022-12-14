package com.example.sep3forsoeg5;

import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.swing.*;

public class EditController extends BaseController
{

  @FXML private Button addEditCancelBtn;

  @FXML private Button addEditDoneBtn;

  @FXML private TextField competitiveSituationEdit;

  @FXML private TextField countryNameEdit;

  @FXML private TextField culturalDifferenceEdit;

  @FXML private TextField currentMarketShareEdit;

  @FXML private TextField economicStabilityEdit;

  @FXML private TextField inflationEdit;

  @FXML private TextField marketGrowthEdit;

  @FXML private TextField marketSizeEdit;

  @FXML private TextField needOfProductEdit;

  @FXML private TextField politicalStabilityEdit;

  @FXML private TextField productsFitEdit;

  @FXML private TextField uniquenessOfProductEdit;

  private int indexToEdit;

  public void setIndexToEdit(int index)
  {
    indexToEdit = index;
    countryNameEdit.setText(countries.get(index).getCountryName());
    marketSizeEdit.setText(String.valueOf(countries.get(index).getMarketSize()));
    marketGrowthEdit.setText(String.valueOf(countries.get(index).getMarketGrowth()));
    competitiveSituationEdit.setText(String.valueOf(countries.get(index).getCompetitiveSituation()));
    economicStabilityEdit.setText(String.valueOf(countries.get(index).getEconomicStability()));
    politicalStabilityEdit.setText(String.valueOf(countries.get(index).getPoliticalStability()));
    inflationEdit.setText(String.valueOf(countries.get(index).getInflation()));
    culturalDifferenceEdit.setText(String.valueOf(countries.get(index).getCulturalDifference()));
    currentMarketShareEdit.setText(String.valueOf(countries.get(index).getCurrentMarketShare()));
    productsFitEdit.setText(String.valueOf(countries.get(index).getProductsFit()));
    uniquenessOfProductEdit.setText(String.valueOf(countries.get(index).getUniquenessOfProduct()));
    needOfProductEdit.setText(String.valueOf(countries.get(index).getNeedOfProduct()));
  }

  @FXML void onEditCancelButtonClick(ActionEvent event)
  {
    appStage.setScene(normalScene);
  }

  @FXML void onEditDoneButtonClick(ActionEvent event)
  {
    if  (countryNameEdit.getText().length() < 1
        || marketSizeEdit.getText().length() < 1
        || competitiveSituationEdit.getText().length() < 1
        || politicalStabilityEdit.getText().length() < 1
        || economicStabilityEdit.getText().length() < 1
        || inflationEdit.getText().length() < 1
        || culturalDifferenceEdit.getText().length() < 1
        || currentMarketShareEdit.getText().length() < 1
        || productsFitEdit.getText().length() < 1
        || uniquenessOfProductEdit.getText().length() < 1
        || marketGrowthEdit.getText().length() < 1
        || needOfProductEdit.getText().length() < 1)
    {
      JOptionPane.showMessageDialog(null,
          "All fields must be filled out before continuing!",
          "An error occurred", JOptionPane.ERROR_MESSAGE);
      return;
    }
    int scoreMAEdit = ((Integer.parseInt(marketSizeEdit.getText())
        + Integer.parseInt(marketGrowthEdit.getText())
        + Integer.parseInt(economicStabilityEdit.getText())
        + Integer.parseInt(politicalStabilityEdit.getText())
        + Integer.parseInt(inflationEdit.getText())
        + Integer.parseInt(culturalDifferenceEdit.getText())
        + Integer.parseInt(competitiveSituationEdit.getText())
          ) / 7);

    int scoreCSEdit = ((Integer.parseInt(currentMarketShareEdit.getText())
        + Integer.parseInt(productsFitEdit.getText())
        + Integer.parseInt(uniquenessOfProductEdit.getText())
        + Integer.parseInt(needOfProductEdit.getText())
          ) / 4);

    countries.get(indexToEdit).setCountryName(countryNameEdit.getText());
    countries.get(indexToEdit).setMarketSize(Integer.parseInt(marketSizeEdit.getText()));
    countries.get(indexToEdit).setMarketGrowth(Integer.parseInt(marketGrowthEdit.getText()));
    countries.get(indexToEdit).setCompetitiveSituation((Integer.parseInt(competitiveSituationEdit.getText())));
    countries.get(indexToEdit).setEconomicStability((Integer.parseInt(economicStabilityEdit.getText())));
    countries.get(indexToEdit).setPoliticalStability((Integer.parseInt(economicStabilityEdit.getText())));
    countries.get(indexToEdit).setInflation((Integer.parseInt(inflationEdit.getText())));
    countries.get(indexToEdit).setCulturalDifference((Integer.parseInt(culturalDifferenceEdit.getText())));
    countries.get(indexToEdit).setCurrentMarketShare((Integer.parseInt(currentMarketShareEdit.getText())));
    countries.get(indexToEdit).setProductsFit((Integer.parseInt(productsFitEdit.getText())));
    countries.get(indexToEdit).setUniquenessOfProduct((Integer.parseInt(uniquenessOfProductEdit.getText())));
    countries.get(indexToEdit).setNeedOfProduct((Integer.parseInt(needOfProductEdit.getText())));

    appStage.setScene(normalScene);
  }
}
