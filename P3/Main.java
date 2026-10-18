import java.util.Scanner;

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return false;
    }

    double getTransportFee() {
        return usesBus() ? 12000 : 0;
    }

    double getTotalFee() {
        return calculateFee() + getTransportFee();
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                default:
                    student = new Scholar(name);
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n", totalCollected
        );

        sc.close();
    }
}
