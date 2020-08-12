import com.github.javafaker.Faker;
import com.twitter.developer.clients.UserClient;
import com.twitter.developer.data.DataGenerator;

public class TestBaseClass {

    protected UserClient userClient = new UserClient();
    protected Faker faker = new Faker();
    protected DataGenerator dataGenerator = new DataGenerator();

}
