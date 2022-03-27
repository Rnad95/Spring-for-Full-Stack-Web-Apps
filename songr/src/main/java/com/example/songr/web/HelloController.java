package com.example.songr.web;

import com.example.songr.Repositories.AlbumRepository;
import com.example.songr.Repositories.PostRepository;
import com.example.songr.Repositories.SongRepository;
import com.example.songr.Repositories.UsersRepository;
import com.example.songr.domain.Album;
import com.example.songr.domain.Post;
import com.example.songr.domain.Song;
import com.example.songr.domain.Users;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class HelloController {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    public HelloController(AlbumRepository albumRepository, SongRepository songRepository, PostRepository postRepository, UsersRepository usersRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;
    }


    @GetMapping("/renderAlbums")
    public String addAlbum() {
        Album album1 = new Album("Map of the Soul: Persona","BTS",7,"1563","https://i.pinimg.com/originals/c4/6c/c2/c46cc23adeec3ca1603d7c79a742a4ef.png");
        albumRepository.save(album1);
        Album album2= new Album("Dreamland","Glass Animals",16,"2710.2","https://thissongissick.com/wp-content/uploads/2020/10/glass-animals.jpeg");
        albumRepository.save(album2);
        Album album3=  new Album("Off My Face","Justin Bieber",16,"2715","https://i1.sndcdn.com/artworks-vp1PVnPccRR6makL-JEvmVQ-t500x500.jpg");
        albumRepository.save(album3);
        return "HomePage";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/hello")
    public String hello(){
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

    //***************************************** song ***********************************************/

    @ResponseBody
    @PostMapping("/albums")
    Album addNewSongToAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @ResponseBody
    @GetMapping("/albums")
    List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/allSong")
    public String getAllSong(Model model){
        model.addAttribute("songList",songRepository.findAll());

        return "songsPage";
    }

    @ResponseBody
    @PostMapping("/albums/{id}")
    Song addNewSongToAlbum(@RequestBody Song song, @PathVariable Integer id) {
        Album album = albumRepository.findById(id).orElseThrow();
        song.setAlbum(album);
        return songRepository.save(song);
    }


    @GetMapping("/album/{id}/songs")
     String findSongsOfAlbum(Model model,@PathVariable Integer id) {
       model.addAttribute("songsList",songRepository.findAllByAlbum_Id(id));

        return "AlbumDetails";
    }

    @PostMapping("/addSong")
    public RedirectView createNewSong( @ModelAttribute @Valid Song song, Errors errors){

        if(errors.hasErrors()){
            System.out.println("Error");
            return new RedirectView("allSong");
        }
        songRepository.save(song);
        return new RedirectView("allSong");

    }


    //**************************** Render Posts ************************

    @PostMapping("/addPost")
    public RedirectView createNewPost( @ModelAttribute @Valid Post post, Errors errors){

        if(errors.hasErrors()){

            return new RedirectView("allPost");
        }
        postRepository.save(post);
        return new RedirectView("allPost");

    }

    @GetMapping("/allPost")
    public String getAllPost(Model model){
        model.addAttribute("postList",postRepository.findAll());
        return "helloWorld";
    }

    //**************************** User and Posts ***********************
    @ResponseBody
    @PostMapping("/users")
    Users createNewUser(@RequestBody Users newUser){
        return usersRepository.save(newUser);
    }

    @ResponseBody
    @PostMapping("/posts")
    Post createNewUser(@RequestBody Post newPost){
        return postRepository.save(newPost);
    }

    @ResponseBody
    @GetMapping("/Allposts")
    List<Post> getAllPosts() {
        return  postRepository.findAll();
    }


    @ResponseBody
    @PutMapping("/posts/{postId}/user-post/{userId}")
    Post userAndPost(@PathVariable Integer postId,@PathVariable Integer userId ){
        Post post = postRepository.findById(postId).orElseThrow();
        Users users = usersRepository.findById(userId).orElseThrow();
        users.setUser(post);
        usersRepository.save(users);
//        postRepository.save(post);
        return post;
    }

    //********************************* LOG IN ****************************************

    @GetMapping("/login")
    String loginPage(){
        return "/login.html";
    }

    @PostMapping("/login")
    public RedirectView logInUser(String username, String password)
    {
        Users userFromDb = usersRepository.findByUsername(username);

        if ((userFromDb == null) || (!BCrypt.checkpw(password, userFromDb.getHashedPassword()))) {
            return new RedirectView("/login");
        }

        return new RedirectView("/helloWorld");
    }


    //*********************************** Sign UP *************************************

    @GetMapping("/signup")
    public String getSignupPage()
    {
        return "/signup.html";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(Model m, String username, String password)
    {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        Users newChatUser = new Users(username, hashedPassword);

        usersRepository.save(newChatUser);
        return new RedirectView("/login");
    }


}