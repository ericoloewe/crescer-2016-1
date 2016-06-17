package br.cwi.crescer.utils;

import java.io.Serializable;

/**
 * @author Carlos H. Nonnemacher
 */
public interface UserDetails extends Serializable {

    public static final String USER_AUTH = "USER_AUTH";

    public String getUsername();

}
