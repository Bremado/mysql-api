# MYSQL-API - Uma API simplificada para o MySQL

Seja bem-vindo, esta API foi criada com o intuito de simplificar a criaçao de tabelas no banco de dados MySQL.
Podendo ser alterada e adaptada para qualquer tipo de projeto.

## Como usar?

Para iniciar ou fechar uma conexão com o banco de dados, basta seguir o exemplo abaixo:

```java 
DatabaseCredential credential = new DatabaseCredential(host,port,database,username,password);
DataAPI.getDatabase().start(credential); // Para iniciar a conexão.
        
DataAPI.getDatabase().close(); // Para fechar a conexão.
``````

Para instanciar uma tabela simplificada, basta seguir o exemplo abaixo:

```java
import com.toddydev.database.repository.column.Column;
import com.toddydev.database.repository.column.options.ColumnOptions;
import com.toddydev.database.repository.column.type.ColumnType;

public class MyRepository extends Repository {

    /**
     * Você pode adicionar quantas colunas quiser.
     */
    public MyRepository() {
        super(
                "my_table", // Nome da tabela
                Column.builder().name("id").type(ColumnType.INT)
                        .options(ColumnOptions.builder()
                                .autoIncrement(true)
                                .notNull(true)
                                .build()
                        )
                        .build(),
                Column.builder().name("name").type(ColumnType.TEXT)
                        .options(ColumnOptions.builder()
                                .notNull(true)
                                .build()
                        )
                        .build()
        );
    }
    
    /**
     * Você pode adicionar quantos métodos quiser.
     */
}
```
E para criar a tabela efetivamente no banco de dados, basta seguir o exemplo abaixo:

```java
Repository repository = new MyRepository();
repository.createRepository(); // O mesmo será criado seguindo as exigências da instanciação.
```

Essa API poderá ser atualizada futuramente, fique atento! 

## Licença

Este projeto está licenciado sob a licença GPL-2.0 - consulte o arquivo [LICENSE.md](LICENSE.md) para obter detalhes.

## Contato

- Discord: bremado
