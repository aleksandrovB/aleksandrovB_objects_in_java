package com.clouway;

public class Main {

    public static void main(String[] args) {
//        Sumator sumator = new Sumator();
//
//        System.out.println(sumator.sum("5","3.2"));
//
//        BigDecimal biga = new BigDecimal("13254231523452345324523453245");
//        BigDecimal bigb = new BigDecimal(String.valueOf("123566666623534523452345"));
//
//        int a = 5, b =7;
//
//        System.out.println("int "+sumator.sum(a,b));
//        System.out.println(sumator.sum(biga,bigb));
//
//        System.out.println(sumator.sum(5.122222212,4.455555555555555555555555555));


        BinaryTree tree = new BinaryTree();

        tree.add(6);
        tree.add(3);
        System.out.println(tree.contains(9));
        tree.add(9);
        tree.add(2);
        tree.add(9);
        System.out.println(tree.contains(9));
        tree.printElements("asd");
    }
}
