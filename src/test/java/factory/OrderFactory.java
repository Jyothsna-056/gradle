package factory;


import modles.Order;
import repository.OrderRepository;

public class OrderFactory {

    private final OrderRepository repository;

    public OrderFactory(OrderRepository repo) {
        this.repository = repo;
    }

    public Order persisted(Order order) {
        repository.save(order);
        return order;
    }
}