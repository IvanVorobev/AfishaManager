package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;

    private int presetAfishaLength = 10;

    public AfishaManager(int presetAfishaLength) {
        this.presetAfishaLength = presetAfishaLength;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void addFilm(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] getFilm() {
        PurchaseItem[] items = repository.findAll();
        if (items.length < presetAfishaLength) {
            presetAfishaLength = items.length;
        }
        PurchaseItem[] result = new PurchaseItem[presetAfishaLength];
        for (int i = 0; i < presetAfishaLength; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}



