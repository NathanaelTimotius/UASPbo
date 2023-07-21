package model;


import java.sql.Date;


public class User {
    private String name;
    private String email;
    private String password;
    private int gender;
    private Date birthday;
    private String photo;

    public User(){
        
    }
    
    public User(String name, String email, String password, int gender, Date birthday, String photo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
