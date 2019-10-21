
package fr.epita.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import fr.epita.entite.Livre;
import fr.epita.service.LivreService;


@RestController
public class LivreController  {
     @Autowired LivreService livrservice;
     
     @RequestMapping("/enregistrer")
     public void enregistrerLivre() {
    	 Livre l=new Livre();
    	 l.setTitre("les miserables");
    	 livrservice.enregistrerLivre(l);
     }
/*     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("swagger-ui.html")
           .addResourceLocations("classpath:/META-INF/resources/");
      
         registry.addResourceHandler("/webjars/**")
           .addResourceLocations("classpath:/META-INF/resources/webjars/");
     }
     */
}


