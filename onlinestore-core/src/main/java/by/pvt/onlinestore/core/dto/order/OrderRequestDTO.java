package by.pvt.onlinestore.core.dto.order;

import by.pvt.onlinestore.core.domain.Status;

import java.util.Objects;

public class OrderRequestDTO {
    private Long id;
    private Long userId;
    private Long totalCost;
    private Status status;

    public OrderRequestDTO() {

    }

    public OrderRequestDTO(Long id, Long userId, Long totalCost, Status status) {
        this.id = id;
        this.userId = userId;
        this.totalCost = totalCost;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequestDTO that = (OrderRequestDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(totalCost, that.totalCost) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, totalCost, status);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderRequestDTO{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
