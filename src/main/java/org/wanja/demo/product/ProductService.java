package org.wanja.demo.product;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) throws InvocationTargetException, IllegalAccessException {
        Product productInDB = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        BeanUtils.copyProperties(productInDB, product);
        return productRepository.save(productInDB);
    }


    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
