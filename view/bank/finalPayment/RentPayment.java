package view.bank.finalPayment;

import java.sql.Timestamp;
import java.util.Calendar;

public class RentPayment extends IPayment{
    public RentPayment() {
        super();
    }

    @Override
    public void completeLastStep() {
        paymentController.saveRentBikeHistory(userId, bikeCode,1,new Timestamp(Calendar.getInstance().getTime().getTime()));
    }
}
