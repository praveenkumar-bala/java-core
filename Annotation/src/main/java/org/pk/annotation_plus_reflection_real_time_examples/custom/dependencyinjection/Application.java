package org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {

        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);

        ProductService service = applicationContext.getBean(ProductService.class);

        List<Product> items = new ArrayList<>();

        items.add(new Product("Yoga Mat", 40));
        items.add(new Product("Coffee", 10));
        items.add(new Product("Tea", 20));

        List<Product> finalPrice = service.getFinalPrice(items);

        for (Product product : finalPrice) {
            System.out.println(product.getName() + " @"+ product.getDiscount()+ " % discount :"+ product.getPrice()+"$." );
        }

    }
}
