/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.util.restricoes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entidades.Department;

/**
 *
 * @author cado_
 */
public class DepartmentFormController implements Initializable {

    private Department entity;

    @FXML
    private TextField txt_Id;

    @FXML
    private TextField txt_Nome;

    @FXML
    private Label lb_Error;

    @FXML
    private Button btn_Salvar;

    @FXML
    private Button btn_Cancelar;

    @FXML
    public void onbtn_Salvar() {
        System.out.println("Salvar");
    }

    public void setDepartment(Department entity) {
        this.entity = entity;
    }

    @FXML
    public void onbtn_cancelar() {
        System.out.println("Cancelar");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        restricoes.setTextFieldInteger(txt_Id);
        restricoes.setTextFieldMaxLength(txt_Id, 30);
    }

    public void updateFormData() {
        if (entity == null) {
            throw new IllegalStateException("Entidade esta nulo");
        }
        txt_Id.setText(String.valueOf(entity.getId()));
        txt_Nome.setText(entity.getName());
    }

}
