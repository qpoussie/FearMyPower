package controllers;

import controllers.routes;

import play.libs.Json.*;
import play.mvc.*;

import play.*;

import play.data.*;

import models.*;
import views.html.*;

import static play.libs.Json.toJson;
import org.codehaus.jackson.JsonNode;

public class Application extends Controller {	
	static Form<Questionnaire> QuestionnaireForm = form(Questionnaire.class);
	static Form<Utilisateur> utilisateurForm = form(Utilisateur.class);

	  public static Result index() {
		  return redirect("/consult");
	  }
	  /*
	   *  	QUESTIONNAIRE
	   */
	  public static Result consultQuestionnaire() {
		  return ok(
				  views.html.consult.render(Questionnaire.all(), QuestionnaireForm)
				  );
	  }
	  
	  public static Result creation() {
		  return ok(
				  views.html.index.render(Questionnaire.all(), QuestionnaireForm, Utilisateur.all())
				  );
	  }
	  
	  public static Result newQuestionnaire(){
		  Form<Questionnaire> filledForm = QuestionnaireForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		    		views.html.index.render(Questionnaire.all(), filledForm, Utilisateur.all())
		    		);
		 } else {
		    Questionnaire.create(filledForm.get());
		    return ok(views.html.consult.render(Questionnaire.all(), QuestionnaireForm));  
		}
	  }
	  
	  @BodyParser.Of(BodyParser.Json.class)
	  public static Result deleteQuestionnaire(){
		  JsonNode json = request().body().asJson();
		  String idStr = json.findPath("id").getTextValue();
		  Long id = Long.valueOf(idStr);
		  Questionnaire.delete(id);
		  //return ok(views.html.consult.render(Questionnaire.all(), QuestionnaireForm));
		  return ok();
	  }
	  
	  /*
	   *  	UTILISATEUR
	   */
	  public static Result getAdmin() {
		  return ok(
				  views.html.admin.render(Utilisateur.all(), utilisateurForm)
				  );
	  }
	  
	  public static Result createUser(){
		  Form<Utilisateur> filledForm = utilisateurForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		    		views.html.admin.render(Utilisateur.all(), filledForm)
		    		);
		 } else {
		    Utilisateur.create(filledForm.get());
		    return ok(views.html.admin.render(Utilisateur.all(), utilisateurForm));  
		}
	  }
	  
	  @BodyParser.Of(BodyParser.Json.class)
	  public static Result deleteUser(){
			  JsonNode json = request().body().asJson();
			  String idStr = json.findPath("idUser").getTextValue();
			  Long id = Long.valueOf(idStr);
			  Utilisateur.delete(id);
			  //return ok(views.html.consult.render(Questionnaire.all(), QuestionnaireForm));
			  return ok();
	}
	  
}