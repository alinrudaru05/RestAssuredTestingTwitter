import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;




public class UpdateStatusTest extends TestBaseClass {


    @Test
    public void shouldUpdateMyStatusWithAGivenStringGivenMyUser() {
        //GIVEN
        String status = faker.harryPotter().character();

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }


     @Test
    public void shouldUpdateMyStatusWithALongNumberGivenMyUser() {
        //GIVEN
        Long status = faker.number().randomNumber();

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void shouldUpdateMyStatusWithTheBiggerLongNumberGivenMyUser() {
        //GIVEN
        Long status = Long.MAX_VALUE;
        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void shouldUpdateMyStatusWithTheSmallestLongNumberGivenMyUser() {
        //GIVEN
        Long status = Long.MIN_VALUE;
        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void shouldUpdateMyStatusWithADoubleNumberGivenMyUser() {
        //GIVEN
        Double status = faker.number().randomDouble(2, Long.MIN_VALUE, Long.MAX_VALUE);

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void shouldUpdateMyStatusWithTheBiggerDoubleNumberGivenMyUser() {
        //GIVEN
        Double status = Double.MAX_VALUE;
        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void shouldUpdateMyStatusWithTheSmallestDoubleNumberGivenMyUser() {
        //GIVEN
        Double status = Double.MIN_VALUE;
        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void shouldUpdateMyStatusWithZeroValueGivenMyUser() {
        //GIVEN
        Integer status = 0;

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void shouldFailToUpdateMyStatusWithANullValueGivenMyUser() {
        //GIVEN
        String status = null;

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }




    @Test
    public void shouldFailToUpdateMyStatusWithASpaceGivenMyUser() {
        //GIVEN
        String status = " ";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }


    @Test
    public void shouldFailToUpdateMyStatusWithMoreSpacesGivenMyUser() {
        //GIVEN
        String status = dataGenerator.generateAStringWithNSpaces(12);

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }


    @Test
    public void shouldFailToUpdateMyStatusWithABigStringGivenMyUser() {
        //GIVEN
        String status = dataGenerator.generateAStringWithNCharacters(500);

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }


    @Test
    public void shouldFailToUpdateMyStatusWithAnEmptyStringGivenMyUser() {
        //GIVEN
        String status = "";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }


    @Test
    public void shouldUpdateMyStatusWithASpecialCharacterThatWasNotAnOldAStatusGivenMyUser() {
        //GIVEN

        //OBS: Aici ar fi trebuit sa fac o metoda care sa faca get
        //si sa retin intr-o lista sau stream toate statusurile de un caracter
        //si sa-mi fac o metoda in data generator care genereaza un caracter
        //si sa compar rezultatul metodei cu statusurile mele de un caracter.
        //In cazul in care rezultatul metodei nu a fost uun status vechi,
        //se asigna variabilei status, altfel, se reapela metoda si se repeta procesul
        String status = ":";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void shouldFailToUpdateMyStatusWithASpecialCharacterThatWasAnOldAStatusGivenMyUser() {
        //GIVEN

        //OBS: Aici ar fi trebuit sa fac o metoda care sa faca get
        //si sa retin intr-un parametru un vechi status format dintr-un
        //singur caracter special, dar asa mai fia vut nevoie de timp,
        //de aceea l-am dat eu direct, intrucat m-am concentrat sa testez "bine"
        //metoda de post, sper sa fie ok :)
        String status = "=";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }



    @Test
    public void shouldUpdateMyStatusWithMoreSpecialCharactersThatWereNotAnOldStatusGivenMyUser() {
        //GIVEN

        //OBS: Aici ar fi trebuit sa fac o metoda care sa faca get
        //si sa retin intr-o lista sau stream toate statusurile de mai mult de un  caracter
        //si sa-mi fac o metoda in data generator care genereaza string de caractere
        //cu string.length > 1
        //si sa compar rezultatul metodei cu statusurile mele.
        //In cazul in care rezultatul metodei nu a fost uun status vechi,
        //se asigna variabilei status, altfel, se reapela metoda si se repeta procesul
        String status = "~:?{]-(";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void shouldFailToUpdateMyStatusWithMoreSpecialCharactersThatWereAnOldStatusGivenMyUser() {
        //GIVEN

        //OBS: Aici ar fi trebuit sa fac o metoda care sa faca get
        //si sa retin intr-un parametru un vechi status format dintr-un
        //mai multe caractere speciale, dar as mai fia avut nevoie de timp,
        //de aceea l-am dat eu direct, intrucat m-am concentrat sa testez "bine"
        //metoda de post, sper sa fie ok :)
        String status = ")];'<>!{+";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }



    @Test
    public void shouldUpdateMyStatusWithAStringComposedFromOtherTwoOldStatusesGivenMyUser() {
        //GIVEN
        //Statusul asta e format din 2 vechi statusuri: : + ~:?{]-(
        //la fel, ar fi trebuit sa fac metode de get, dar m am concentrat
        //astazi doar pe post, sa -l testez cat mai bine
        String status = ":~:?{]-(";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void shouldFailToUpdateMyStatusWithStringTerminatorCharacterGivenMyUser() {
        //GIVEN
        String status = "\n";

        //WHEN
        Response updateUserStatus =  userClient.updateMyStaus(status);

        //THEN
        updateUserStatus.then().statusCode(HttpStatus.SC_FORBIDDEN);
    }

}
