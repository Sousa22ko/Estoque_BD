package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.LojaDao;
import model.Loja;
import model.Pergunta;
import util.LoggedUser;

public class LojaServices {

	public static LojaDao lojaDao = new LojaDao(); 
	public static Loja loja;
	
	public static LojaDao getDao() {
		return lojaDao;
	}
	
	public static void adicionar(Pergunta remote){
		lojaDao.adicionar(remote); 	
	}
	
	public static void atualizar(Pergunta remote){
		lojaDao.atualizar(remote); 	
	}
	
	public static Pergunta getPerguntaById(Long id){
		return lojaDao.getPerguntaById(id);
	}

	public static Pergunta randomPerg() {
		
		return lojaDao.getPerguntaById(new Random().nextInt(lojaDao.getList().size()-1)+1);
	}
	
	public static List<Pergunta> listandoPerguntas(long idUser){
		List<Pergunta> listTotal = new ArrayList<Pergunta>();
		List<Pergunta> listaPergs = new ArrayList<Pergunta>();
		listTotal = lojaDao.getList();
		//System.out.println("TAMANHO ANTES:"+listTotal.size());
		for(int i=0; i<listTotal.size(); i++){
			if(listTotal.get(i).getIdUser() == idUser){
				listaPergs.add(listTotal.get(i)); // inserindo na lista o ID da pergunta cadastrada pelo usuário idUser
			}
		}
		/*System.out.println("TAMANHO:"+listaPergs.size());
		for(int i=0; i<listaPergs.size(); i++){
			System.out.println("TAMANHO:"+listaPergs.get(i));
		}*/
		return listaPergs;
	}
	
	public static void populandoPergunta(int n){
		
		List<Pergunta> listPerg = new ArrayList<Pergunta>();
		Pergunta nova;
		int correta;
		
		for(int i=lojaDao.getList().size()+1, j=0; i< n+lojaDao.getList().size()+1 || j<100;i++, j++){
			//createPerguntaAdd("Pergunta ID"+i, "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", new Random().nextInt(4)+1);
			
			correta = new Random().nextInt(4)+1;
			
			nova = new Pergunta();
			
			nova.setPergunta("Pergunta ID"+i);
			
			if(correta == 1){
				nova.setAlternativa1("CORRETA");
				nova.setAlternativa2("Alternativa 2");
				nova.setAlternativa3("Alternativa 3");
				nova.setAlternativa4("Alternativa 4");
				
				nova.setCorreta("alternativa1");
				
			} else if(correta == 2){
				nova.setAlternativa1("Alternativa 1");
				nova.setAlternativa2("CORRETA");
				nova.setAlternativa3("Alternativa 3");
				nova.setAlternativa4("Alternativa 4");
				
				nova.setCorreta("alternativa2");
				
			} else if(correta == 3){
				nova.setAlternativa1("Alternativa 1");
				nova.setAlternativa2("Alternativa 2");
				nova.setAlternativa3("CORRETA");
				nova.setAlternativa4("Alternativa 4");
				
				nova.setCorreta("alternativa3");
				
			} else if(correta == 4){
				nova.setAlternativa1("Alternativa 1");
				nova.setAlternativa2("Alternativa 2");
				nova.setAlternativa3("Alternativa 3");
				nova.setAlternativa4("CORRETA");
				
				nova.setCorreta("alternativa4");
				
			} else
				System.out.println("DEU ERRO NEGADA");
			
			nova.setIdUser(LoggedUser.getLoggedUser().getId());
			listPerg.add(nova); //adicionando a pergunta na lista de perguntas
			lojaDao.adicionar(listPerg.get(j)); //inserindo a pergunta[j] no banco de dados
			
			if(j<100)
				nova = null;
			else
				break;
			
			System.out.println("Tamanho do array: "+listPerg.size());
			System.out.println("valor de I: "+i);
			System.out.println("Valor de J: "+j);
		}
	}
}