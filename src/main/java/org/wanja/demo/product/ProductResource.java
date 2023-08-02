package org.wanja.demo.product;

import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestPath;
import io.quarkus.logging.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Path("/api/v1/products")
public class ProductResource {

    @Inject
    ProductService productService;

    @POST
    public Product createProduct(@NotNull Product product) {
        return productService.create(product);
    }

    @PUT
    @Path("/{id}")
    public Product updateProduct(@RestPath String id, @NotNull Product product) throws InvocationTargetException, IllegalAccessException {
        return productService.update(Long.valueOf(id), product);
    }

    @GET
    public List<Product> getProducts() {
        Log.info("GET PRODUCTS CALLED");
        return productService.getAll();
    }

    @GET
    @Path("/{id}")
    public Product getProductById(Long id) {
        return productService.getById(id);
    }
}
