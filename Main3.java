interface IPair {
    IPair add(IPair p);
    IPair subtract(IPair p);
    IPair multiply(IPair p);
    IPair divide(IPair p);
}


class Money2 implements IPair {
    private double hryvnias;
    private double kopecks;

    public Money2(double hryvnias, double kopecks) {
        this.hryvnias = hryvnias;
        this.kopecks = kopecks;
    }

    @Override
    public IPair add(IPair p) {
        Money2 m = (Money2) p;
        return new Money2(this.hryvnias + m.hryvnias, this.kopecks + m.kopecks);
    }

    @Override
    public IPair subtract(IPair p) {
        Money2 m = (Money2) p;
        return new Money2(this.hryvnias - m.hryvnias, this.kopecks - m.kopecks);
    }

    @Override
    public IPair multiply(IPair p) {
        Money2 m = (Money2) p;
        return new Money2(this.hryvnias * m.hryvnias, this.kopecks * m.kopecks);
    }

    @Override
    public IPair divide(IPair p) {
        Money2 m = (Money2) p;
        return new Money2(this.hryvnias / m.hryvnias, this.kopecks / m.kopecks);
    }

    @Override
    public String toString() {
        return String.format("Гроші: %.2f грн %.2f коп", hryvnias, kopecks);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money2)) return false;
        Money2 m = (Money2) obj;
        return this.hryvnias == m.hryvnias && this.kopecks == m.kopecks;
    }
}


class Complex2 implements IPair {
    private double real;
    private double imag;

    public Complex2(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public IPair add(IPair p) {
        Complex2 c = (Complex2) p;
        return new Complex2(this.real + c.real, this.imag + c.imag);
    }

    @Override
    public IPair subtract(IPair p) {
        Complex2 c = (Complex2) p;
        return new Complex2(this.real - c.real, this.imag - c.imag);
    }

    @Override
    public IPair multiply(IPair p) {
        Complex2 c = (Complex2) p;
        double realPart = this.real * c.real - this.imag * c.imag;
        double imagPart = this.real * c.imag + this.imag * c.real;
        return new Complex2(realPart, imagPart);
    }

    @Override
    public IPair divide(IPair p) {
        Complex2 c = (Complex2) p;
        double denom = c.real * c.real + c.imag * c.imag;
        double realPart = (this.real * c.real + this.imag * c.imag) / denom;
        double imagPart = (this.imag * c.real - this.real * c.imag) / denom;
        return new Complex2(realPart, imagPart);
    }

    @Override
    public String toString() {
        return String.format("Комплексне число: %.2f + %.2fi", real, imag);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Complex2)) return false;
        Complex2 c = (Complex2) obj;
        return this.real == c.real && this.imag == c.imag;
    }
}


public class Main3 {
    public static void main(String[] args) {
        IPair m1 = new Money2(100, 50);
        IPair m2 = new Money2(50, 25);
        IPair c1 = new Complex2(3, 4);
        IPair c2 = new Complex2(1, 2);

        System.out.println(" Робота з Money2 ");
        System.out.println("m1 + m2 = " + m1.add(m2));
        System.out.println("m1 - m2 = " + m1.subtract(m2));
        System.out.println("m1 * m2 = " + m1.multiply(m2));
        System.out.println("m1 / m2 = " + m1.divide(m2));

        System.out.println("\n Робота з Complex2 ");
        System.out.println("c1 + c2 = " + c1.add(c2));
        System.out.println("c1 - c2 = " + c1.subtract(c2));
        System.out.println("c1 * c2 = " + c1.multiply(c2));
        System.out.println("c1 / c2 = " + c1.divide(c2));
    }
}
