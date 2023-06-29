package com.toddydev.database.repository.column.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ColumnType {

    TEXT(""),
    VARCHAR( "(255)"),
    JSON(""),

    INT(""),
    BIGINT( ""),
    FLOAT(""),
    DOUBLE(""),

    BOOLEAN("");

    String complement;
}
