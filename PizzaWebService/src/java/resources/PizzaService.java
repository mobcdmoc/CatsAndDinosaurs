/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.google.gson.Gson;
import data.DataContext;
import data.SqliteDataSource;
import exceptions.LoadException;
import exceptions.StorageException;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import models.IModel;

/**
 * REST Web Service
 *
 * @author Jacob
 */
@Stateless
@Path("PizzaService")
public class PizzaService {

    @Context
    private UriInfo context;
    private DataContext dataStorage;
    private Gson gson ;
    private static final String IdError = "{\"ERROR\":\"Bad Id\"}";
    private static final String SystemError = "{\"ERROR\":\"Internal Servcer Errror. Could Not Fetch Data!\"}";
    /*
    Normally we would actually want to read this in from a config file, but
    in the interest of time we're just going to hard code it for now.
    */
    private static final String connectionString = "jdbc:sqlite:../resources/PizzaDb.db"; //"jdbc:sqlite:resources/PizzaDb.db";
    /**
     * Creates a new instance of GeneralServiceResource
     * @throws exceptions.LoadException
     */
    public PizzaService() throws LoadException {
        gson = new Gson();
        dataStorage = new DataContext(new SqliteDataSource(connectionString));
        dataStorage.load();
    }

    /**
     * Retrieves representation of an instance of User
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/User/{id}")
    public String getUser(@PathParam("id") int id) {
        
        if(id < 1)
            return IdError;
        String results = "";
        try
        {
            IModel model = dataStorage.getUser(id);
            results = gson.toJson(model);
        
            return results;
        }
        catch(StorageException e)
        {
            //Here we would want to log to a file
            return SystemError;
        }
    }
    /**
     * Retrieves representation of an instance of Item
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/Item/{id}")
    public String getItem(@PathParam("id") int id) {
        if(id < 1)
            return IdError;
        try
        {
            IModel model = dataStorage.getItem(id);
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }
    /**
     * Retrieves representation of a collection of items
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/Items")
    public String getItems() {
        return "{\"cat\":\"dog\"}";
    }
    /**
     * Retrieves representation of a menu
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/Menu")
    public String getMenu() {
        return "{\"cat\":\"dog\"}";
    }
    /**
     * Retrieves representation of an order
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/Order/{id}")
    public String getOrder(@PathParam("id") int id) {
        return "{\"cat\":\"dog\"}";
    }
    /**
     * Retrieves representation of a Pizza
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/Pizza/{id}")
    public String getPizza(@PathParam("id") int id) {
        return "{\"cat\":\"dog\"}";
    }
    /**
     * Retrieves representation of all available valid toppings
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/Get/Toppings")
    public String getToppings() {
        return "{\"cat\":\"dog\"}";
    }
   
    /**
     * PUT method for updating or creating an instance of PizzaServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/Save/Employee/")
    public void saveEmployee(String content) {
    }
    
    /**
     * PUT method for updating or creating an instance of PizzaServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/Save/Item/")
    public void saveItem(String content) {
    }
    
    /**
     * PUT method for updating or creating an instance of PizzaServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/Save/Menu/")
    public void saveMenu(String content) {
    }
    
    /**
     * PUT method for updating or creating an instance of PizzaServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/Save/Order/")
    public void saveOrder(String content) {
    }
    
    /**
     * PUT method for updating or creating an instance of PizzaServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/Save/Pizza/")
    public void savePizza(String content) {
    }
    
    /**
     * PUT method for updating or creating an instance of PizzaServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/Save/User/")
    public void saveUser(String content) {
    }
}
