package com.example.sep3forsoeg5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Comparator;

public class HelloController extends BaseController
{
  @FXML private Button buttonAbout;
  @FXML private Button buttonAdd;

  @FXML private Button buttonEdit;

  @FXML private Button buttonRemove;

  @FXML private TableColumn<Country, String> columnCS;

  @FXML private TableColumn<Country, String> columnCountry;

  @FXML private TableColumn<Country, String> columnMA;

  @FXML private TableView<Country> tableView;

  public void init()
  {
    tableView.setItems(countries);

    columnCountry.setCellValueFactory(
        new PropertyValueFactory<>("countryName"));
    columnMA.setCellValueFactory(
        new PropertyValueFactory<>("marketSize"));
    columnCS.setCellValueFactory(
        new PropertyValueFactory<>("marketGrowth"));
    Comparator<String> columnComparator = (String v1, String v2) -> {

      return v1.toLowerCase().compareTo(v2.toLowerCase());

    };

    columnCountry.setComparator(columnComparator);
    columnCS.setComparator(columnComparator);
    columnMA.setComparator(columnComparator);
    tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
  }


  @FXML void onButtonAddClick()
  {
    appStage.setScene(addNewScene);
  }

  @FXML void onButtonEditClick()
  {

      int index = tableView.getSelectionModel().getSelectedIndex();
      if (index >= 0 && index < countries.size())
      {
        editController.setIndexToEdit(
            tableView.getSelectionModel().getSelectedIndex());
        appStage.setScene(editScene);

    }
  }

  @FXML void onButtonRemoveClick()
  {
    int index = tableView.getSelectionModel().getSelectedIndex();
    if (index >= 0 && index < countries.size())
      countries.remove(index);
  }

  @FXML void onButtonAboutClick()
  {
    appStage.setScene(aboutScene);
  }
}