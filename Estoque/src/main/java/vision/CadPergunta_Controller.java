package vision;

import java.io.UnsupportedEncodingException;

import Services.LojaServices;
import dao.LojaDao;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Pergunta;
import sources.ScreenConstants;
import util.LoggedUser;
import util.SharedInfo;
import util.ScreenLibrary;

public class CadPergunta_Controller {

	
	@FXML
	private Label error;
	
	@FXML
	private TextField pergunta;
	
	@FXML
	private TextField alt1;
	
	@FXML 
	private TextField alt2;
	
	@FXML
	private TextField alt3;
	
	@FXML
	private TextField alt4;
	
	@FXML
	private ChoiceBox<String> correta = new ChoiceBox<String>();

	@FXML
	private Pane background;
	
	@FXML
	private Pane logo;
	
	private long idPerguntaRecebida = 0;
	
	private boolean update = false;
	
	@FXML
	public void initialize() {
		correta.getItems().addAll("Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4");
		idPerguntaRecebida = SharedInfo.getId();
		
		if(idPerguntaRecebida != -1){
			update = true;
			
			Pergunta recebida = LojaServices.getPerguntaById(idPerguntaRecebida);
			
			pergunta.setText(recebida.getPergunta());
			alt1.setText(recebida.getAlternativa1());
			alt2.setText(recebida.getAlternativa2());
			alt3.setText(recebida.getAlternativa3());
			alt4.setText(recebida.getAlternativa4());
			
		}
	}
	
	@FXML
	public void handlerPreencheCB(){
	}
	
	@FXML
	public void handlerCadastrarPergunta(){
		
		Pergunta nova = new Pergunta();
		
		nova.setPergunta(pergunta.getText());
		nova.setAlternativa1(alt1.getText());
		nova.setAlternativa2(alt2.getText());
		nova.setAlternativa3(alt3.getText());
		nova.setAlternativa4(alt4.getText());
		
		if(correta.getValue() == "Alternativa 1"){
			nova.setCorreta("alternativa1");
		} else if(correta.getValue() == "Alternativa 2"){
			nova.setCorreta("alternativa2");
		} else if(correta.getValue() == "Alternativa 3"){
			nova.setCorreta("alternativa3");
		} else if(correta.getValue() == "Alternativa 4"){
			nova.setCorreta("alternativa4");
		} else
			System.out.println("DEU ERRO NEGADA");
		
		//nova.setCorreta(correta.getValue());
		nova.setIdUser(LoggedUser.getLoggedUser().getId());

		
		if(update == false)
			LojaServices.adicionar(nova);
		else
			LojaServices.atualizar(nova);
		
		try {
			ScreenLibrary.LoadTela(ScreenConstants.IDHOME);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
	}
	
	@FXML
	public void handlerAtualizarPergunta(){
		
		Pergunta nova = new Pergunta();
		LojaDao pd = new LojaDao();
		
		nova.setPergunta(pergunta.getText());
		nova.setAlternativa1(alt1.getText());
		nova.setAlternativa2(alt2.getText());
		nova.setAlternativa3(alt3.getText());
		nova.setAlternativa4(alt4.getText());
		
		if(correta.getValue() == "Alternativa 1"){
			nova.setCorreta("alternativa1");
		} else if(correta.getValue() == "Alternativa 2"){
			nova.setCorreta("alternativa2");
		} else if(correta.getValue() == "Alternativa 3"){
			nova.setCorreta("alternativa3");
		} else if(correta.getValue() == "Alternativa 4"){
			nova.setCorreta("alternativa4");
		} else
			System.out.println("DEU ERRO NEGADA");
		
		//nova.setCorreta(correta.getValue());
		nova.setIdUser(LoggedUser.getLoggedUser().getId());

		
		pd.atualizar(nova);
		
		
		try {
			ScreenLibrary.LoadTela(ScreenConstants.IDHOME);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
	}
	
	@FXML
	public void handlerVoltar(){
		try {
			ScreenLibrary.LoadTela(ScreenConstants.IDHOME);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void recebeIdPergunta(long id){
		idPerguntaRecebida = id;
		System.out.println("ESTAMOS RECEBENDO NO CONTROLLER COM O ID: "+idPerguntaRecebida);
		/*try {
			ScreenLibrary.LoadTela(ScreenConstants.IDCADPERG);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
	}
	
}
