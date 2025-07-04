package domain.product.interfaces;

import java.time.LocalDate;


public interface Expirable {
    public boolean isExpired();
    public void setExpirationDate(LocalDate expirationDate);
    public LocalDate getExpirationDate();
}
