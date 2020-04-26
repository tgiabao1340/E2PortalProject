package se.iuh.e2portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import se.iuh.e2portal.model.Announcement;
import se.iuh.e2portal.service.AnnouncementService;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
	
    @Autowired
    private AnnouncementService announcementService;
    
    @GetMapping("")
    public String getAnnouncements(@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<Announcement> page = announcementService.findAll(pageable);
        model.addAttribute("page", page);
        return "announcement";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAnnouncement(Model model){
        model.addAttribute("announcement", new Announcement());
        return "addAnnouncement";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAnnouncement(Announcement announcement){
        announcement.setCreatedDate(new Date());
        announcementService.save(announcement);
        return "redirect:/announcement";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editAnnouncement(@RequestParam("id") Long id, Model model) {
        Optional<Announcement> announcementEdit = announcementService.findById(id);
        announcementEdit.ifPresent(announcement -> model.addAttribute("announcement", announcement));
        return "addAnnouncement";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAnnouncement(@RequestParam("id") Long id, Model model){
        announcementService.deleteById(id);
        return "redirect:/announcement";

    }
}
