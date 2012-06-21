package models;

import java.util.*;

import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.validation.Constraints.*;

import javax.persistence.*;


public interface Question {
	
    public List<Question> all();
    
    /**
     * recherche par id
     */
	public  Question getQuestion(Long idd);
	
    /**
     * enregistrer en BDD
     */
	public void create(Question question);
	
    /**
     * supprimer par id
     */
	public void delete(Long id);
    
    // --
	public String getIntitule(Question question);

}
