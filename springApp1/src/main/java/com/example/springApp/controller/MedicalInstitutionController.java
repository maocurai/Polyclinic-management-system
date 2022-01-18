package com.example.springApp.controller;

import com.example.springApp.DTO.MedicalInstitutionDTO;
import com.example.springApp.domain.Address;
import com.example.springApp.domain.City;
import com.example.springApp.domain.MedicalInstitution;
import com.example.springApp.service.AddressService;
import com.example.springApp.service.CityService;
import com.example.springApp.service.MedicalInstitutionService;
import com.example.springApp.service.PatientService;
import com.example.springApp.util.ModelFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicalInstitution")
public class MedicalInstitutionController {
    @Autowired
    private MedicalInstitutionService medicalInstitutionService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ModelFiller controller;

    @Autowired
    private CityService cityService;

    @Autowired
    private AddressService addressService;

    @GetMapping
    public String list(@RequestParam(value = "cityId", required = false) City city, Model model) {
        model.addAttribute("cities", cityService.findCitiesWithMedicalInstitutions());
        if(city == null) {
            model.addAttribute("medicalInstitutions", medicalInstitutionService.findAll().stream().filter(x -> !x.isDeleted()).iterator());
        } else {
            model.addAttribute(model.addAttribute("medicalInstitutions",
                    medicalInstitutionService.findAll().stream()
                            .filter(x -> (x.getAddress().getCity().getName().equals(city.getName()) && !x.isDeleted()))
                            .iterator()))
                    .addAttribute("currCity", city);
        }
        return "medicalInstitution";
    }

    @GetMapping("{medicalInstitution}")
    public String editForm(@PathVariable MedicalInstitution medicalInstitution, Model model) {
        Address address = medicalInstitutionService.findById(medicalInstitution.getId()).getAddress();
        controller.fillModel(model).addAttribute("medicalInstitutionToEdit", medicalInstitution)
                .addAttribute("requestType", "edit")
                .addAttribute("currentAddress", address);
        return "medicalInstitutionEdit";
    }

    @GetMapping("/add")
    public String editForm(Model model) {
        controller.fillModel(model).addAttribute("currentAddress", new Address())
                .addAttribute("medicalInstitutionToEdit", new MedicalInstitution())
                .addAttribute("requestType", "add");
        return "medicalInstitutionEdit";
    }

    @PostMapping("/update")
    public String update(MedicalInstitutionDTO medicalInstitutionDTO, @RequestParam(value = "medicalInstitutionId", required = false) MedicalInstitution medicalInstitution) {
        if(medicalInstitution == null) {
            medicalInstitutionService.save(new MedicalInstitution(medicalInstitutionDTO.getName(), addressService.create(medicalInstitutionDTO), false));
        } else {
            MedicalInstitution edited = medicalInstitutionService.findById(medicalInstitution.getId());
            addressService.fill(medicalInstitutionDTO, edited.getAddress());
            edited.setName(medicalInstitutionDTO.getName());
            medicalInstitutionService.save(edited);
        }
        return "redirect:/medicalInstitution";
    }

    @GetMapping("/info/{medicalInstitution}")
    public String info(@PathVariable MedicalInstitution medicalInstitution, Model model) {
        model.addAttribute("medicalInstitution", medicalInstitutionService.findById(medicalInstitution.getId()))
                .addAttribute("patients", patientService.findByMedicalInstitution(medicalInstitution.getId()).stream().filter(x -> !x.isDeleted()).iterator());
        return "medicalInstitutionInfo";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("medicalInstitutionId") MedicalInstitution medicalInstitution) {
        medicalInstitutionService.deleteById(medicalInstitution.getId());
        return "redirect:/medicalInstitution";
    }
}
