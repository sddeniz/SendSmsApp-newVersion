package com.behsa.smsGw.Entity;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Value("${source}")
    String source_number;

    private String telnumber;

    private String message;

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource_number() {
        return source_number;
    }

    public void setSource_number(String source_number) {
        this.source_number = source_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "source_number='" + source_number + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
