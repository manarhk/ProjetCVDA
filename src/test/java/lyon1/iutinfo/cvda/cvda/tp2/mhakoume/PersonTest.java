package lyon1.iutinfo.cvda.cvda.tp2.mhakoume;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author manar
 */
public class PersonTest {

    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setLastName method, of class Person.
     */
    @Test
    public void SetLastName() {
        System.out.println("setNom");
        String nom = "MaNar";
        Person instance = new Person();
        instance.setLastName(nom);
        assertEquals("MANAR", instance.getLastName());
    }

    @Test
    public void SetEmptyLastName() {
        System.out.println("setNom Vide");
        String nom = "";
        Person instance = new Person();
        instance.setLastName(nom);
        assertEquals("", instance.getLastName());
    }

    /**
     * Test of setFirsttName method, of class Person.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setPr\u00e9nom");
        String prénom = "manar";
        Person instance = new Person();
        instance.setFirstName(prénom);
        assertEquals("Manar", instance.getFirstName());
    }

    @Test
    public void testSetEmptyFirstName() {
        System.out.println("setPr\u00e9nom Vide");
        String prénom = "";
        Person instance = new Person();
        instance.setFirstName(prénom);
        assertEquals("", instance.getFirstName());
    }

    /**
     * Test of Setddn method, of class Person.
     */
    @Test
    public void testSetddn() {
        System.out.println("getDdn");
        Person instance = new Person();
        instance.setddn(2000, 07, 19);
        GregorianCalendar expResult = new GregorianCalendar(2000, 07, 19);
        GregorianCalendar result = instance.getddn();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetdnnFuture() {
        System.out.println("testSetDDNFutur");
        Person instance = new Person();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setddn(2060, 07, 19);
        });
    }

    /**
     * Test of SetEMail method, of class Person.
     */
    @Test
    public void testSetEMail() {
        System.out.println("set_email");
        String eMail = "manar19.hakoume@email.fr";
        Person instance = new Person();
        instance.setEMail(eMail);
        assertEquals(eMail, instance.getEmail());
    }

    @Test
    public void testSetEMailError() {
        System.out.println("setEmail error");
        String eMail = "manarhakoume";
        Person instance = new Person();
        assertThrows(IllegalArgumentException.class, () -> instance.setEMail(eMail));
    }

    public void testSetEMailLengthError() {
        System.out.println("setEmail error");
        String eMail = "mhk@";
        Person instance = new Person();
        assertThrows(IllegalArgumentException.class, () -> instance.setEMail(eMail));
    }

    /**
     * Test of GetLogin method, of class Person.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Person instance = new Person();
        instance.setLastName("HAKOUME");
        instance.setFirstName("Manar");
        String expResult = "mhakoume";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLoginAccent() {
        System.out.println("getLogin Accent");
        Person instance = new Person();
        instance.setLastName("éba");
        instance.setFirstName("ébao");
        String expResult = "eeba";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLoginFirstLetter() {
        System.out.println("getLogin first letter");
        Person instance = new Person();
        instance.setLastName("");
        instance.setFirstName("manarhakoume");
        String expResult = "m";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLoginAccentFirstLetter() {
        System.out.println("getLogin accent first letter");
        Person instance = new Person();
        instance.setLastName("");
        instance.setFirstName("allo");
        String expResult = "a";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLoginEmpty() {
        System.out.println("getLogin Vide");
        Person instance = new Person();
        instance.setLastName("");
        instance.setFirstName("");
        assertThrows(StringIndexOutOfBoundsException.class, () -> instance.getLogin());
    }

}
