package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.model.Constants;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdviceController {

    public List<String> getBasketModel(HttpSession httpSession) {
        var list = httpSession.getAttribute(Constants.BASKET_ID);
        if (list == null) {
            httpSession.setAttribute(Constants.BASKET_ID, new ArrayList<>());
        }
        return (List<String>) httpSession.getAttribute(Constants.BASKET_ID);
    }
}
