import product.Product;
import product.Unit;
import product.type.ProductBottle;
import product.type.ProductKilo;
import product.type.ProductPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Shop shop;
    private static Scanner scanner;
    private static String partName;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        shop = new Shop(new ArrayList<>());
        int mainNumber;

        initProducts();

        while (true) {
            printMain();
            mainNumber = scanner.nextInt();
            scanner.nextLine();

            if (mainNumber == 0)
                break;

            if (mainNumber < 1 || mainNumber > 5) {
                System.out.println("Указано значение за пределами меню!");
                continue;
            }

            startTask(mainNumber);
            System.out.println();
        }
    }

    public static void printMain() {
        System.out.println("Меню");
        System.out.println("1. Показ всех доступных товаров");
        System.out.println("2. Вывод товаров по слову");
        System.out.println("3. Вывод товаров по поставщику");
        System.out.println("4. Добавить новый товар");
        System.out.println("5. Продать товар");
        System.out.println("0. Выход");
    }

    public static void startTask(int mainNumber) {
        switch (mainNumber) {
            case 1:
                shop.printAllProducts();
                break;
            case 2:
                printProductsWithNameOrMarker(false);
                break;
            case 3:
                printProductsWithNameOrMarker(true);
                break;
            case 4:
                addNewProduct();
                break;
            case 5:
                buyProduct();
                break;
        }
    }

    public static void initProducts() {
        shop.addProduct(new ProductPiece("Хлеб белый", 10, 30.00, "Газпром"));
        shop.addProduct(new ProductPiece("Хлеб черный", 10, 30.00, "Газпром"));
        shop.addProduct(new ProductBottle("Питьевая вода 5л", 20, 60.00, "Святой источник", "не алкоголь"));
        shop.addProduct(new ProductBottle("Сок яблочный 1л", 20, 100.00, "Святой источник", "не алкоголь"));
        shop.addProduct(new ProductKilo("Конфеты \"Сладкоешка\"", 5, 100.00, "Ашан"));
        shop.addProduct(new ProductPiece("Конфеты \"Коркунов\"", 10, 400.00, "Что-то вкусное"));
    }

    public static void addNewProduct() {
        int count;
        Unit unit = null;
        String name;
        String maker;
        double price;
        List<Unit> units;
        boolean isDrink;
        String alcohol;


        System.out.print("Введите имя продукта: ");
        name = scanner.nextLine();

        System.out.println("Напишите единицу продукта:");
        units = Arrays.asList(Unit.values());
        for (int i = 0; i < units.toArray().length; i++) {
            System.out.println(i + 1 + ": " + units.get(i) + ".");
        }


        while (true) {
            try {
                unit = Unit.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильно указано значение! Прошу, повторите попытку!");
            }
        }

        System.out.print("Введите количество продуктов: ");
        count = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите стоимость одной единицы продукта: ");
        price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите имя производителя продукта: ");
        maker = scanner.nextLine();

        switch (unit) {
            case PIECE:
                shop.addProduct(new ProductPiece(name, count, price, maker));
                break;
            case KILO:
                shop.addProduct(new ProductKilo(name, count, price, maker));
                break;
            case BOTTLE:
                System.out.println("Это алкогольный напиток?");
                alcohol = scanner.nextLine();
                shop.addProduct(new ProductBottle(name, count, price, maker, alcohol));
                break;
        }

        System.out.println("Продукт создан");
    }

    public static void buyProduct() {
        Product findProduct;
        int count;

        while (true) {
            System.out.print("Введите название продукта: ");
            String name = scanner.nextLine();
            List<Product> findProducts = shop.getProducts().stream().filter(product -> product.getName().toLowerCase().contains(name)).toList();
            if (findProducts.size() == 1) {
                findProduct = findProducts.get(0);
                break;
            } else {
                System.out.println("Некорректно введено название товара:  найдено следующее кол-во товаров:  " + findProducts.size() + ".");
            }
        }

        if (findProduct.getCount() == 0) {
            System.out.println("Товар закончился!");
            return;
        }

        while (true) {
            System.out.print("Введите количество покупаемого товара: ");
            count = scanner.nextInt();

            if (findProduct.getCount() >= count && count > 0)
                break;
            else {
                System.out.println("Указано некорректное кол-во товаров: " + count);
            }
        }

        findProduct.setCount(count);
        System.out.println("Было продано товара \"" + findProduct.getName() + "\" в кол-ве \"" + count + "\" и на сумму "
                + findProduct.getPrice() * count + " руб.");
    }

    public static void printProductsWithNameOrMarker(boolean isMaker) {
        System.out.print("Введите слово: ");
        partName = scanner.nextLine().toLowerCase();
        shop.printProductsWithSameNameOrMarker(partName, isMaker);
    }
}