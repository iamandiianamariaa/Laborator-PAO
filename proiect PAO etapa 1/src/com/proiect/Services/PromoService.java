package com.proiect.Services;

import java.util.List;
import com.proiect.Promo.Promo;

public class PromoService implements Service {

    private List<Promo> oferte;

    public PromoService(List<Promo> oferte) {
        this.oferte= oferte;

    }

    @Override
    public void display() {
        for (Promo oferta : oferte) {
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

    @Override
    public void add(Object o) {
        oferte.add((Promo) o);

    }
    @Override
    public void display(int i) {
        System.out.println("Tipul mesei:");
        System.out.println(oferte.get(i).getBoardTypes());
        System.out.println("Numarul de zile al sejurului:");
        System.out.println(oferte.get(i).getNumberOfdays());
        System.out.println("Pretul total al ofertei:");
        System.out.println(oferte.get(i).getPrice());
        System.out.println("Oras:");
        System.out.println(oferte.get(i).getCity().getNameCity());
        System.out.println("Tara:");
        System.out.println(oferte.get(i).getCity().getCountry());
    }
    @Override
    public void remove(Object o) {oferte.remove(o);

    }

    @Override
    public void remove(int i) {
        oferte.remove(i);
    }
}
