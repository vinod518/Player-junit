package com.org.infosys.controller;

import com.org.infosys.model.Player;
import com.org.infosys.repository.PlayerRepo;
import com.org.infosys.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")

public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/create")
    public void createPlayer(@RequestBody Player player){
        playerService.createPlayer(player);
    }
    @PutMapping("/update")
    public void updatePlayer(@RequestBody Player player){
        playerService.updatePlayer(player);
    }
    @GetMapping("/getAll")
    public List<Player> getAll(){
        List<Player> lp = playerService.getAll();
        return lp;
    }
    @GetMapping("/getById/{id}")
    public Optional<Player> getById(@PathVariable Integer id){
        Optional<Player> op = playerService.getById(id);
        return op;
    }
    @DeleteMapping("/deletById/{id}")
    public String deleteById(@PathVariable Integer id){
        playerService.deleteById(id);
         return "success";
    }
    @PatchMapping("/updateParticularRecord/{id}/{playerName}")
    public String updateParticularRecord(@PathVariable Integer id, @PathVariable String playerName){
        String op1 = playerService.updateParticularRecord(id,playerName);
        return "op1";
    }
}
