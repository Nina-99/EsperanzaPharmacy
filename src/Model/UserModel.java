package Model;

public class UserModel {

    int id_user;
    String name;
    String surname_pater;
    String surname_mother;
    String account;
    String password;
    int level;
 
    public UserModel() {
        id_user = 0;
        name = "";
        surname_pater = "";
        surname_mother = "";
        account = "";
        password = "";
        level = 0;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname_pater() {
        return surname_pater;
    }

    public void setSurname_pater(String surname_pater) {
        this.surname_pater = surname_pater;
    }

    public String getSurname_mother() {
        return surname_mother;
    }

    public void setSurname_mother(String surname_mother) {
        this.surname_mother = surname_mother;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
