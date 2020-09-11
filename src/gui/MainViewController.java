package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

     @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSeller() {
        System.out.println("Seller");
    }
    
      @FXML
    public void onMenuItemDepartment() {
          System.out.println("Department");
    }
    
      @FXML
    public void onMenuItemAbout() {
          System.out.println("About");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {

    }

}
