package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entidades.Department;
import model.servicos.DepartmentService;

public class DepartmentListController implements Initializable {

    private DepartmentService servico;

    @FXML
    private Button btn_Novo;

    @FXML
    private TableView<Department> tb_ViewDepartamento;

    @FXML
    private TableColumn<Department, Integer> tb_ColunaId;

    @FXML
    private TableColumn<Department, String> tb_ColunaNome;

    private ObservableList<Department> obsList;

    @FXML
    public void onbtn_NovoAction() {
        System.out.println("Botão Novo");
    }

    public void setDepartmentService(DepartmentService servico) {
        this.servico = servico;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarNodes();
    }

    private void inicializarNodes() {
        tb_ColunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_ColunaNome.setCellValueFactory(new PropertyValueFactory<>("name"));
    }
    
    public void updateTableView(){
        if(servico == null){
            throw  new IllegalStateException("Serviço esta nulo");
        }
        List<Department> lista = servico.finAll();
        obsList = FXCollections.observableArrayList(lista);
        tb_ViewDepartamento.setItems(obsList);
    }

}
