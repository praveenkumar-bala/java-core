package org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection;

import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.Component;

import java.util.List;

@Component
public class ProductRepository {

    /**
     * Lets assume we are reading price in database.
     */
    public List<Product> getPrice(List<Product> items) {
        for (Product product : items) {
            Double price = (double) Math.round(30 * Math.random());
            product.setPrice(price);
        }
        return items;
    }
}
