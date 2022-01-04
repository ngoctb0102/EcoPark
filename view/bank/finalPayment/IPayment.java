package view.bank.finalPayment;

import rentBikeHistorySubsystem.IRentBikeHistory;

public abstract class IPayment {
    protected String bikeCode;
    protected int userId;
    protected IRentBikeHistory rentBikeHistory;

    public IPayment() {

    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRentBikeHistory(IRentBikeHistory rentBikeHistory) {
        this.rentBikeHistory = rentBikeHistory;
    }

    public abstract void completeLastStep();


}
