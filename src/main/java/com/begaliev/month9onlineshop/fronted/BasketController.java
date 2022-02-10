package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.dto.BasketDTO;
import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.model.Constants;
import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.service.BasketService;
import com.begaliev.month9onlineshop.service.ProductService;
import com.begaliev.month9onlineshop.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;
    private final PurchaseService purchaseService;

    @GetMapping("/basket")
    public String basket(Model model, @SessionAttribute(name = Constants.BASKET_ID, required = false) List<BasketDTO> basket,
                         Authentication authentication) {
        List<BasketDTO> baskets = basketService.getBasket(basket, authentication);
        model.addAttribute("basketItems", baskets);

        return "basket";
    }

    public boolean addToBasket(@RequestBody ProductDTO productDTO,
                               @SessionAttribute(name = Constants.BASKET_ID, required = false)
                                       List<BasketDTO> basket, Authentication authentication) {
        basketService.addToBasket(productDTO, basket, authentication);

        return true;
    }

    @PostMapping("/basket/empty")
    public String emptyBasket(HttpSession httpSession, Authentication authentication){
        httpSession.removeAttribute(Constants.BASKET_ID);

        return "redirect:/cart";
    }

}
