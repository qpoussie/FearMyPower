package models;

import java.util.*;

import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Utilisateur extends Model {

	@Id
	public Long id;
	
	@Required
    public String nom;
	
	@Required
    public String pass;
	
    
	public static Finder<Long,Utilisateur> find = new Finder<Long, Utilisateur>(
		    Long.class, Utilisateur.class
		  );
    
    /**
     * Tout les utilisateurs.
     */
    public static List<Utilisateur> all() {
        return find.all();
    }
    
    /**
     * recherche pas id
     */
	public static Utilisateur getUtilisateur(Long idd){
		return find.ref(idd);

	}
	
    /**
     * enregistrer en BDD
     */
	public static void create(Utilisateur utilisateur) {
		  utilisateur.save();
	}
	
    /**
     * supprimer par id
     */
	public static void delete(Long id) {
		  getUtilisateur(id).delete();
	}
    
    // --
	  public String getNom() {
	        return nom ;
	    }
	  public String getPass() {
	        return pass;
	    }

    public String toString() {
        return getNom() + " - " + getPass();
    }
    
    public static List<String> list() {
        List<String> liste = new ArrayList<String>();
        for(Utilisateur u :all()){
        	liste.add(u.getNom());
        }
        return liste;
    }
}