@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        userClient.getUser(order.getUserId());
        return repo.save(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}
