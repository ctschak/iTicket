package controllers;

import java.io.File;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        //return ok(index.render("Your new application is ready."));
    	return ok(index.render());
    }
    
    public static Result clientAsset() {
    	File file = Play.application().getFile("/client/index.html");
    	return ok(file);
    }

}
