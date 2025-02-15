package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.models.User;

public class UsersService extends BaseService {

    public UsersService() {
        RestAssured.baseURI = configReader.getProperty("baseUri");

    }

    public Response createUser(User user) {
        return postRequest(configReader.getProperty("createUserEndpoint"), user);
    }

    public Response getUserById(int id) {
        return getRequest(configReader.getProperty("getUserEndpoint"), id);
    }

    public Response updateUserById(int id, User user) {
        return putRequest(configReader.getProperty("updateUserEndpoint"), id, user);

    }

    public Response deleteUser(int id) {
        return deleteRequest(configReader.getProperty("deleteUserEndpoint"), id);
    }
}
