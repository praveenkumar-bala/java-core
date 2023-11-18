package org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection;

import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.Autowired;
import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getFinalPrice(List<Product> items) {

        List<Product> list = repo.getPrice(items);
        for (Product product : list
        ) {

            product.setPrice(product.getPrice() * ((100 - product.getDiscount()) / 100));
            System.out.println("Price of " + product.getName() + " after " + product.getDiscount()
                    + "% discount is " + product.getPrice());
        }

        return list;
    }
}
