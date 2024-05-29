package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;




// dichiariamo una classe semplice con annotazione controller

@Controller
public class MyController {

	
	 private final DipendenteJDBCTemp dipendenteJDBCTemp;

	    @Autowired
	    public MyController(DipendenteJDBCTemp dipendenteJDBCTemp) {
	        this.dipendenteJDBCTemp = dipendenteJDBCTemp;
	    }
	
	
// mappiamo i metodi con get mapping per indicare quelli che saranno i percorsi dell'applicazione
	
	
	 
	 
	 @GetMapping("/")
	 public String getDip(){
		
		 return "formDip";
		 
	 }
	 
	 @GetMapping("/getDip")
	 public String getAll(Model model){
		
		 ArrayList <Dipendente> lista = dipendenteJDBCTemp.ritornaDip();
		 model.addAttribute("lista", lista);
		 
		 return "getDip";
		 
	 }
	 
	 @PostMapping("/AddDip")
	 public String addDip(@RequestParam("fname") String nome,@RequestParam("lname") String cognome, @RequestParam("mansioni") String mansione, Model model) {
		 
		 Dipendente d1 = new Dipendente();
		 d1.setNome(nome);
		 d1.setCognome(cognome);
		 d1.setMansione(mansione);
		 
		 model.addAttribute("dip", d1);
		 dipendenteJDBCTemp.insertDipendente(nome, cognome, mansione);
		 return "dipendente";
	 }
	 
	 @PostMapping("/CambiaCognome")
	 public String cambiaCognome(@RequestParam("lname") String cognome,@RequestParam("Oldlname") String Oldcognome, Model model) {
		 System.out.println(Oldcognome);
		 System.out.println(cognome);
		 dipendenteJDBCTemp.updateCognome(Oldcognome, cognome);
		 model.addAttribute("old" , Oldcognome);
		 model.addAttribute("newC", cognome);
		 
		 
		 return "ChangeCognome";
		 
	 }
	 @PostMapping("/CambiaNome")
	 public String cambiaNome(@RequestParam("lname") String cognome,@RequestParam("fname") String nome, Model model) {
	
		 dipendenteJDBCTemp.updateNome(nome, cognome);
		 model.addAttribute("nome" , nome);
		 model.addAttribute("cognome", cognome);
		 
		 
		 return "changeNome";
		 
	 }
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
