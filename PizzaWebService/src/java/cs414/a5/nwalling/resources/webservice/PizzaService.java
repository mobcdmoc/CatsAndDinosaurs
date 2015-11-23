/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.resources.webservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.data.IModelFactory;
import cs414.a5.nwalling.common.data.ModelFactory;
import cs414.a5.nwalling.common.data.SqliteDataSource;
import cs414.a5.nwalling.common.exceptions.LoadException;
import cs414.a5.nwalling.common.exceptions.StorageException;
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
import javax.ws.rs.POST;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import cs414.a5.nwalling.common.models.IItemModel;
import cs414.a5.nwalling.common.models.IMenuModel;
import cs414.a5.nwalling.common.models.IModel;
import cs414.a5.nwalling.common.models.IOrderModel;
import cs414.a5.nwalling.common.models.IPaymentModel;
import cs414.a5.nwalling.common.models.IUserModel;
import cs414.a5.nwalling.common.models.ItemModel;
import cs414.a5.nwalling.common.models.MenuModel;
import cs414.a5.nwalling.common.models.OrderModel;
import cs414.a5.nwalling.common.models.PaymentModel;
import cs414.a5.nwalling.common.models.UserModel;

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
    private static final String SystemErrorGet = "{\"ERROR\":\"Internal Service Errror. Could Not Fetch Data!\"}";
    private static final String TokenError = "{\"ERROR\":\"Bad Token\"}";
    private static final String SystemErrorSave = "{\"ERROR\":\"Internal Service Errror. Could Not Save Data!\"}";
    /*
    Normally we would actually want to read this in from a config file, but
    in the interest of time we're just going to hard code it for now.
    */
    private static final String connectionString = "jdbc:sqlite:../resources/PizzaDb.db"; //"jdbc:sqlite:resources/PizzaDb.db";
    private IModelFactory mf;
    /**
     * Creates a new instance of GeneralServiceResource
     * @throws cs414.a5.nwalling.common.exceptions.LoadException
     */
    public PizzaService() throws LoadException {
        this(new SqliteDataSource(connectionString));
    }
    public PizzaService(IDataSource dataStorage) throws LoadException
    {
        gson = new Gson();
        this.dataStorage = dataStorage;
        mf = new ModelFactory(dataStorage);
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
            return SystemErrorGet;
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
            ArrayList<IOrderModel> model = dataStorage.getOrders();
            
            if(model.size() <1)
                return null;
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemErrorGet;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Orders/{id}")
    @Asynchronous
    public void getOrders(@Suspended final AsyncResponse asyncResponse, @PathParam(value="id") int id) {
        asyncResponse.resume(doGetOrders(id));
    }
    private String doGetOrders(@PathParam(value="id") int id) {
        try
        {
            ArrayList<IOrderModel> model = dataStorage.getOrders(id);
            if(model.size() <1)
                return null;
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemErrorGet;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/OrderItems/{id}")
    @Asynchronous
    public void getOrderItems(@Suspended final AsyncResponse asyncResponse, @PathParam(value="id") int id) {
        asyncResponse.resume(doGetOrderItems(id));
    }
    private String doGetOrderItems(@PathParam(value="id") int id) {
        try
        {
            ArrayList<IItemModel> model = dataStorage.getOrderItems(id);
            if(model.size() <1)
                return null;
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemErrorGet;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/OrderItems")
    @Asynchronous
    public void getOrderItems(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(doGetOrderItems());
    }
    private String doGetOrderItems() {
        try
        {
            ArrayList<IItemModel> model = dataStorage.getOrderItems();
            if(model.size() <1)
                return null;
            String results = gson.toJson(model);
            return results;
        }
        catch(StorageException e)
        {
            //Do logging here
            return SystemErrorGet;
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
            return SystemErrorGet;
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
            return SystemErrorGet;
        }
    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Users")
    @Asynchronous
    public void getUsers(@Suspended final AsyncResponse asyncResponse) throws StorageException {
        asyncResponse.resume(doGetUsers());
    }
    private String doGetUsers() throws StorageException {
        String results = "";

        ArrayList<IUserModel> model = dataStorage.getUsers();
        results = gson.toJson(model);

        return results;

    }
    
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Item/{id}")
    @Asynchronous
    public void getItem(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final int id) throws StorageException {
        asyncResponse.resume(doGetItem(id));
    }
    private String doGetItem(@PathParam("id") int id) throws StorageException {
        if(id < 1)
            return IdError;

        IItemModel model = (IItemModel)dataStorage.getItem(id);
        String results = gson.toJson(model);
        return results;

    }

    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Items")
    @Asynchronous
    public void getItems(@Suspended final AsyncResponse asyncResponse) throws StorageException {
        asyncResponse.resume(doGetItems());
    }
    private String doGetItems() throws StorageException {

            ArrayList<IItemModel> model = dataStorage.getItems();
            String results = gson.toJson(model);
            return results;

    }
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "/Get/Menu")
    @Asynchronous
    public void getMenu(@Suspended final AsyncResponse asyncResponse) throws StorageException {
        asyncResponse.resume(doGetMenu());
    }
    private String doGetMenu() throws StorageException {

            IModel model = (IModel)dataStorage.getMenu();
            String results = gson.toJson(model);
            return results;

    }

//    @PUT
//    @Consumes(value = "application/json")
//    @Path(value = "/Save/Employee/")
//    @Asynchronous
//    public void saveEmployee(@Suspended final AsyncResponse asyncResponse, final String content) {
//        doSaveEmployee(content);
//        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
//    }
//    private void doSaveEmployee(String content) {
//        try
//        {
//            
//        IModel model = gson.fromJson(content, EmployeeModel.class);
//        dataStorage.saveEmployee(model);
//        }
//        catch(StorageException e)
//        {
//            //eat it for now?
//        }
//    }
//
//    @PUT
//    @Consumes(value = "application/json")
//    @Path(value = "/Save/Employees/")
//    @Asynchronous
//    public void saveEmployees(@Suspended final AsyncResponse asyncResponse, final String content) {
//        doSaveEmployees(content);
//        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
//    }
//    private void doSaveEmployees(String content) {
//        try
//        {
//            
//        ObservableList<IModel> models = gson.fromJson(content, ObservableList.class);
//        dataStorage.saveEmployees(models);
//        }
//        catch(StorageException e)
//        {
//            //eat it for now?
//        }
//    }

    
    @POST
    @Consumes(value = "application/json")
    @Path(value = "/Save/Item/")
    @Asynchronous
    public void saveItem(@Suspended final AsyncResponse asyncResponse, final String content) throws StorageException {
        doSaveItem(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveItem(String content) throws StorageException {
    
            IItemModel model = gson.fromJson(content, ItemModel.class);
            dataStorage.saveItem(model);
        
    }

    @POST
    @Consumes(value = "application/json")
    @Path(value = "/Save/Menu/")
    @Asynchronous
    public void saveMenu(@Suspended final AsyncResponse asyncResponse, final String content) throws StorageException {
        doSaveMenu(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveMenu(String content) throws StorageException {

            ArrayList<IMenuModel> models = gson.fromJson(content, new TypeToken<ArrayList<ItemModel>>(){}.getType());
            IMenuModel model = mf.getEmptyIMenuModel();
//            model.setItems(models);
            dataStorage.saveMenu(model);

    }

    @POST
    @Consumes(value = "application/json")
    @Path(value = "/Save/Order/")
    @Asynchronous
    public void saveOrder(@Suspended final AsyncResponse asyncResponse, final String content) throws StorageException {
        doSaveOrder(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveOrder(String content) throws StorageException {
        IOrderModel model = gson.fromJson(content, OrderModel.class);
        dataStorage.saveOrder(model);
    }

    @POST
    @Consumes(value = "application/json")
    @Path(value = "/Save/User/")
    @Asynchronous
    public void saveUser(@Suspended final AsyncResponse asyncResponse, final String content) throws StorageException {
        doSaveUser(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSaveUser(String content) throws StorageException {
        
            IUserModel model = gson.fromJson(content, UserModel.class);
            dataStorage.saveUser(model);
       
    }
    
    @POST
    @Consumes(value = "application/json")
    @Path(value = "/Save/Payment/")
    @Asynchronous
    public void savePayment(@Suspended final AsyncResponse asyncResponse, final String content) throws StorageException {
        doSavePayment(content);
        asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
    }
    private void doSavePayment(String content) throws StorageException {
        
            IPaymentModel model = gson.fromJson(content, PaymentModel.class);
            dataStorage.savePayment(model);
    }
    
}
