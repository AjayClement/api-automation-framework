package com.ttt.apimodels.spotify;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Albums {
    private String href;
    private ArrayList<Item> items;
}
