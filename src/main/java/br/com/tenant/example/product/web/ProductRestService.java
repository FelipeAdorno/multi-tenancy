package br.com.tenant.example.product.web;

import br.com.tenant.example.product.Product;
import br.com.tenant.example.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author Felipe Adorno felipeadsc@gmail.com
 */
@RestController
@AllArgsConstructor
@RequestMapping("v1/products")
class ProductRestService {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public Page<Product> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
                                 @RequestParam(defaultValue = "20", required = false) Integer size) {
        return productService.findAll(new PageRequest(page, size));
    }
}
