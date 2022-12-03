package peaksoft.taskspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.service.CompanyService;
import peaksoft.taskspringboot.model.Company;

import java.io.IOException;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAll")
    public String getAllCompanies(Model model){
        model.addAttribute("companies",companyService.getAllCompany());
        return "/company/allCompany";
    }

    @GetMapping("/new")
    public String addCompany(Model model){
        model.addAttribute("newCompany",new Company());
        return "/company/newCompany";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) throws IOException {
        companyService.saveCompany(company);
        return "redirect:/companies/getAll";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("/company/updateCompany");
        Company company=companyService.getById(id);
        modelAndView.addObject("company",company);
        return modelAndView;
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return "redirect:/companies/getAll";
    }

    @GetMapping("/num")
    public String getNumberOfStudents(){
        companyService.numberOfStudents();
        return "redirect:/companies/getAll";
    }
}
