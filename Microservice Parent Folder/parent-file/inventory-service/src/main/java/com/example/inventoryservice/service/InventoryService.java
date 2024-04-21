package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepo;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException {
        /*log.info("Wait Start");
        Thread.sleep(5000);
        log.info("Wait End");*/
        return inventoryRepo.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }
// shortcut method for the below one is the above code ...
    /*private InventoryResponse mapToResponse(Inventory inventory) {

        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }*/

}
