package com.example.springApp.controller;

import com.example.springApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UtilityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private StreetTypeService streetTypeService;

    @Autowired
    private StreetNameService streetNameService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private DiseaseTypeService diseaseTypeService;

    public Model fillModel(Model model) {
        return model.addAttribute("cities", cityService.findAll())
                .addAttribute("regions", regionService.findAll())
                .addAttribute("streetTypes", streetTypeService.findAll())
                .addAttribute("streetNames", streetNameService.findAll());
    }

    public Model fillStatisticsModel(Model model) {
        return model.addAttribute("diseaseTypes", diseaseTypeService.findAll())
                .addAttribute("diseases", diseaseService.findAllOrderByNameASC())
                .addAttribute("cities", cityService.findAll())
                .addAttribute("streetTypes", streetTypeService.findAll())
                .addAttribute("streetNames", streetNameService.findAll());
    }

    public Model fillDiseaseModel(Model model) {
        return model.addAttribute("diseaseTypes", diseaseTypeService.findAll())
                .addAttribute("diseases", diseaseService.findAllOrderByNameASC());
    }
}
