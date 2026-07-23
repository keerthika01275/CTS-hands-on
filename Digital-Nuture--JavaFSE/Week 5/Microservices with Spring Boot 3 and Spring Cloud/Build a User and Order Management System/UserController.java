@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
