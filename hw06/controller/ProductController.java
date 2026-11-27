package com.example.week6.hw06.controller;


import com.example.week6.hw06.domain.Product;
import com.example.week6.hw06.dto.ProductForm;
import com.example.week6.hw06.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // GET /products/new → 빈 ProductForm을 Model에 담아 입력 화면 반환
    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product-form";
    }

    // POST /products → 바인딩 → @Valid 검증 → BindingResult 확인
    // ※ BindingResult는 반드시 @Valid ProductForm 바로 뒤에 작성
    @PostMapping
    public String applyProduct(@Valid @ModelAttribute("productForm") ProductForm productForm,
                               BindingResult bindingResult) {

        // 오류 있음 → 입력 화면으로 (입력값과 오류 메시지가 함께 표시됨)
        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        productService.save(productForm.getTitle(), productForm.getPrice(), productForm.getQuantity(), productForm.getCategory(), productForm.getOnSale());

        // 오류 없음 → 결과 화면
        return "redirect:/product";
    }

    @GetMapping
    public String showProductList(@RequestParam(required = false) String keyword, Model model) {
        if (keyword != null && !keyword.isBlank()) {
            model.addAttribute("products", productService.search(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("products", productService.findAll());
        }
        return "product-list";
    }



    // GET /products/{id} → 상품 상세
    @GetMapping("/{id}")
    public String productDetail(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/{id}/edit")
    public String showProductEditForm(
            @PathVariable Long id, Model model
    ){
        Product product = productService.findById(id);
        ProductForm productForm = new ProductForm();
        productForm.setTitle(product.getTitle());
        productForm.setPrice(product.getPrice());
        productForm.setQuantity(product.getQuantity());
        productForm.setCategory(product.getCategory());
        productForm.setOnSale(product.getOnSale());
        model.addAttribute("productId", id);
        model.addAttribute("productForm", productForm);
        return "product-edit-form";
    }

    @PostMapping("{id}/edit")
    public String updateProduct(
            @PathVariable Long id,
            @Valid @ModelAttribute("productForm") ProductForm productForm,
            BindingResult bindingResult, Model model
    ){
        if (bindingResult.hasErrors()){
            model.addAttribute("productId", id);
            return "product-edit-form";
        }
        productService.update(id, productForm.getTitle(), productForm.getPrice(), productForm.getQuantity(), productForm.getCategory(), productForm.getOnSale());

        return "redirect:/product/"+id;
    }

    @PostMapping("{id}/delete")
    public String deleteProduct(
            @PathVariable Long id
    ){
        productService.delete(id);

        return "redirect:/product";
    }
}