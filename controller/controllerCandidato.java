package controller;

import candidatoDao.candidatoDao;
import model.candidato;

public class controllerCandidato {

	public int cadastrar(String nome, String cpf, String cargo) {
		candidato dao = new candidato(nome, cpf, cargo);
		candidatoDao cDao=new candidatoDao();
		return(cDao.create(dao));
		
	}
	
}
