package br.ufrn.imd.controle;

import java.util.Date;

import br.ufrn.imd.dao.Banco;
import br.ufrn.imd.dao.FuncionariosDAO;
import br.ufrn.imd.modelo.Tratador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroTratadorController {
	
	private Stage tratador;
	private boolean btnCadastrarClicked = false;
	
	FuncionariosDAO bc;

	
	 @FXML
	    private TextField tId;

	    @FXML
	    private TextField tNome;

	    @FXML
	    private TextField tCpf;

	    @FXML
	    private TextField tIdade;

	    @FXML
	    private TextField tSangue;

	    @FXML
	    private TextField tRh;

	    @FXML
	    private TextField tEspecialidade;

	    @FXML
	    private TextField tNSeguran�a;

	
    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnSair;
    
    
    public boolean isBtnCadastrarClicked() {
		return btnCadastrarClicked;
	}

	public void setBtnCadastrarClicked(boolean btnCadastrarClicked) {
		this.btnCadastrarClicked = btnCadastrarClicked;
	} 

    @FXML
    void cadastrarTratador(ActionEvent event) {
    	
    	btnCadastrarClicked = true;
    	
    	if (btnCadastrarClicked){
    		// Pegar os dados de Cliente
    		bc = FuncionariosDAO.getInstance();
    		
    		// buscando �ltimo cliente
    		int cod = bc.buscaCodigoCliente();
    		cod++;
    		
    		// setar atributos Cliente
    		Cliente c = new Cliente();
    		c.setIdCliente(cod);
    		
    		c.setNomeCliente(tfNomeCliente.getText());
    		
    		c.setCpf(tfCPFCliente.getText());
    		
    		// pegar a data do DatePicker
    		Date data = new Date(dtPickerDtNasCliente.getValue().toEpochDay());
    		c.setDataNascimento(data);
    		
    		// persistir dados
    		bc.inserirCliente(c);
    	}
    	clienteStage.close();

    }

    @FXML
    void fecharApp(ActionEvent event) {
    	tratador.close();
    }
	public void setClienteStage(Stage tratadorStage) {
		this.tratador = tratadorStage;
		
	}

}
