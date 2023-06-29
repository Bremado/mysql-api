package com.toddydev.database.repository.column;

import com.toddydev.database.repository.column.options.ColumnOptions;
import com.toddydev.database.repository.column.type.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
public class Column {

    private String name;
    private ColumnType type;

    private ColumnOptions options;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " " + type.toString() + type.getComplement());
        options.toString(stringBuilder);
        return stringBuilder.toString();
    }
}
