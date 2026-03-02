package com.development.sistempoin.controller;

import com.development.sistempoin.dto.ApiResponse;
import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.entity.Reward;
import com.development.sistempoin.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reward")
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService){
        this.rewardService = rewardService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<Reward>>> get() {
        List<Reward> data = rewardService.get();
        return ResponseEntity.ok(new ApiResponse<>(200, "Data reward berhasil diambil", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Reward>> create(@RequestBody Reward reward) {
        Reward data = rewardService.create(reward);
        return ResponseEntity.ok(new ApiResponse<>(200, "Reward berhasil dibuat", data));
    }
}
