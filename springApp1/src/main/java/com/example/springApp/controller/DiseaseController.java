package com.example.springApp.controller;

import com.example.springApp.domain.*;
import com.example.springApp.service.DiseaseService;
import com.example.springApp.service.DiseaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private DiseaseTypeService diseaseTypeService;

    @Autowired
    private UtilityController controller;

    @GetMapping()
    public String menu() {
        return "diseaseMenu";
    }

    @GetMapping(value = {"/addDisease", "/addDisease/{disease}"})
    public String formAddDisease(@PathVariable(required = false) Disease disease, Model model) {
        controller.fillDiseaseModel(model);
        if(disease != null) {
            model.addAttribute("exists", true)
                    .addAttribute("existingDisease", disease);
        }
        return "addDisease";
    }

    @GetMapping(value = {"/addDiseaseType", "/addDiseaseType/{diseaseType}"} )
    public String formAddDiseaseType(@PathVariable(required = false) DiseaseType diseaseType, Model model) {
        controller.fillDiseaseModel(model);
        if(diseaseType != null) {
            model.addAttribute("exists", true)
                    .addAttribute("existingDiseaseType", diseaseType);
        }
        return "addDiseaseType";
    }

    @PostMapping("/createDisease")
    public String addDisease(@RequestParam("diseaseTypeId") DiseaseType diseaseType,
                             @RequestParam("diseaseName") String diseaseName,
                             Model model) {
        Disease byName = diseaseService.findByName(diseaseName);
        if(byName == null) {
            diseaseService.save(new Disease(diseaseName, diseaseType));
        } else {
            return ("redirect:/disease/addDisease/" + byName.getId());
        }
        controller.fillDiseaseModel(model);
        return "redirect:/disease";
    }

    @PostMapping("/createDiseaseType")
    public String addDiseaseType(@RequestParam("diseaseTypeName") String diseaseTypeName,
                             Model model) {
        DiseaseType byName = diseaseTypeService.findByName(diseaseTypeName);
        if(byName == null) {
            diseaseTypeService.save(new DiseaseType(diseaseTypeName));
        } else {
            return ("redirect:/disease/addDiseaseType/" + byName.getId());
        }
        controller.fillDiseaseModel(model);
        return "redirect:/disease";
    }
}
