package lyon1.iutinfo.cvda.cvda.tp2.mhakoume;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Person {

    /**
     * defines the last name of a Person
     */
    private String lastName;
    /**
     * defines the first name of a Person
     */
    private String firstName;
    /**
     * defines the birthday of a Person
     */
    private GregorianCalendar ddn;
    /**
     * defines the e-mail of a Person
     */
    private String eMail;
    /**
     * defines the favourite color of a Person
     */
    private String favoriteColor;

    public Person() {
    }

    /**
     * Sets the lasName of the Person object which the method is called on.
     *
     */
    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    /**
     * Sets the firstName of the Person object which the method is called on.
     *
     */
    public void setFirstName(String firstName) {
        if (firstName.length() < 1) {
            this.firstName = firstName;
        } else {
            StringBuilder prenom2 = new StringBuilder(firstName.toLowerCase());
            char c = Character.toUpperCase(prenom2.charAt(0));
            prenom2.setCharAt(0, c);
            this.firstName = prenom2.toString();
        }
    }

    /**
     * Returns the lasName of the Person object which the method is called on.
     *
     * @return Returns the lastName of the Person object which the method is
     * called on.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the firstName of the Person object which the method is called on.
     *
     * @return Returns the firstName of the Person object which the method is
     * called on.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the eMail of the Person object which the method is called on.
     *
     * @return Returns the eMail of the Person object which the method is called
     * on.
     */
    public String getEmail() {
        return eMail;
    }

    /**
     * Sets the eMail of the Person object which the method is called on.
     *
     */
    public void setEMail(String eMail) throws IllegalArgumentException {
        if (eMail.contains("@") && eMail.length() >= 5) {
            this.eMail = eMail;
        } else {
            throw new IllegalArgumentException();
        }
        return;
    }

    /**
     * Returns the birthDay of the Person object which the method is called on.
     *
     * @return Returns the birthDay of the Person object which the method is
     * called on.
     */
    public GregorianCalendar getddn() {
        return ddn;
    }

    /**
     * Sets the birthDay of the Person object which the method is called on.
     *
     */
    public void setddn(int y, int m, int d) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        if (((currentDate.getDayOfMonth() < d || currentDate.getMonthValue() < m) && currentDate.getYear() <= y) || currentDate.getYear() < y) {
            throw new IllegalArgumentException("La date est invalide");
        } else {
            this.ddn = new GregorianCalendar(y, m, d);
        }
    }

    /**
     *
     * Returns the username of the Person based on its first name and last name.
     * The username will be formed like so : first letter of firstName + last
     * name. Everything will be lowercased.
     *
     * @return Returns the username of the Person based on its first name and
     * last name.
     */
    public String getLogin() throws StringIndexOutOfBoundsException {
        if (this.getFirstName().equals("") && this.getLastName().equals("")) {
            throw new StringIndexOutOfBoundsException();
        }

        String firstLetter = this.getFirstName().substring(0, 1).toLowerCase();
        String lastName = this.getLastName().toLowerCase();

        StringBuilder login = new StringBuilder(firstLetter + lastName);

        String strTemp = Normalizer.normalize(login, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        return pattern.matcher(strTemp).replaceAll("");
    }

    /**
     * Returns the favouriteColour of the Person object which the method is
     * called on.
     *
     * @return Returns the favouriteColour of the Person object which the method
     * is called on.
     */
    public String getFavoriteColor() {
        return favoriteColor;
    }

    /**
     * Sets the favouriteColour of the Person object which the method is called
     * on.
     *
     */
    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
