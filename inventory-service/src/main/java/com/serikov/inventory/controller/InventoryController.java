package com.serikov.inventory.controller;

import com.serikov.dto.InventoryRequestDTO;
import com.serikov.dto.InventoryResponseDTO;
import com.serikov.inventory.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("inventory")
@AllArgsConstructor
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/deduct")
    public InventoryResponseDTO deduct(@RequestBody final InventoryRequestDTO requestDTO) {
        log.info("Process inventory deduct for request: " + requestDTO);
        return this.service.deductInventory(requestDTO);
    }

    @PostMapping("/revert")
    public void add(@RequestBody final InventoryRequestDTO requestDTO) {
        log.info("Process inventory add for request: " + requestDTO);
        this.service.revertInventory(requestDTO);
    }

    @GetMapping()
    public List<InventoryResponseDTO> getAllByUserId(@RequestParam(name = "userId") final Integer userId) {
        log.info("Get all inventory orders rows with status: " + userId);
        return this.service.getAllByUserId(userId);
    }

}
