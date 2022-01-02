package view.bank.finalPayment;
public class ReturnPayment extends IPayment{

    public ReturnPayment() {
        super();
    }

    @Override
    public void completeLastStep() {
        paymentController.returnBikeHistory(userId,bikeCode);
    }
}
