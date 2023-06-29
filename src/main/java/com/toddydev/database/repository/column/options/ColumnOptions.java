package com.toddydev.database.repository.column.options;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
public class ColumnOptions {

    private boolean autoIncrement;
    private boolean notNull;

    private boolean reference;

    private String referenceTable;
    private String referenceColumn;

    public void toString(StringBuilder stringBuilder) {
        if (autoIncrement) {
            stringBuilder.append(" AUTO_INCREMENT");
        }
        if (notNull) {
            stringBuilder.append(" NOT NULL");
        }
        if (reference) {
            stringBuilder.append(" REFERENCES " + referenceTable + "(" + referenceColumn + ")");
        }
    }
}
