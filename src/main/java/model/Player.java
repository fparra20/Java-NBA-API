package model;

import controller.RetrievePlayer;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Player {

    public String firstName;
    public String lastName;
    public String personId;
    public String teamId;
    public String jersey;
    public String pos;
    public String height;
    public String weight;
    public String dateOfBirthUTC;
    public String yearsPro;
    public String collegeName;
    public String country;

    public Player() {

    }

    public String getAge() {

        // Formateamos la fecha de nacimiento a LocalDate
        LocalDate birth = LocalDate.parse(getDateOfBirthUTC());

        // Recogemos la fecha actual
        LocalDate current = LocalDate.now();

        // Guardamos los años, usando la clase Period que calcula el tiempo que ha pasado
        int years = Period.between(birth, current).getYears();

        // Guardamos los días, usando la clase Period que calcula el tiempo que ha pasado
        int days = Period.between(birth, current).getDays();

        // Devolvemos un String con el dato formateado
        return years + "y, " + days + "d";
    }

    public Player getPlayerProfileFromId(String playerId, String teamUrl) {

        RetrievePlayer rpc = new RetrievePlayer();

        return rpc.getPlayerInfoById(playerId, teamUrl);
    }

    public ArrayList<Player> getAllPlayers() {

        RetrievePlayer rpc = new RetrievePlayer();

        return rpc.getPlayers();
    }

    public ArrayList<Player> getPlayersByTeamUrl(String teamUrl) {

        RetrievePlayer rpc = new RetrievePlayer();

        return rpc.getPlayersByTeamUrl(teamUrl);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getHeight() {

        String[] hs = height.split("-");

        int foot = Integer.parseInt(hs[0]);
        int inches = Integer.parseInt(hs[1]);

        double heightMeters = (foot + inches / 12.0) * 0.3048;

        DecimalFormat df = new DecimalFormat("#.##");

        return df.format(heightMeters);
    }

    public void setHeight(String heightFt) {
        this.height = heightFt;
    }

    public String getWeight() {

        double weightKg = Integer.parseInt(weight) * 0.45;

        DecimalFormat df = new DecimalFormat("#.#");

        return df.format(weightKg);
    }

    public void setWeight(String weightLbs) {
        this.weight = weightLbs;
    }

    public String getDateOfBirthUTC() {
        return dateOfBirthUTC;
    }

    public void setDateOfBirthUTC(String dateOfBirthUTC) {
        this.dateOfBirthUTC = dateOfBirthUTC;
    }

    public String getYearsPro() {

        if (yearsPro.equals("0")) {
            yearsPro = "R";
        }

        return yearsPro;
    }

    public void setYearsPro(String yearsPro) {
        this.yearsPro = yearsPro;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
