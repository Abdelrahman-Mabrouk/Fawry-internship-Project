package application.checkout.factory;

import application.checkout.CheckoutService;
import application.checkout.Printer.IPrinter;
import application.checkout.Printer.ReceiptPrinter;
import application.checkout.validator.CheckoutValidator;
import application.checkout.validator.IValidator;
import application.shipping.ShippingService;

public class CheckoutServiceFactory {
    public static CheckoutService create(ShippingService shippingService) {
        IValidator validator = new CheckoutValidator();
        IPrinter printer = new ReceiptPrinter();
        return new CheckoutService(shippingService, validator, printer);
    }
}
