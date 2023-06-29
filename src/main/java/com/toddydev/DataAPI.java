package com.toddydev;

import com.google.gson.Gson;
import com.toddydev.database.Database;
import com.toddydev.database.credentials.DatabaseCredential;
import lombok.Getter;

public class DataAPI {

    @Getter
    private static Gson gson = new Gson();

    @Getter
    private static Database database = new Database();

}
