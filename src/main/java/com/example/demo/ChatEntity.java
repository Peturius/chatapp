package com.example.demo;
import jakarta.persistence.*;

import org.hibernate.type.SqlTypes;


@Entity
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ID;

    @Column(nullable = false)
    private String setter;
    @Column(nullable = false)
    private String getter;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false, columnDefinition = "ENUM('SENT', 'SEEN', 'ANSWERED')")
    @Enumerated(EnumType.STRING)
    private MessageStatusEnum status;


    public ChatEntity(){}

    public ChatEntity(String setter, String getter, String message, MessageStatusEnum status ) {
        this.setter = setter;
        this.getter = getter;
        this.message = message;
        this.status = status;
    }


    public String getSetter() {
        return setter;
    }

    public void setSetter(String setter) {
        this.setter = setter;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public MessageStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MessageStatusEnum status) {
        this.status = status;
    }
}
