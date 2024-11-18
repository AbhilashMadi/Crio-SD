package solid.dip.after_refactor;

interface PaymentProcessor {
    public void processPayment(double amt);
}

class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amt) {
        System.out.println("payment via paypal: " + amt);
    }
}

class StripePaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amt) {
        System.out.println("payment via stripe: " + amt);
    }
}

public class PaymentService {
    private PaymentProcessor processor;

    public PaymentService() {
        processor = new PayPalPaymentProcessor();
    }

    public void processPayment(double amt) {
        processor.processPayment(amt);
    }

    public void setPaymentProcessor(PaymentProcessor processor){
        this.processor = processor;
    }

    public static void main(String[] args){
        PaymentService service = new PaymentService();

        service.processPayment(100);

        service.setPaymentProcessor(new StripePaymentProcessor());
        service.processPayment(200);
    }
}
