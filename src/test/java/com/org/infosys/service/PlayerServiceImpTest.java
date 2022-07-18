package com.org.infosys.service;

import com.org.infosys.model.Player;
import com.org.infosys.repository.PlayerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlayerServiceImpTest {
    @InjectMocks
    PlayerServiceImp playerServiceImp;
    @Mock
    PlayerRepo playerRepo;

    @Test
    void createPlayer() {
        Player player = new Player();
        player.setId(10);
        player.setPlayerName("vinod");
        player.setPlayerCountry("india");
        player.setMatches(100);
        playerServiceImp.createPlayer(player);
        Mockito.verify(playerRepo,Mockito.times(1)).save(player);
    }

    @Test
    void updatePlayer() {
        Player player = new Player();
        player.setId(45);
        player.setPlayerName("Rohit");
        player.setPlayerCountry("india");
        player.setMatches(100);
        playerServiceImp.updatePlayer(player);
        Mockito.verify(playerRepo,Mockito.times(1)).save(player);
    }

    @Test
    void getAll() {
        List<Player> list = new ArrayList<>();
        Player player = new Player();
        player.setId(10);
        player.setPlayerName("vinod");
        player.setPlayerCountry("india");
        player.setMatches(100);
        Player player1 = new Player();
        player1.setId(45);
        player1.setPlayerName("Rohit");
        player1.setPlayerCountry("india");
        player1.setMatches(100);
        list.add(player);
        list.add(player1);
        Mockito.when(playerRepo.findAll()).thenReturn(list);
        List<Player> list1 = playerServiceImp.getAll();
        Assertions.assertEquals(list.size(),list1.size());
    }
    @Test
    void getById() {
        int id=10;
        Player player = new Player();
        player.setId(10);
        player.setPlayerName("rohit");
        Optional<Player> optional = Optional.of(player);
        Mockito.when(playerRepo.findById(id)).thenReturn(optional);
        Optional<Player> optional1 = playerServiceImp.getById(id);
        Assertions.assertEquals(optional1,optional);
    }
    @Test
    void deleteById() {
        int id=18;
        String str = "success";
        String str1 = playerServiceImp.deleteById(id);
        Mockito.verify(playerRepo,Mockito.times(1)).deleteById(id);
        Assertions.assertEquals(str,str1);
    }

    @Test
    void updateParticularRecord() {
        int id=45;
        String playerName = "vinod";
        String str = "success";
        Player player = new Player();
        player.setId(45);
        player.setPlayerName("vinod");
        Optional<Player> optional = Optional.of(player);
        Mockito.when(playerRepo.findById(id)).thenReturn(optional);
        String str1 = playerServiceImp.updateParticularRecord(id,playerName);
        Assertions.assertEquals(str,str1);
    }
}