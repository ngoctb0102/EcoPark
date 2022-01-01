package view.bank.finalPayment;

import controller.PaymentController;

public abstract class IPayment {
    protected PaymentController paymentController;
    protected String bikeCode;
    protected int userId;

    public IPayment() {
        this.paymentController = new PaymentController();
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public abstract void completeLastStep();


}
