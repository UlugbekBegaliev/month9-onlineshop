package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.dto.BasketDTO;
import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.dto.ReviewDTO;
import com.begaliev.month9onlineshop.exeption.ResourceNotFoundException;
import com.begaliev.month9onlineshop.model.Basket;
import com.begaliev.month9onlineshop.model.Constants;
import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.service.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;
    private final PurchaseService purchaseService;
    private final ReviewService reviewService;
    private final PropertiesService propertiesService;

    @GetMapping("/products/{id}/reviews")
    public String reviews(@PathVariable String id, Model model) {
        List<ReviewDTO> reviewDTOS = reviewService
                .getReviewsByProductId(Integer.parseInt(id));

        if (!reviewDTOS.isEmpty()) {
            model.addAttribute("items", reviewDTOS);
        }

        ProductDTO product = productService.getById(Integer.parseInt(id));
        model.addAttribute("product", product);

        return "review";
    }

    @PostMapping("/reviews/{id}")
    public String review(@PathVariable String id,
                         @RequestParam String description,
                         Authentication authentication) {

        reviewService.review(Integer.parseInt(id), description, authentication);

        return "redirect:/products/{id}/reviews";
    }

    @GetMapping("/basket")
    public String basket(Model model, @SessionAttribute(name = Constants.BASKET_ID, required = false) List<BasketDTO> basket,
                         Authentication authentication) {
        List<BasketDTO> baskets = basketService.getBasket(basket, authentication);
        model.addAttribute("basketItems", baskets);

        return "basket";
    }

    @PostMapping(path = "/basket", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean addToBasket(@RequestBody ProductDTO productDTO,
                               @SessionAttribute(name = Constants.BASKET_ID, required = false)
                                       List<BasketDTO> basket, Authentication authentication) {
        basketService.addToBasket(productDTO, basket, authentication);

        return true;
    }

    @GetMapping("/purchases")
    public String purchases(Model model, Authentication authentication, Pageable pageable, HttpServletRequest uriBuilder) {

        var purchases = purchaseService.getPurchases(authentication, pageable);
        var uri = uriBuilder.getRequestURI();
        propertiesService.setDefaultPageSize(10);
        PropertiesService.constructPageable(purchases, propertiesService.getDefaultPageSize(), model, uri);

        return "purchase";
    }

    @ResponseBody
    @PostMapping(path = "/purchase/id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String purchase(@RequestBody BasketDTO basketDTO) {

        purchaseService.purchase(basketDTO);

        return "redirect:/purchases";
    }

    @ResponseBody
    @PostMapping(path = "/basket/id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String emptyBasketById(@RequestBody BasketDTO basketDTO) {
        basketService.deleteBasket(basketDTO.getId());

        return "redirect:/basket";
    }

    @PostMapping("/basket/empty")
    public String emptyBasket(HttpSession httpSession, Authentication authentication) {
        httpSession.removeAttribute(Constants.BASKET_ID);

        return "redirect:/basket";
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {

        model.addAttribute("resource", ex);
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }

}
