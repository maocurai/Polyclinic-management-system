package com.example.springApp.controller;

import com.example.springApp.domain.City;
import com.example.springApp.domain.Disease;
import com.example.springApp.repos.StatisticsRepo;
import com.example.springApp.service.DiseaseService;
import com.example.springApp.util.ModelFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.IntStream;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private ModelFiller controller;

    @Autowired
    private StatisticsRepo statisticsRepo;

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/diseaseInRegions")
    public String getStatistics(@RequestParam(value = "diseaseId", required = false) Disease disease, Model model) {
        controller.fillStatisticsModel(model);
        if(disease != null) { model.addAttribute("currDisease", disease); }
        model.addAttribute("diseases", diseaseService.findAll());
        model.addAttribute("patientsWithDiseaseByPatientAddress", statisticsRepo.countPatientsWithDiseaseInRegionsByPatientAddress(((disease == null) ? Long.valueOf(0) : disease.getId())));
        model.addAttribute("patientsWithDisease", statisticsRepo.countPatientsWithDiseaseInRegions(((disease == null) ? Long.valueOf(0) : disease.getId())));
        return "statisticsItem1";
    }

    @GetMapping("/patientsInMedicalInstitutions")
    public String getPatientsInMedicalInstitutions(@RequestParam(value = "cityId", required = false) City city, Model model) {
        controller.fillStatisticsModel(model);
        if(city != null) { model.addAttribute("currCity", city); }
        model.addAttribute("patientsInMedicalInstitutions", statisticsRepo.countPatientsInMedicalInstitutionByCity(((city == null) ? Long.valueOf(0) : city.getId())));
        return "statisticsItem2";
    }

    @GetMapping("/certificatesOfIllnessByMonth")
    public String getPatientsInMedicalInstitutions(@RequestParam(value = "monthId", required = false, defaultValue = "12") String monthId,
                                                   @RequestParam(value = "yearId", required = false, defaultValue = "2021") String yearId, Model model) {
        controller.fillStatisticsModel(model);
        model.addAttribute("certificatesOfIllnessByMonth", statisticsRepo.countCertificatesOfIllnessByMonth(Integer.parseInt(monthId), Integer.parseInt(yearId.trim())))
                .addAttribute("monthNumbers", IntStream.range(1, 13).iterator())
                .addAttribute("years", statisticsRepo.findAllYears())
                .addAttribute("selectedMonth", monthId)
                .addAttribute("selectedYear", yearId);
        return "statisticsItem3";
    }

    @GetMapping
    public String menu(Model model) {
        return "statisticsMenu";
    }

}
