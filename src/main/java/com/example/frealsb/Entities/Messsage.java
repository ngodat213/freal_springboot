package com.example.frealsb.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Messsage {

    private String content;
    private String sender;
    private MessageType type;

    public enum MessageType{
        CHAT, LEAVE, JOIN
    }
}
