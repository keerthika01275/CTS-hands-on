@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }
}
