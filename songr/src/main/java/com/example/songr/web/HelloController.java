package com.example.songr.web;

import com.example.songr.Repositories.AlbumRepository;
import com.example.songr.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HelloController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/renderAlbums")
    public String addAlbum() {
//        Album album1 = new Album("Map of the Soul: Persona","BTS",7,"1563","https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png");
//        albumRepository.save(album1);
//        Album album2= new Album("Dreamland","Glass Animals",16,"2710.2","https://thissongissick.com/wp-content/uploads/2020/10/glass-animals.jpeg");
//        albumRepository.save(album2);
//        Album album3=  new Album("Off My Face","Justin Bieber",16,"2715","https://i1.sndcdn.com/artworks-vp1PVnPccRR6makL-JEvmVQ-t500x500.jpg");
//        albumRepository.save(album3);
        return "HomePage";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/hello")
    String hello(){
        System.out.println("The endpoint for work");
        return "helloWorld";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/")
    String HomePage(){
        System.out.println("The endpoint for work");
        return "HomePage";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/capitalize")
    String hello(@PathVariable(name = "name",required = false) String name, Model model){
        System.out.println("capltilize website");
        model.addAttribute("name",name.toUpperCase());
        return "helloWorld";
    }

    @ResponseBody
    @GetMapping("/capitalize/{sentence}")
    public String getEmployeesById(@PathVariable String sentence) {
        return sentence.toUpperCase();
    }

//    @ResponseBody
//    @GetMapping("/albums")
//    ArrayList<Album> getAllUsers() {
//
//        ArrayList<Album> albums = new ArrayList<>();
//        albums.add(new Album("Map of the Soul: Persona","BTS",7,"1563","https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png"));
//        albums.add(new Album("Dreamland","Glass Animals",16,"2710.2","https://thissongissick.com/wp-content/uploads/2020/10/glass-animals.jpeg"));
//        albums.add(new Album("Off My Face","Justin Bieber",16,"2715","https://i1.sndcdn.com/artworks-vp1PVnPccRR6makL-JEvmVQ-t500x500.jpg"));
//
//        return albums;
//    }

    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum( @ModelAttribute @Valid Album album, Errors errors){

        if(errors.hasErrors()){

            return new RedirectView("allAlbum");
        }
                albumRepository.save(album);
                return new RedirectView("allAlbum");


    }

    @GetMapping("/allAlbum")
    public String getAllAlbum(Model model){
        model.addAttribute("albumlist",albumRepository.findAll());
        return "HomePage";
    }
}
