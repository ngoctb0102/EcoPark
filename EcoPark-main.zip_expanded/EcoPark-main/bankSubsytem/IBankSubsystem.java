package bankSubsytem;

public interface IBankSubsystem{
    public int getBlance(String cardId);
    public void subtract(String cardId, int money);
    public void add(String cardId, int money);
}
    
