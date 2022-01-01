package view.bank.finalPayment;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
public class ReturnPayment extends IPayment{

    public ReturnPayment() {
        super();
    }

    @Override
    public void completeLastStep() {
        //update status with bikeCode (licensePlate), userId, status = 0 (No need updating Date)
        paymentController.saveRentBikeHistory(userId, bikeCode,0,new Date(Calendar.getInstance().getTime().getTime()));
    }
}
