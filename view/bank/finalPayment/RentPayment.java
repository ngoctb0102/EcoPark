package view.bank.finalPayment;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class RentPayment extends IPayment{
    public RentPayment() {
        super();
    }

    @Override
    public void completeLastStep() {
        paymentController.saveRentBikeHistory(userId, bikeCode,1,new Date(Calendar.getInstance().getTime().getTime()));
    }
}
