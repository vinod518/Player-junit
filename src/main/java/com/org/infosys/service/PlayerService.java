package com.org.infosys.service;

import com.org.infosys.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public void createPlayer(Player player);
    public void updatePlayer(Player player);
    public List<Player> getAll();
    public Optional<Player> getById(Integer id);
    public String deleteById(Integer id);
    public String updateParticularRecord(Integer id, String Address);
}
