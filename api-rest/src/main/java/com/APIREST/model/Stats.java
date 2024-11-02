package com.APIREST.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Stats {

    private long contadorADNMutante;
    private long contadorADNHumano;
    private double ratio;

    public Stats(long contadorADNMutante, long contadorADNHumano, double ratio) {
    }
}