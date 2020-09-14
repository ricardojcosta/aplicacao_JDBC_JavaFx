package gui;

import gui.util.Alertas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.servicos.DepartmentService;

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
        carregarView2("/gui/DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemAbout() {
        carregarView("/gui/About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void carregarView(String nomeabsoluto) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeabsoluto));
            VBox novoVbox = loader.load();

            Scene mainScene = aplicacao_jdbc_javafx.Aplicacao_JDBC_JavaFx.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(novoVbox.getChildren());
        } catch (IOException e) {
            Alertas.showAlerta("Erro entrada", "Erro carregar tela", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void carregarView2(String nomeabsoluto) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeabsoluto));
            VBox novoVbox = loader.load();

            Scene mainScene = aplicacao_jdbc_javafx.Aplicacao_JDBC_JavaFx.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(novoVbox.getChildren());

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();

        } catch (IOException e) {
            Alertas.showAlerta("Erro entrada", "Erro carregar tela", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
