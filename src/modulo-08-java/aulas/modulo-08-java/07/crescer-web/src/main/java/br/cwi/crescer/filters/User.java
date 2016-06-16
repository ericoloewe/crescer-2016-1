package br.cwi.crescer.filters;

import br.cwi.crescer.utils.UserDetails;

/**
 * @author Carlos H. Nonnemacher
 */
public class User implements UserDetails {

    private String username;
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
