package com.proiect.Services;
import com.proiect.Promo.Promo;
import com.proiect.persistance.PromoRepository;

import java.util.List;

public class PromoService{
    private static PromoService instance;

    private final PromoRepository userRepository = PromoRepository.getInstance();

    private PromoService() {
    }

    public static PromoService getInstance() {
        if (instance == null) {
            instance = new PromoService();
        }

        return instance;
    }

    public void savePromo(Promo promo) {
        userRepository.savePromo(promo);
    }

    public List<Promo> findPromos() {
        return userRepository.findPromos();
    }

    public List<Promo> findPromoPrice(int price) {
        return userRepository.findPromoPrice(price);
    }

    public void updatePromo(int price, String name){ userRepository.updatePromo(price,name);}
    public void deletePromo(String name) {
        userRepository.deletePromo(name);
    }
    public void display(List<Promo> l) {
        for (Promo oferta : l) {
            System.out.println("Tipul mesei:");
            System.out.println(oferta.getBoardTypes());
            System.out.println("Numarul de zile al sejurului:");
            System.out.println(oferta.getNumberOfdays());
            System.out.println("Pretul total al ofertei:");
            System.out.println(oferta.getPrice());
            System.out.println("Oras:");
            System.out.println(oferta.getCity().getNameCity());
            System.out.println("Tara:");
            System.out.println(oferta.getCity().getCountry());
        }
    }
}
