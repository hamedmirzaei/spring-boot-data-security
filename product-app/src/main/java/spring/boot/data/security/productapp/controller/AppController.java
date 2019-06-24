package spring.boot.data.security.productapp.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import spring.boot.data.security.productapp.model.Product;

import java.util.List;

@Controller
public class AppController {

    final String PRODUCTS_URI = "http://localhost:8281/api/products";

    @GetMapping("/")
    private String login(Model model) {
        return "index";
    }

    @GetMapping("/index")
    private String login2(Model model) {
        return "index";
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProducts(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> productsResponse = restTemplate.exchange(
                PRODUCTS_URI, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        List<Product> products = productsResponse.getBody();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/addproducts")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddProductForm(Model model) {
        model.addAttribute("msg", "Hello");
        return "addproduct";
    }


}
