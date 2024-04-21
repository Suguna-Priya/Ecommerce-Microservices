package com.example.inventoryservice.controller;

import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku_code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku_code") String skucode){
        return inventoryService.isInStock(skucode);
    }
}

