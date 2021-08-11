package com.behsa.smsGw.Entity;

import javax.persistence.*;
import java.io.Serializable;

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
public class UserLogin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String P_USERNAME;

    @Column
    private String P_PASSWORD;

    public String getP_USERNAME() {
        return P_USERNAME;
    }

    public void setP_USERNAME(String p_USERNAME) {
        P_USERNAME = p_USERNAME;
    }

    public String getP_PASSWORD() {
        return P_PASSWORD;
    }

    public void setP_PASSWORD(String p_PASSWORD) {
        P_PASSWORD = p_PASSWORD;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "P_USERNAME='" + P_USERNAME + '\'' +
                ", P_PASSWORD='" + P_PASSWORD + '\'' +
                '}';
    }
}
