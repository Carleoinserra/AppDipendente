package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class DipendenteJDBCTemp {
    
	
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    public int insertDipendente(String nome ,String cognome, String mansione) {
        String query = "INSERT INTO dip (nome, cognome, mansione) VALUES (?, ?, ?)";
        return jdbcTemplateObject.update(query, nome, cognome, mansione);
    }

    public int updateCognome(String vecchioCognome, String cognome) {
        String query = "UPDATE dip SET cognome = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, cognome, vecchioCognome);
    }

    public int updateMansione(int id, String mansione) {
        String query = "UPDATE Dipendente SET mansione = ? WHERE id = ?";
        return jdbcTemplateObject.update(query, mansione, id);
    }

    public int updateNome(String nome, String cognome) {
        String query = "UPDATE dip SET nome = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, nome, cognome);
    }

    public int deleteDipendente(int id) {
        String query = "DELETE FROM Dipendente WHERE id = ?";
        return jdbcTemplateObject.update(query, id);
    }
    
    public ArrayList<Dipendente> ritornaDip(){
    	ResultSet rs1 = null;
    	
    	
            String query = "SELECT * FROM dip";
            return jdbcTemplateObject.query(query, new ResultSetExtractor<ArrayList<Dipendente>>() {
                @Override
                public ArrayList<Dipendente> extractData(ResultSet rs) throws SQLException {
                	ArrayList <Dipendente> listaDip = new ArrayList<>();
                    while (rs.next()) {
                        Dipendente dipendente = new Dipendente();
                       
                        dipendente.setNome(rs.getString("nome"));
                        dipendente.setCognome(rs.getString("cognome"));
                        dipendente.setMansione(rs.getString("mansione"));
                        
                        listaDip.add(dipendente);
                    }
                    return listaDip;
                }
            });
        }
    	
    	
    	
    	
    	
    	
    

    // Metodo per eseguire query DDL
    public void executeDDLQuery(String query) {
        jdbcTemplateObject.execute(query);
    }
}
