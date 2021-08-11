package com.behsa.smsGw.Entity;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(
        name = "PRC_LOGIN",
        procedureName = "PKG_AUTHENTICATION.PRC_LOGIN",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_USERNAME"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_PASSWORD"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "P_RESPONSE_TYPE"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "P_RESPONSE_DESC")
        }
)
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String username;

    @Column
    private String password;

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

    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
