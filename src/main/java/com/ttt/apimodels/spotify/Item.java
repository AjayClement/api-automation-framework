package com.ttt.apimodels.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Item {
    @JsonProperty("album_group")
    private String albumGroup;
    @JsonProperty("album_type")
    private String albumType;
    private ArrayList<Artist> artists;
    @JsonProperty("available_markets")
    private ArrayList<String> availableMarkets;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private ArrayList<Image> images;
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("total_tracks")
    private int totalTracks;
    private String type;
    private String uri;
}
