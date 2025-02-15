package usersTests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.UsersService;
import utils.models.FullUserData;
import utils.models.User;
import utils.readers.JsonReader;

public class UsersTest {
    private UsersService usersService = new UsersService();
    private final String userName = "John";
    private final String userJob = "Manger";
    private final int userAge = 35;
    private final String updatedUserName = "Doe";
    private int id;

    @Test
    public void createUser() {
        User user = User.builder().name(userName).job(userJob).age(userAge).build();
        Response response = usersService.createUser(user);
        Assert.assertEquals(response.statusCode(), 201
                , "incorrect status code");

        User createdUser = response.as(User.class);
        id = createdUser.getId();

        Assert.assertEquals(createdUser.getName(), userName, "Name mismatch");
        Assert.assertEquals(createdUser.getJob(), userJob, "Job mismatch");
        Assert.assertEquals(createdUser.getAge(), userAge, "Age mismatch");
    }

    @Test
    public void updateUser() {
        User user = User.builder().name(updatedUserName).build();
        Response response = usersService.updateUserById(id, user);
        Assert.assertEquals(response.statusCode(), 200
                , "incorrect status code");

        User updatedUser = response.as(User.class);

        Assert.assertEquals(updatedUser.getName(), updatedUser.getName(), "Name mismatch");
    }

    @Test
    public void getUserById() {
        Response response = usersService.getUserById(11);
        Assert.assertEquals(response.statusCode(), 200
                , "incorrect status code");

        FullUserData user = response.as(FullUserData.class);
        FullUserData expectedUser = JsonReader.readJson("src/main/resources/expectedResponses/user11.json"
                , FullUserData.class);

        Assertions.assertThat(user).usingRecursiveComparison().isEqualTo(expectedUser);
    }

    @Test
    public void getUserByInvalidId() {
        Response response = usersService.getUserById(13);
        Assert.assertEquals(response.statusCode(), 404
                , "incorrect status code");
        Assert.assertEquals(response.body().asString(), "{}");
    }

    @Test
    public void deleteUser() {
        Response response = usersService.deleteUser(id);
        Assert.assertEquals(response.statusCode(), 204
                , "incorrect status code");
    }
}
