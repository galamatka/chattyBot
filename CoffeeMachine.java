import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a = true;

        Action.getStock();
        
        do {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    Action.buy();
                    break;
                case "fill":
                    Action.fill();
                    break;
                case "take":
                    Action.take();
                    break;
                case "remaining":
                    Action.printStatus();
                    break;
                case  "exit":
                    a = false;
                    break;
            }
        } while (a == true);
    }
}


enum Products {

    ESPRESSO (250, 0, 16, 1, 4),
    LATTE (350, 75, 20, 1, 7),
    CAPUCCINO (200, 100, 12, 1, 6);

    int water;
    int milk;
    int beans;
    int cups;
    int money;

    Products (int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }
}

class Action {

    static int stockWater;
    static int stockMilk;
    static int stockBeans;
    static int stockCups;
    static int stockMoney;

    public Action (int stockWater, int stockMilk, int stockBeans, int stockCups, int stockMoney) {
        this.stockWater = stockWater;
        this.stockMilk = stockMilk;
        this.stockBeans = stockBeans;
        this.stockCups = stockCups;
        this.stockMoney =stockMoney;
    }

    static void getStock() {
        stockWater = 400;
        stockMilk = 540;
        stockBeans = 120;
        stockCups = 9;
        stockMoney = 550;
    }


    static void printStatus() {
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(stockWater + " of water");
        System.out.println(stockMilk + " of milk");
        System.out.println(stockBeans + " of coffee beans");
        System.out.println(stockCups + " of disposable cups");
        System.out.println(stockMoney + " of money");
    }

    static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String product = scanner.next();

        switch (product) {
            case "1":
                if (stockWater >= Products.ESPRESSO.water 
                	&& stockBeans >= Products.ESPRESSO.beans 
                	&& stockCups >= Products.ESPRESSO.cups) {
                    stockWater -= Products.ESPRESSO.water;
                    stockBeans -= Products.ESPRESSO.beans;
                    stockCups -= Products.ESPRESSO.cups;
                    stockMoney += Products.ESPRESSO.money;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (stockWater < Products.ESPRESSO.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (stockBeans < Products.ESPRESSO.beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (stockCups < Products.ESPRESSO.cups) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "2":
                if (stockWater >= Products.LATTE.water && stockMilk >= Products.LATTE.milk && stockBeans >= Products.LATTE.beans && stockCups >= Products.LATTE.cups) {
                    stockWater -= Products.LATTE.water;
                    stockMilk -= Products.LATTE.milk;
                    stockBeans -= Products.LATTE.beans;
                    stockCups -= Products.LATTE.cups;
                    stockMoney += Products.LATTE.money;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (stockWater < Products.LATTE.water) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                } else if (stockMilk < Products.LATTE.milk) {
                    System.out.println("Sorry, not enough milk!");
                } else if (stockBeans < Products.LATTE.beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (stockCups < Products.LATTE.cups) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "3":
                if (stockWater >= Products.CAPUCCINO.water && stockMilk >= Products.CAPUCCINO.milk && stockBeans >= Products.CAPUCCINO.beans && stockCups >= Products.CAPUCCINO.cups) {
                    stockWater -= Products.CAPUCCINO.water;
                    stockMilk -= Products.CAPUCCINO.milk;
                    stockBeans -= Products.CAPUCCINO.beans;
                    stockCups += Products.CAPUCCINO.cups;
                    stockMoney += Products.CAPUCCINO.money;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (stockWater < Products.CAPUCCINO.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (stockMilk < Products.CAPUCCINO.milk) {
                    System.out.println("Sorry, not enough milk!");
                } else if (stockBeans < Products.CAPUCCINO.beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (stockCups < Products.CAPUCCINO.cups) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "back":
                break;
        }
    }

    static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        int addWater = scanner.nextInt();
        stockWater += addWater;
        System.out.println("Write how many ml of milk do you want to add: ");
        int addMilk = scanner.nextInt();
        stockMilk += addMilk;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addBeans = scanner.nextInt();
        stockBeans += addBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int addCups = scanner.nextInt();
        stockBeans += addCups;
    }

    static void take() {
        System.out.println("I gave You " + stockMoney);
        stockMoney = 0;
    }
}
