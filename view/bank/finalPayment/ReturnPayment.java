package view.bank.finalPayment;

public class ReturnPayment extends IPayment{

    public ReturnPayment() {
        super();
    }

    @Override
    public void completeLastStep() {
        //update status with bikeCode (licensePlate), userId, status = 0 (No need updating Date)
    }
}
