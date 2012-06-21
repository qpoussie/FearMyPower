package models;

import java.text.SimpleDateFormat;
import java.util.*;

import play.data.format.Formats;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Questionnaire extends Model {
	
	@Id
	public Long id;
	
	@Required
	public String titre;	
	
	@Required
	public String createur;	
	
	@Formats.DateTime(pattern="ddMMyyyy")
	@Required
	public Date debut;
	
	@Formats.DateTime(pattern="ddMMyyyy")
	@Required
	public Date fin;
	
	@Required
	public Long persMax;
	
	public Long persActuel;
	
	//public List<Question> questions;
	
	//public List<Reponse> Reponses;
	
	
	public static Finder<Long,Questionnaire> find = new Finder<Long, Questionnaire>(
			    Long.class, Questionnaire.class
			  );
			  
	public static List<Questionnaire> all() {
		  return find.all();
		}
	
	public static Questionnaire getQuestionnaire(Long idd){
		Questionnaire Questionnaire;
		
		Questionnaire = find.where().eq("id", idd).findUnique();
		
		return Questionnaire;
	}
	
	public static void create(Questionnaire Questionnaire) {
		  Questionnaire.save();
	}

	public static void delete(Long id) {
		  getQuestionnaire(id).delete();
	}
	
	public static String formater(){
	
		//SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMM yyyy", Locale.FRENCH);
		return "toto";//dateFormat.format(d);
	}

    
}
