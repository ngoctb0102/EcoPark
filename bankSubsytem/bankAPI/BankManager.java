package bankSubsytem.bankAPI;
import bankSubsytem.IBankSubsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static bankSubsytem.bankAPI.BankConnector.connect;

public class BankManager implements IBankSubsystem{
    @Override
    public Integer getBalance(String cardId){
        Integer balance = -1;
        try{
            Connection connection = connect();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Account WHERE cardId = '"+cardId+"';";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                balance = (Integer) resultSet.getInt("balance");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return balance;
    }

    @Override
    public int subtract(String cardId, int money) {
        int subResult = SUCCESS;
        int balance = getBalance(cardId);
        if (balance < money) subResult = NOT_ENOUGH;
        else{
            try {
                Connection connection = connect();
                Statement statement = connection.createStatement();
                balance -= money;
                String query = "UPDATE Account SET balance = " + balance + " WHERE cardId = '" + cardId + "';";
                int executeUpdate = statement.executeUpdate(query);
                if(executeUpdate != 1) subResult = UPDATE_ERR;
                statement.close();
                connection.close();
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return subResult;
    }

    @Override
    public int add(String cardId, int money){
        int addResult = SUCCESS;
        int balance = getBalance(cardId);
        try{
            Connection connection = connect();
            Statement statement = connection.createStatement();
            balance += money;
            String query = "UPDATE Account SET balance = " + balance + " WHERE cardId = '" + cardId + "';";
            int executeUpdate = statement.executeUpdate(query);
            if(executeUpdate != 1) addResult = UPDATE_ERR;
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return addResult;
    }
}
