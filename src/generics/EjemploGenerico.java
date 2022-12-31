package generics;

import poointerfaces.modelo.Cliente;
import poointerfaces.modelo.ClientePremiun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenerico {
    public static void main(String[] args) {
        List <Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres","Guzman"));
        Cliente andres = clientes.iterator().next();

        Cliente[] clientesArreglo={new Cliente("Luci","Martinez"),
                new Cliente("Andres","Guzman")};

        Integer[] enteroArreglo = {1,2,3};

        List<Cliente> clienteLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enteroArreglo);

        clienteLista.forEach(System.out::println);
        System.out.println();
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andres","Pepe",
                "Luci","Bea","John"},enteroArreglo);

        nombres.forEach(System.out::println);

        List<ClientePremiun> clientePremiunList = fromArrayToList(
                new ClientePremiun[]{new ClientePremiun(
                        "Paco","Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clienteLista);
        imprimirClientes(clientePremiunList);


        System.out.println("\nMaximo de 1, 9 y 4 es: "+ maximo(1,9,4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es: "+ maximo(3.9,11.6,7.78));
        System.out.println("Maximo de zanahorias, arandanos y manzana es: "+maximo("zanahoria","arandanos","manzana"));
    }



    private static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }
    public static <T extends  Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T, G> List<T> fromArrayToList(T[]c,G[] x){
        for (G elemento:x){
            System.out.println(elemento);
        }
        return  Arrays.asList(c);
    }
    public  static void imprimirClientes(List<? extends Cliente> clientes){
        System.out.println();
        clientes.forEach(System.out::println);

    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max=a;
        if (b.compareTo(max)>0){
            max=b;
        }
        if (c.compareTo(max)>0){
          max=c;
        }
        return max;
    }
}
