package sg.edu.nus.iss.day13workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day13workshop.models.Contact;
import sg.edu.nus.iss.day13workshop.services.DatabaseService;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/contact")
public class ContactController {

    @Autowired
    private DatabaseService dbSvc;

    //in the consumes, you choose what kind you want. eg, pdf, or png, images etc. so for this one, you specify form. it is called MIME type.
    @PostMapping(consumes="application/x-www-form-urlencoded", produces = "text/html")
    public String postContact (@RequestBody MultiValueMap<String, String> form, Model model) {
        
        Contact c = new Contact();
        c.setName(form.getFirst("name"));
        c.setEmail(form.getFirst("email"));
        c.setPhone(form.getFirst("phone"));

        System.out.printf("Contact %s:", c);
        dbSvc.save(c);

        model.addAttribute("contact", c);
        
        return "showContact";
    }
        //this code - when you want to access the url from the unique id given, and it will show all the contact details
        //path variable eg. /contact/607d8f20 
        @GetMapping(value="/{id}", produces = "text/html")
        public String getContact (@PathVariable("id") String id, Model model) {

            Contact c = new Contact();

            c = dbSvc.read(id);
            System.out.printf("> id: %s", c);

            model.addAttribute("contact", c);
            return "showContact";
        }

    
}
