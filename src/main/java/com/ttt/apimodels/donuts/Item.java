package com.ttt.apimodels.donuts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Item {
    private String id;
    private String type;
    private String name;
    private double ppu;
    private Batters batters;
    private ArrayList<Topping> topping;
}
