package application.shipping.shippingServiceFactory;


import application.shipping.ShippingService;
import application.shipping.extractShippableItems.ExtractShippableItems;
import application.shipping.extractShippableItems.IExtractShippableItems;
import application.shipping.processShipmentPrinting.IProcessShipmentPrinting;
import application.shipping.processShipmentPrinting.ProcessShipmentPrinting;
import application.shipping.shippingFeeStrategy.ShippingFeeStrategy;
import application.shipping.shippingFeeStrategy.ThresholdBasedFreeShipping;
import application.shipping.shippingFeeStrategy.WeightBasedShippingStrategy;

public class ShippingServiceFactory {

    public static ShippingService createShippingServiceWithThreshold() {
        ShippingFeeStrategy strategy = new ThresholdBasedFreeShipping();
        IExtractShippableItems extractor = new ExtractShippableItems();
        IProcessShipmentPrinting printer = new ProcessShipmentPrinting();
        return new ShippingService(strategy, extractor, printer);
    }
    public static ShippingService createShippingServiceWithWeight(double ratePerKg) {
        ShippingFeeStrategy strategy = new WeightBasedShippingStrategy(ratePerKg);
        IExtractShippableItems extractor = new ExtractShippableItems();
        IProcessShipmentPrinting printer = new ProcessShipmentPrinting();
        return new ShippingService(strategy, extractor, printer);
    }
}

