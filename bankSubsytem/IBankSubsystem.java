package bankSubsytem;

public interface IBankSubsystem{
    public static final int SUCCESS = 1;
    public static final int UPDATE_ERR = -1;
    public static final int NOT_ENOUGH = 0;

    public Integer getBalance(String cardId);
    public int subtract(String cardId, int money);
    public int add(String cardId, int money);
}
    
