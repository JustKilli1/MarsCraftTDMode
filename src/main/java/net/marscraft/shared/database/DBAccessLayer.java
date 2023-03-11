package net.marscraft.shared.database;

import net.marscraft.shared.logging.LogLevel;

import java.sql.ResultSet;
import java.util.Optional;

public class DBAccessLayer {

    private DatabaseLogger logger;
    private MySQL mySQL;

    public DBAccessLayer() {
        logger = DatabaseLogger.getInstance();
        mySQL = new MySQL();
        mySQL.connect();
    }

    public void disconnect() {
        mySQL.disconnect();
    }

    public void checkAndReconnect() {
        if(! mySQL.isConnected()) {
            mySQL.connect();
        }
    }

    public boolean executeSQLRequest(String query) {
        checkAndReconnect();
        if(!mySQL.isConnected()) return false;
        try {
            mySQL.getDatabaseCon().prepareStatement(query).executeUpdate();
            return true;
        } catch(Exception ex) {
            //TODO ERROR CODE
            logger.log(LogLevel.ERROR, "[ErrorCode] Could not Execute following SQL Statement: " + query, ex);
            return false;
        }
    }

    public Optional<ResultSet> querySQLRequest(String query) {
        checkAndReconnect();
        if(!mySQL.isConnected()) return Optional.empty();
        try {
            return Optional.ofNullable(mySQL.getDatabaseCon().prepareStatement(query).executeQuery());
        } catch(Exception ex) {
            //TODO ERROR CODE
            logger.log(LogLevel.ERROR, "[ErrorCode] Could not Execute following SQL Statement: " + query, ex);
            return Optional.empty();
        }
    }

}
