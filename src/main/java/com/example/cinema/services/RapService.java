package com.example.cinema.services;

import com.example.cinema.dao.RapDAO;
import com.example.cinema.model.Rap;

import java.util.List;

public class RapService {
    private static RapService rapService = null;
    public static RapService khoitao(){
        return rapService == null ? new RapService() : rapService;
    }
    private RapDAO rapDAO = RapDAO.khoitao();
    // lay list rap;
    public List<Rap> layListRap(){
        return rapDAO.layListRap();
    }
}
