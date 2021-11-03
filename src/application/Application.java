package application;

import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Application {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Fernando", "11111"));
            put(2, new Contato("Tania", "22222"));
            put(3, new Contato("Elias", "33333"));
            put(4, new Contato("Heloisa", "44444"));
            put(5, new Contato("Davi", "55555"));
        }};
        System.out.println(agenda.toString());
        for (Map.Entry<Integer, Contato> entry:agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }
        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda1 = new TreeMap<>(agenda);
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry:agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }

        System.out.println("--\tOrdem número de telefone\t--");
        //fazendo uso de class anonima;;;;
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return c1.getValue().getContact().compareToIgnoreCase(c2.getValue().getContact());
            }
        });
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getContact() + " - "+ entry.getValue().getName());
        }

        System.out.println("--\tOrdem número de telefone\t--");
        //fazendo uso de class anonima;;;;
        // agora usando uma interface Comparetor.comparing
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, String>() {
                    @Override
                    public String apply(Map.Entry<Integer, Contato> cont){
                        return cont.getValue().getContact();
                    }
                }));

        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set1) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getContact() + " - "+ entry.getValue().getName());
        }

        System.out.println("--\tOrdem número de telefone\t--");
        //fazendo uso de class anonima;;;;
        // agora usando uma interface Comparetor.comparing
        Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(
                //simplificando agora com o Lambda
                 cont -> cont.getValue().getContact()));

        set2.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set2) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getContact() + " - "+ entry.getValue().getName());
        }
    }
}
