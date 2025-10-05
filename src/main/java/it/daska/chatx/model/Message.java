package it.daska.chatx.model;

import java.sql.Timestamp;
import java.util.List;

public class Message {

    private Long id;
    private Long chatId;
    private Long senderId;
    //TODO AGGIUNGERE UN recipient ALTRIMENTI NON HA SENSO
    private  enum  Stato {
        READED,
        DELIVERED
    }

    private List<User> read_by;
    private Timestamp sendTimeStamp;


}
