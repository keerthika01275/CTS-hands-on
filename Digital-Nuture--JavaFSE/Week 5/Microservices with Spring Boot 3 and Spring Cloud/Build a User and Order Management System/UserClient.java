@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface UserClient {
    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);
}
