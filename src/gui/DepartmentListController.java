package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entidades.Department;

public class DepartmentListController implements Initializable {

    @FXML
    private Button btn_Novo;

    @FXML
    private TableView<Department> tb_ViewDepartamento;

    @FXML
    private TableColumn<Department, Integer> tb_ColunaId;

    @FXML
    private TableColumn<Department, String> tb_ColunaNome;

    @FXML
    public void onbtn_NovoAction() {
        System.out.println("Botão Novo");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicilaizarNodes();
    }

    private void inicilaizarNodes() {
        tb_ColunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_ColunaNome.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

}
