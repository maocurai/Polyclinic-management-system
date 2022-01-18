package com.example.springApp.util;

import com.example.springApp.service.DiseaseService;
import com.example.springApp.service.DiseaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class DiseaseModelFiller implements ModelFiller{

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private DiseaseTypeService diseaseTypeService;

    @Override
    public Model fill(Model model) {
        return model.addAttribute("diseaseTypes", diseaseTypeService.findAll())
                .addAttribute("diseases", diseaseService.findAllOrderByNameASC());
    }
}
