package com.example.week6.hw06.controller;


import com.example.week6.hw06.domain.Product;
import com.example.week6.hw06.dto.ProductForm;
import com.example.week6.hw06.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public String productList(Model model){
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    // GET /products/new → 빈 ProductForm을 Model에 담아 입력 화면 반환
    @GetMapping("/new")
    public String productForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product-form";
    }

    // POST /products → 바인딩 → @Valid 검증 → BindingResult 확인
    // ※ BindingResult는 반드시 @Valid ProductForm 바로 뒤에 작성
    @PostMapping
    public String registerProduct(@Valid @ModelAttribute("productForm") ProductForm productForm,
                                  BindingResult bindingResult) {

        // 오류 있음 → 입력 화면으로 (입력값과 오류 메시지가 함께 표시됨)
        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        productService.save(productForm);

        // 오류 없음 → 결과 화면
        return "product-result";
    }

    // GET /products/{id} → 상품 상세
    @GetMapping("/{id}")
    public String productDetail(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "상품을 찾을 수 없습니다."
                ));

        model.addAttribute("product", product);
        return "product-detail";
    }
}