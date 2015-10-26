/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.LoadException;
import exceptions.StorageException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.ObservableList;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import models.IModel;
import models.ItemModel;
import models.UserModel;

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
    private static final String BASE_URI = "http://localhost:8080/PizzaWebService/webresources";

    public PizzaServiceClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("PizzaService");
    }
    
    public void saveItem(IModel requestEntity) throws ClientErrorException {
        webTarget.path("Save/Item").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void saveOrder(IModel requestEntity) throws ClientErrorException {
        webTarget.path("Save/Order").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getUser(Class<T> responseType, String username, String password) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/User/{0}/{1}", new Object[]{username, password}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void saveEmployee(IModel requestEntity) throws ClientErrorException {
        webTarget.path("Save/Employee").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getItem(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/Item/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Get/Orders");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void saveMenu(IModel requestEntity) throws ClientErrorException {
        webTarget.path("Save/Menu").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getItems(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Get/Items");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getOrder(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("Get/Order/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getMenu(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Get/Menu");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void saveUser(IModel requestEntity) throws ClientErrorException {
        webTarget.path("Save/User").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }

    
    
    
    @Override
    public void load() throws LoadException {
        
    }
    
    @Override
    public IModel getEmployee(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getItem(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<IModel> getItems() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getMenu() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getOrder(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<IModel> getOrders() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel getUser(int id) throws StorageException {
//        return getUser(UserModel.class, id);
        return null;
    }

    @Override
    public IModel getUser(String userName, String password) {
        return getUser(UserModel.class,userName,password);
    }    

    @Override
    public ObservableList<IModel> getEmployees() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<IModel> getOrders(int id) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<IModel> getUsers() throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveEmployees(Collection<IModel> models) throws StorageException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
