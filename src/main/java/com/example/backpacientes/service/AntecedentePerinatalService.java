package com.example.backantecedenteperinatals.service;

import com.example.backantecedenteperinatals.entity.AntecedentePerinatal;

import java.util.List;
import java.util.UUID;

public interface AntecedentePerinatalService {
    List<AntecedentePerinatal> findAntecedentePerinatalAll();
    AntecedentePerinatal getAntecedentePerinatal(UUID id);
    AntecedentePerinatal createAntecedentePerinatal(AntecedentePerinatal antecedenteperinatal);
    AntecedentePerinatal updateAntecedentePerinatal(AntecedentePerinatal antecedenteperinatal);
    String deleteAntecedentePerinatal(UUID id);
}
