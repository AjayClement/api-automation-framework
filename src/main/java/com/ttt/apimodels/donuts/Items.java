package com.ttt.apimodels.donuts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Items {
    private ArrayList<Item> item;
}
