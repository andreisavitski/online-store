package by.pvt.onlinestore.core.repository.impl.file;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.repository.BasketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasketFileRepository extends FileWorker implements BasketRepository {
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\baskets.txt";

    @Override
    public Basket addBasket(Basket basket) {
        List<Basket> basketList = getBaskets();
        basket.setBasketId((long) (basketList.size() + 1));
        List<Basket> baskets = getBaskets();
        baskets.add(basket);
        serializeObject(baskets, PATH);
        return basket;
    }

    @Override
    public void deleteBasketById(Long id) {
        List<Basket> baskets = getBaskets();
        if (baskets.isEmpty()) return;
        baskets.remove((int) (id - 1));
        serializeObject(baskets, PATH);
    }

    @Override
    public Basket getBasketById(Long id) {
        try {
            return getBaskets().stream().filter(a -> Objects.equals(a.getBasketId(), id)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Basket with given Id does not exist.");
        }
    }

    @Override
    public List<Basket> getAllBasketsByOrderId(Long id) {
        List<Basket> baskets = getBaskets();
        return baskets.stream().filter(basket -> basket.getOrderId().equals(id)).toList();
    }

    @Override
    public Basket updateBasket(Basket basket) {
        List<Basket> baskets = getBaskets();
        baskets.set((int) (basket.getBasketId() - 1), basket);
        serializeObject(baskets, PATH);
        return null;
    }

    @Override
    public void deleteBasketByOrderId(Long id) {
        List<Basket> baskets = getBaskets();
        List<Basket> basketsAfterFilter = baskets.stream().filter(basket -> !basket.getOrderId().equals(id)).toList();
        serializeObject(basketsAfterFilter, PATH);
    }

    @Override
    public void deleteBasketByOrderIdAndProductId(Basket basket) {
        List<Basket> baskets = getBaskets();
        if (baskets.isEmpty()) return;
        List<Basket> basketsAfterFilter = baskets.stream().filter(basket1 -> basket1.getOrderId().equals(basket.getOrderId())).filter(basket1 -> basket1.getProductId().equals(basket.getProductId())).toList();
        serializeObject(basketsAfterFilter, PATH);
    }

    @Override
    public List<Basket> getAllBaskets() {
        return getBaskets();
    }

    private List<Basket> getBaskets() {
        Object o = deserializeObject(PATH);
        List<Basket> baskets = new ArrayList<>();
        if (o instanceof List<?>) {
            baskets = (List<Basket>) o;
        }
        return baskets;
    }
}
