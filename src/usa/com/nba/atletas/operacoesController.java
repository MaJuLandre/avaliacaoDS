package usa.com.nba.atletas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class operacoesController {
	
	@FXML
	private Button buttoncad;
	//
	@FXML
	private TextField textfieldnom;
	
	@FXML
	private TextField textfieldsob;
	
	@FXML
	private TextField textfieldida;
	
	@FXML
	private TextField textfieldpos;
	
	@FXML
	private TextField textfielequ;
	
	
	
	@FXML
	public void cadastrarJogador(ActionEvent event) {
	     String sql = "INSERT INTO jogador (nome, sobrenome, equipe, posicao, idade) VALUES (?, ?, ?, ?, ?)";
	     try (Connection conexao = Conexao.conectar();
	    		  PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	         pstmt.setString(1, textfieldnom.getText());
	         pstmt.setString(2, textfieldsob.getText());
	         pstmt.setString(5, textfieldida.getText());
	         pstmt.setString(4, textfieldpos.getText());
	         pstmt.setString(3, textfielequ.getText());
	         pstmt.executeUpdate();

	         Alert alert = new Alert(AlertType.INFORMATION);
	         alert.setTitle("Cadastro realizado..");
	         alert.setHeaderText(null);
	         alert.setContentText("Jogador cadastrado.");
	         alert.showAndWait();
	         
	     } catch (SQLException e) {
	         e.printStackTrace();
	         
	         Alert alert = new Alert(AlertType.ERROR);
	         alert.setTitle("Erro no cadastro");
	         alert.setHeaderText(null);
	         alert.setContentText("Ocorreu um erro ao cadastrar o jogador: " + e.getMessage());
	         alert.showAndWait();
	     }
}
}
	

