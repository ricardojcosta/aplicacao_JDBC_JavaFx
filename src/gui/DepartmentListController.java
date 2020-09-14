package gui;

import gui.util.Alertas;
import gui.util.utils;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    public void onbtn_NovoAction(ActionEvent evento) {
        Stage parentStage = utils.palcoAtual(evento);
        Department obj = new Department();
        createDialogForm(obj,"/gui/DepartmentForm.fxml", parentStage);
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
    
    private void createDialogForm (Department obj, String nomeabsoluto, Stage parentStage){
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeabsoluto)); 
           Pane painel = loader.load();
           
           DepartmentFormController controller = loader.getController();
           controller.setDepartment(obj);
           controller.updateFormData();
           
           Stage dialogStage = new Stage();
           dialogStage.setTitle("Dados Departamento");
           dialogStage.setScene(new Scene(painel));
           dialogStage.setResizable(false);
           dialogStage.initOwner(parentStage);
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.showAndWait();       
           
        }catch (IOException e){
            Alertas.showAlerta("Erro de entrada", "Erro carregar view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
