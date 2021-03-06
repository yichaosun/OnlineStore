package logistic.infrastructure.Repositories.TestRepositories;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderState;
import logistic.domain.Services.ClientOrderRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

// @Component
public class ClientOrderTestRepository implements ClientOrderRepository{
    private LinkedList<Order> list;

    public ClientOrderTestRepository() {
        list = new LinkedList<>();
    }

    @Override
    public Order getOrder(int id) {
        return list.stream()
                .filter((Order o)-> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void changeStateToSent(int id) {
        getOrder(id).setState(OrderState.Sent);
    }

    @Override
    public void changeStateToProvided(int id) {
        getOrder(id).setState(OrderState.Provided);
    }
}
