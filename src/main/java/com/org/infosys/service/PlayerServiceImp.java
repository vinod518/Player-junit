package com.org.infosys.service;

import com.org.infosys.model.Player;
import com.org.infosys.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlayerServiceImp implements PlayerService{
    @Autowired
    PlayerRepo playerRepo;

    @Override
    public void createPlayer(Player player) {
        playerRepo.save(player);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepo.save(player);
    }

    @Override
    public List<Player> getAll() {
        List<Player> lp = playerRepo.findAll();
        return lp;
    }

    @Override
    public Optional<Player> getById(Integer id) {
        Optional<Player> op = playerRepo.findById(id);
        return Optional.empty();
    }

    @Override
    public String deleteById(Integer id) {
        playerRepo.deleteById(id);
        return "success";
    }

    @Override
    public String updateParticularRecord(Integer id, String playerName) {
        Optional<Player> op1 = playerRepo.findById(id);
        Player ply = op1.get();
        ply.setPlayerName(playerName);
        playerRepo.save(ply);
        return "success";
    }
}
