package automationExerciseProject.models;

public class user {
    private String name;
    private String email;
    private String password;
    private String title; 
    private String birthDate;
    private String birthMonth;
    private String birthYear;
    private String firstname;
    private String lastname;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String zipcode;
    private String state;
    private String city;
    private String mobileNumber;
    public user() {}
    public user(String name, String email, String password, String title, String birthDate,
                       String birthMonth, String birthYear, String firstname, String lastname,
                       String company, String address1, String address2, String country,
                       String zipcode, String state, String city, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.mobileNumber = mobileNumber;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getBirthMonth() { return birthMonth; }
    public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }

    public String getBirthYear() { return birthYear; }
    public void setBirthYear(String birthYear) { this.birthYear = birthYear; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
}
