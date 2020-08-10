package io.nasna.app.models;

public class UsersHundler {
    private String username;
    private String id;
    private String vtest;

    public UsersHundler(String username, String id) {
        this.username = username;
        this.id = id;
        this.vtest = vtest;
        this.vtest2 = vtest2;
    }

    public String getVtest() {

        return vtest;
    }

    public void setVtest(String vtest) {
        this.vtest = vtest;
    }

    public String getVtest2() {
        return vtest2;
    }

    public void setVtest2(String vtest2) {
        this.vtest2 = vtest2;
    }

    private String vtest2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
