package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Statement;
import com.sun.corba.se.pept.transport.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable{

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfPrenom;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfTelephone;

    @FXML
    private TextField tfSpecialite;

    @FXML
    private TableView<Etudiant> tvEtudient;

    @FXML
    private TableColumn<Etudiant, Integer> columID;

    @FXML
    private TableColumn<Etudiant, String> columNom;

    @FXML
    private TableColumn<Etudiant, String> columPrenom;

    @FXML
    private TableColumn<Etudiant, String> columEmail;

    @FXML
    private TableColumn<Etudiant, String> columTelephone;

    @FXML
    private TableColumn<Etudiant, String>columSpecialite;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnInsert;

    @FXML
    void btnaction(ActionEvent event) {
//    	 if(event.getSource() == btnInsert){
//             insertRecord();
//         }else if (event.getSource() == btnUpdate){
//             updateRecord();
//         }else if(event.getSource() == btnDelete){
//             deleteButton();
//         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showEtudiant();
}
    public Connection getConnection(){
        Connection conn;
        try{
        	conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/teest ", "root", "");            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    public ObservableList<Etudiant> getEtudiantsList(){
        ObservableList<Etudiant> etudiantList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM Etudiant";
        Statement<?, ?> st;
        ResultSet rs;
        
        try{
            st = (Statement<?, ?>) ((java.sql.Connection) conn).createStatement();
            rs = ((java.sql.Statement) st).executeQuery(query);
            Etudiant Etudiant;
            while(rs.next()){
            	Etudiant = new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getString("telephone"),rs.getString("specialite"));
            	etudiantList.add(Etudiant);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return etudiantList;
    }
   
	private void showEtudiant() {
		 ObservableList<Etudiant> list = getEtudiantsList();
		 columID.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("id"));
		 columNom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
		 columPrenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenom"));
		 columEmail.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("email"));
		 columTelephone.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("telephone"));
		 columSpecialite.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("specialite"));
		 
		 tvEtudient.setItems(list);
	}
   
}
