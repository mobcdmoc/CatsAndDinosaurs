/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.google.gson.Gson;
import data.IDataSource;
import data.SqliteDataSource;
import exceptions.LoadException;
import exceptions.StorageException;
import java.util.ArrayList;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import models.IModel;
import models.ItemModel;

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
    private IDataSource dataStorage;
    private Gson gson ;
    private static final String IdError = "{\"ERROR\":\"Bad Id\"}";
    private static final String SystemError = "{\"ERROR\":\"Internal Servcer Errror. Could Not Fetch Data!\"}";
    private static final String TokenError = "{\"ERROR\":\"Bad Token\"}";
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
        this(new SqliteDataSource(connectionString));
    }
    public PizzaService(IDataSource dataStorage) throws LoadException
    {
        gson = new Gson();
        this.dataStorage = dataStorage;
        dataStorage.load();
    }

    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Order/{id}")
    @Asynchronous
    public void getOrder(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final int id) {
        asyncResponse.resume(doGetOrder(id));
    }
    private String doGetOrder(@PathParam("id") int id) {
        try
        {
            IModel model = (IModel)dataStorage.getOrder(id);
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }

    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Orders")
    @Asynchronous
    public void getOrders(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(doGetOrders());
    }
    private String doGetOrders() {
        try
        {
            IModel model = (IModel)dataStorage.getOrders();
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/User/{id}")
    @Asynchronous
    public void getUser(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final int id) {
        asyncResponse.resume(doGetUser(id));
    }
    private String doGetUser(@PathParam("id") int id) {
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
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/User/{username}/{password}")
    @Asynchronous
    public void getUser(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "username") final String username, @PathParam(value = "password") final String password) {
        asyncResponse.resume(doGetUser(username, password));
    }
    //NOTE: handing the username and password in plain text is technically bad
    //but with the scope of the assignement and the fact that noone will ever
    //put a password they actually use in here it's find for now. 
    private String doGetUser(@PathParam("username") String username, @PathParam("password") String password) {
        if(username == null || password == null)
            return TokenError;
//        String[] tokenSplit = token.split(";");
//        if(tokenSplit.length < 2)
//            return TokenError;
        
        String results = "";
        try
        {
            IModel model = dataStorage.getUser(username, password);
            results = gson.toJson(model);
            
            return results;
        }
        catch(StorageException e)
        {
            //Here we would want to log to a file
            return SystemError;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Item/{id}")
    @Asynchronous
    public void getItem(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final int id) {
        asyncResponse.resume(doGetItem(id));
    }
    private String doGetItem(@PathParam("id") int id) {
        if(id < 1)
            return IdError;
        try
        {
            IModel model = (ItemModel)dataStorage.getItem(id);
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }

    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Items")
    @Asynchronous
    public void getItems(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(doGetItems());
    }
    private String doGetItems() {
        try
        {
            ArrayList<IModel> model = (ArrayList<IModel>)dataStorage.getItems();
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Menu")
    @Asynchronous
    public void getMenu(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(doGetMenu());
    }
    private String doGetMenu() {
        try
        {
            IModel model = (IModel)dataStorage.getMenu();
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }

    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Pizza/{id}")
    @Asynchronous
    public void getPizzaFixins(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final int id) {
        asyncResponse.resume(doGetPizzaFixins(id));
    }
    private String doGetPizzaFixins(@PathParam("id") int id) {
        try
        {
            IModel model = (IModel)dataStorage.getPizzaFixins(id);
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }

    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Toppings")
    @Asynchronous
    public void getToppings(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(doGetToppings());
    }
    private String doGetToppings() {
        try
        {
            ArrayList<IModel> model = (ArrayList<IModel>)dataStorage.getToppings();
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemError;
        }
    }

    @PUT
    @Consumes(value = "application/json")
    @Path(value = "/Save/Employee/")
    @Asynchronous
    public void saveEmployee(@Suspended final AsyncResponse asyncResponse, final String content) {
        doSaveEmployee(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveEmployee(String content) {
    }

    @PUT
    @Consumes(value = "application/json")
    @Path(value = "/Save/Item/")
    @Asynchronous
    public void saveItem(@Suspended final AsyncResponse asyncResponse, final String content) {
        doSaveItem(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveItem(String content) {
    }

    @PUT
    @Consumes(value = "application/json")
    @Path(value = "/Save/Menu/")
    @Asynchronous
    public void saveMenu(@Suspended final AsyncResponse asyncResponse, final String content) {
        doSaveMenu(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveMenu(String content) {
    }

    @PUT
    @Consumes(value = "application/json")
    @Path(value = "/Save/Order/")
    @Asynchronous
    public void saveOrder(@Suspended final AsyncResponse asyncResponse, final String content) {
        doSaveOrder(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveOrder(String content) {
    }

    @PUT
    @Consumes(value = "application/json")
    @Path(value = "/Save/Pizza/")
    @Asynchronous
    public void savePizza(@Suspended final AsyncResponse asyncResponse, final String content) {
        doSavePizza(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSavePizza(String content) {
    }

    @PUT
    @Consumes(value = "application/json")
    @Path(value = "/Save/User/")
    @Asynchronous
    public void saveUser(@Suspended final AsyncResponse asyncResponse, final String content) {
        doSaveUser(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveUser(String content) {
    }
}
