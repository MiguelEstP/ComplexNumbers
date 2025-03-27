import java.util.Scanner;

public class ComplexNumbers {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

    System.out.print("Type a complex number (a + bi): ");
    ComplexNumber c1 = ComplexNumber.parseComplex(scanner.nextLine());
    
    System.out.print("Type another complex number (a + bi): ");
    ComplexNumber c2 = ComplexNumber.parseComplex(scanner.nextLine());
    
    ComplexNumber soma = c1.add(c2);
    ComplexNumber produto = c1.multiply(c2);
    ComplexNumber c1Conjugate = c1.conjugate();
    ComplexNumber c2Conjugate = c2.conjugate();
    
    System.out.println("Soma: " + soma);
    System.out.println("Produto: " + produto);
    System.out.println("C1 conjugado: " + c1Conjugate);
    System.out.println("C2 conjugado: " + c2Conjugate);
    
    scanner.close();
}
}

class ComplexNumber {
private double real;
private double imaginary;

public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
}

public ComplexNumber add(ComplexNumber other) {
    return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
}

public ComplexNumber multiply(ComplexNumber other) {
    double realPart = this.real * other.real - this.imaginary * other.imaginary;
    double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
    return new ComplexNumber(realPart, imaginaryPart);
}

public ComplexNumber conjugate() {
    return new ComplexNumber(this.real, -this.imaginary);
}

@Override
public String toString() {
    return real + " + " + imaginary + "i";
}

public static ComplexNumber parseComplex(String input) {
    input = input.replace("i", "").replace(" ", "");
    String[] parts = input.split("[+-]", 2);
    
    double realPart = 0, imaginaryPart = 0;
    if (parts.length == 2) {
        realPart = Double.parseDouble(parts[0]);
        imaginaryPart = Double.parseDouble((input.contains("-") ? "-" : "+") + parts[1]);
    } else if (input.endsWith("i")) {
        imaginaryPart = Double.parseDouble(input);
    } else {
        realPart = Double.parseDouble(input);
    }
    
    return new ComplexNumber(realPart, imaginaryPart);
}
}

