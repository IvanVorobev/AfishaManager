package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class AfishaManager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int presetAfishaLength = 10;

    public AfishaManager() {
    }

    public AfishaManager(int presetAfishaLength) {
        this.presetAfishaLength = presetAfishaLength;
    }

    public void addFilm(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getFilm() {
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

