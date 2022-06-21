package com.example.cinema.services;

import com.example.cinema.dao.RapDAOD;
import com.example.cinema.model.RapD;

import java.util.List;

public class RapService {
    private static RapService rapService = null;
    public static RapService khoitao(){
        return rapService == null ? new RapService() : rapService;
    }
    private RapDAOD rapDAOD = RapDAOD.khoitao();
    // lay list rap;
    public List<RapD> layListRap(){
        return rapDAOD.layListRap();
    }
}
