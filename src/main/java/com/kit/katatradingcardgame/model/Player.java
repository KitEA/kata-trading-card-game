package com.kit.katatradingcardgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private String name;
    private int health;
    private int mana;

}
