abstract class Pair {
    protected double a;
    protected double b;

    public Pair(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public abstract Pair add(Pair p);
    public abstract Pair subtract(Pair p);
    public abstract Pair multiply(Pair p);
    public abstract Pair divide(Pair p);

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}

class Money extends Pair {

    public Money(double hryvnias, double kopecks) {
        super(hryvnias, kopecks);
    }

    @Override
    public Pair add(Pair p) {
        return new Money(this.a + p.a, this.b + p.b);
    }

    @Override
    public Pair subtract(Pair p) {
        return new Money(this.a - p.a, this.b - p.b);
    }

    @Override
    public Pair multiply(Pair p) {
        return new Money(this.a * p.a, this.b * p.b);
    }

    @Override
    public Pair divide(Pair p) {
        return new Money(this.a / p.a, this.b / p.b);
    }

    @Override
    public String toString() {
        return String.format("Гроші: %.2f грн %.2f коп", a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) return false;
        Money m = (Money) obj;
        return this.a == m.a && this.b == m.b;
    }
}


class Complex extends Pair {

    public Complex(double real, double imaginary) {
        super(real, imaginary);
    }

    @Override
    public Pair add(Pair p) {
        return new Complex(this.a + p.a, this.b + p.b);
    }

    @Override
    public Pair subtract(Pair p) {
        return new Complex(this.a - p.a, this.b - p.b);
    }

    @Override
    public Pair multiply(Pair p) {
        double real = this.a * p.a - this.b * p.b;
        double imag = this.a * p.b + this.b * p.a;
        return new Complex(real, imag);
    }

    @Override
    public Pair divide(Pair p) {
        double denom = p.a * p.a + p.b * p.b;
        double real = (this.a * p.a + this.b * p.b) / denom;
        double imag = (this.b * p.a - this.a * p.b) / denom;
        return new Complex(real, imag);
    }

    @Override
    public String toString() {
        return String.format("Комплексне число: %.2f + %.2fi", a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Complex)) return false;
        Complex c = (Complex) obj;
        return this.a == c.a && this.b == c.b;
    }
}


public class Main2 {
    public static void main(String[] args) {
        Pair m1 = new Money(100, 50);
        Pair m2 = new Money(50, 25);

        Pair c1 = new Complex(3, 4);
        Pair c2 = new Complex(1, 2);

        System.out.println("--- Робота з класом Money ---");
        System.out.println("m1 + m2 = " + m1.add(m2));
        System.out.println("m1 - m2 = " + m1.subtract(m2));
        System.out.println("m1 * m2 = " + m1.multiply(m2));
        System.out.println("m1 / m2 = " + m1.divide(m2));

        System.out.println("\n--- Робота з класом Complex ---");
        System.out.println("c1 + c2 = " + c1.add(c2));
        System.out.println("c1 - c2 = " + c1.subtract(c2));
        System.out.println("c1 * c2 = " + c1.multiply(c2));
        System.out.println("c1 / c2 = " + c1.divide(c2));
    }
}
