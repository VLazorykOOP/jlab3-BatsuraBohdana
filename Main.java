import java.util.*;

class Organization {
    protected String name;
    protected String address;

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void Show() {
        System.out.println("Організація: " + name);
        System.out.println("Адреса: " + address);
    }
}

class InsuranceCompany extends Organization {
    private String licenseNumber;
    private String insuranceType;

    public InsuranceCompany(String name, String address, String licenseNumber, String insuranceType) {
        super(name, address);
        this.licenseNumber = licenseNumber;
        this.insuranceType = insuranceType;
    }

    @Override
    public void Show() {
        System.out.println("=== Страхова компанія ===");
        super.Show();
        System.out.println("Ліцензія: " + licenseNumber);
        System.out.println("Тип страхування: " + insuranceType);
    }
}

class OilGasCompany extends Organization {
    private int numberOfWells;
    private double dailyProduction;

    public OilGasCompany(String name, String address, int numberOfWells, double dailyProduction) {
        super(name, address);
        this.numberOfWells = numberOfWells;
        this.dailyProduction = dailyProduction;
    }

    @Override
    public void Show() {
        System.out.println("=== Нафтогазова компанія ===");
        super.Show();
        System.out.println("Кількість свердловин: " + numberOfWells);
        System.out.println("Добовий видобуток (тон): " + dailyProduction);
    }
}

class Factory extends Organization {
    private String productType;
    private int employees;

    public Factory(String name, String address, String productType, int employees) {
        super(name, address);
        this.productType = productType;
        this.employees = employees;
    }

    @Override
    public void Show() {
        System.out.println("=== Завод ===");
        super.Show();
        System.out.println("Тип продукції: " + productType);
        System.out.println("Кількість працівників: " + employees);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Organization[] orgs = new Organization[3];

        orgs[0] = new InsuranceCompany("Оберіг", "Київ, вул. Шевченка, 10", "LIC12345", "Медичне страхування");
        orgs[1] = new OilGasCompany("Нафтогаз Енерджі", "Полтава, вул. Центральна, 25", 12, 8500.5);
        orgs[2] = new Factory("МоторБуд", "Харків, просп. Перемоги, 45", "Двигуни", 430);

        System.out.println("\n=== Інформація про організації ===");
        for (Organization org : orgs) {
            org.Show();
            System.out.println();
        }

        sc.close();
    }
}
