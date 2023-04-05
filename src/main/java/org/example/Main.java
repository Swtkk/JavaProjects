package org.example;

public class Main {
    public static void main(String[] args) {



        User nowy = new User("123","321","m","g","foo","foo");
        ComplexNumber liczbaZespolona = new ComplexNumber();
        VectorStack wektor = new VectorStack(3);
        System.out.println(nowy.getLogin());
        System.out.println(nowy.getPassword());
        nowy.setPassword(("123"));
        System.out.println(nowy.getPassword());
        System.out.println(nowy);
        System.out.println(liczbaZespolona);
        wektor.push(1);
        wektor.push(1);
        wektor.push(1);
        wektor.push(1);
    }

}

class User{
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;

    public User(){
    }

    public User(String login,String password,String firstName,String lastName,String address, String dateOfBirth){
        this.login = login;
        this.password = String.format("%"+password.length()+"s", "").replace(' ', '*');
        this.firstName =firstName;
        this.lastName =lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;

    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){return password;}

    public void setPassword(String password){this.password=password;}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return "Imię i nazwisko: " + firstName + " " + lastName + "\n" +
                "Adres: " + address + "\n" +
                "Data urodzenia: " + dateOfBirth + "\n" +
                "Login: " + login + "\n" +
                "Hasło: " + String.format("%"+password.length()+"s", "").replace(' ', '*')+ "\n";

    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

class VectorStack {
    private int[] stack;
    private int top;
    private int size;

    public VectorStack(int size) {
        this.stack = new int[size];
        this.top = -1;
        this.size = size;
    }

    public void push(int n) {
        if (isFull()) {
            System.out.println("Stos jest pelny!");
            return;
        }
        stack[++top] = n;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stos jest pusty!");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }
}