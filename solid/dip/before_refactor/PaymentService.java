package solid.dip.before_refactor;

class PayPalPaymentService {
    public void processPayment(double amt) {
        System.out.println("paypal payment: " + amt);
    }
}

public class PaymentService {
    private PayPalPaymentService paymentService = new PayPalPaymentService();

    public void processPayment(double amt) {
        paymentService.processPayment(amt);
    }
}
