package com.development.sistempoin.service;

import com.development.sistempoin.entity.Reward;
import com.development.sistempoin.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RewardService {
    private final RewardRepository rewardRepository;

    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public List<Reward> get() {
        return rewardRepository.findAll();
    }

    public Reward create(Reward reward) {
        rewardRepository.save(reward);
        return reward;
    }
}
