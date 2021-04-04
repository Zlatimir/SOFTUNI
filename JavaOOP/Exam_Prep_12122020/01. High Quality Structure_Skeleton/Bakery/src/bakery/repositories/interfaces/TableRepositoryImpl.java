package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public class TableRepositoryImpl implements TableRepository<Table> {
    private List<Table> tables;

    public TableRepositoryImpl() {
        this.tables = new ArrayList<>();
    }

    @Override
    public Table getByNumber(int number) {
        for (Table table : tables) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableList(tables);
    }

    @Override
    public void add(Table table) {
        tables.add(table);
    }

}
