package com.toddydev.database.credentials;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class DatabaseCredential {

    private String host;
    private String port;

    private String database;
    private String username;
    private String password;

}
