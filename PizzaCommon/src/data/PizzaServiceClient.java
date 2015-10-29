/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import exceptions.LoadException;
import exceptions.StorageException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import models.*;

/**
 * Jersey REST client generated for REST resource:PizzaService
 * [PizzaService]<br>
 * USAGE:
 * <pre>
 *        PizzaServiceClient client = new PizzaServiceClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Jacob
 */
public class PizzaServiceClient implements IDataSource {
    private WebTarget webTarget;
    private Client client;
    private Gson gson;
    private static final String BASE_URI = "http://localhost:8080/PizzaWebService/webresources";

    public PizzaServiceClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("PizzaService");
        gson = new Gson();
    }
    
    @Override
    public void saveItem(IModel requestEntity) throws ClientErrorException, StorageException {
        webTarget.path("Save/Item").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(gson.toJson(requestEntity), javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    @Override
    public void saveOrder(IModel requestEntity) throws ClientErrorException, StorageException {
        webTarget.path("Save/Order").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    @Override
    public UserModel getUser(int id) throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/User/{0}", new Object[]{id}));
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        return gson.fromJson(json, UserModel.class);
    }
    
    @Override
    public UserModel getUser(String username, String password) throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/User/{0}/{1}", new Object[]{username, password}));
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        if(json == null)
        {
            UserModel m = new UserModel();
            m.setId(-1);
            return m;
        }
        return gson.fromJson(json, UserModel.class);
    }

    @Override
    public ArrayList<IModel> getUsers() throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path("Get/Users");
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        ArrayList<IModel> models = gson.fromJson(resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class), new TypeToken<ArrayList<UserModel>>(){}.getType());
        return models;
    } 
    
//    @Override
//    public void saveEmployee(IModel requestEntity) throws ClientErrorException, StorageException {
//        webTarget.path("Save/Employee").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }

    @Override
    public ItemModel getItem(int id) throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/Item/{0}", new Object[]{id}));
        
        String json =  resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        ItemModel model = gson.fromJson(json, ItemModel.class);
        return model;
    }

    @Override
    public ArrayList<IModel> getOrders() throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path("Get/Orders");
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        ArrayList<IModel> models = gson.fromJson(json, new TypeToken<ArrayList<OrderModel>>(){}.getType());
        return models;
    }

    @Override
    public ArrayList<IModel> getOrders(int id) throws StorageException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/Orders/{0}",new Object[] {id}));
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        ArrayList<IModel> models = gson.fromJson(json, new TypeToken<ArrayList<OrderModel>>(){}.getType());
        return models;
    }
    @Override
    public void saveMenu(IModel requestEntity) throws ClientErrorException, StorageException {
        MenuModel m = (MenuModel)requestEntity;
        String json = gson.toJson(m.getItems());
        
        webTarget.path("Save/Menu").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(json, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    @Override
    public ArrayList<IModel> getItems() throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path("Get/Items");
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        ArrayList<IModel> models = gson.fromJson(json, new TypeToken<ArrayList<ItemModel>>(){}.getType());
        return models;
    }

    @Override
    public OrderModel getOrder(int id) throws ClientErrorException, StorageException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/Order/{0}", new Object[]{id}));
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        return gson.fromJson(json, OrderModel.class);
    }

    @Override
    public MenuModel getMenu() throws ClientErrorException, StorageException {
        
        ArrayList<IModel> items = getItems();
        MenuModel rtn = new MenuModel();
        rtn.setItems(items);
        return rtn;
    }

    @Override
    public void saveUser(IModel requestEntity) throws ClientErrorException, StorageException {
        webTarget.path("Save/User").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }
    
    @Override
    public void load() throws LoadException {
        
    }

//    @Override
//    public IModel getEmployee(int id) throws ClientErrorException, StorageException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("Get/Employee/{0}", new Object[]{id}));
//        
//        String json =  resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
//        EmployeeModel model = gson.fromJson(json, EmployeeModel.class);
//        return model;
//    }

    @Override
    public void savePayment(IModel requestEntity) throws ClientErrorException, StorageException {
        webTarget.path("Save/Payment").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

}
