package com.fisher.practice02.ssm.handle;

import com.fisher.practice02.ssm.entry.Soldier;
import com.fisher.practice02.ssm.service.api.SoldierService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Soldier处理类 -> SoldierService CRUD
 * @author fisher
 * @version 1.0.1 2023/6/25 - 17:34
 */
@Controller
public class SoldierHandler {

    private final SoldierService soldierService;

    public SoldierHandler(@Qualifier("soldierServiceImpl") SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    //show all soldier
    @RequestMapping(value = "/get/page/{pageNo}")
    public String getPage(
            @PathVariable Integer pageNo,
            Model model){
        PageInfo<Soldier> pageInfo = soldierService.getPageInfo(pageNo);

        model.addAttribute("pageInfo", pageInfo);

        return "soldier-page";
    }

    @RequestMapping(value = "/get/all")
    public String showAllInfo(Model model){

        List<Soldier> allSoldiers = soldierService.getAllSoldiers();

        model.addAttribute("allSoldiers", allSoldiers);

        return "all-list";
    }

    //Create a soldier info
    @RequestMapping(value = "/add/soldier")
    public String addOneSoldierInfo(
            @RequestParam("soldierName") String soldierName,
            @RequestParam("soldierWeapon") String soldierWeapon){

        Soldier soldier = new Soldier(null,soldierName,soldierWeapon);

        //Service 层 功能
        soldierService.addSoldier(soldier);

        return "redirect:/get/all";
    }

    @RequestMapping(value = "/add/soldier/page")
    public String addPage(){
        return "add-soldier";
    }

    @RequestMapping(value = "/edit/page/{soldierId}")
    public String editPage(
            @PathVariable Integer soldierId,
            Model model){

        Soldier soldierById = soldierService.getSoldierById(soldierId);

        model.addAttribute("soldierById",soldierById);

        return "edit-soldier";
    }

    //update soldier info.
    @RequestMapping(value = "/edit/soldier/info")
    public String editSoldierInfo(
            @RequestParam("soldierID") Integer soldierId,
            @RequestParam("soldierName") String soldierName,
            @RequestParam("soldierWeapon") String soldierWeapon){

        Soldier soldier = new Soldier(soldierId,soldierName,soldierWeapon);
        //Service 层 功能
        soldierService.updateSoldier(soldier);

        return "redirect:/get/all";
    }

    //delete a soldier info
    @RequestMapping(value = "/delete/soldier/info/{soldierId}")
    public String deleteSoldierInfo(
            @PathVariable("soldierId") Integer soldierId){

        //Service 层 功能
        soldierService.removeSoldier(soldierId);

        return "redirect:/get/all";
    }

}
