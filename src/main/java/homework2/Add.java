package homework2;

public class Add {
    public static void main(String[] args) {
        Exception md= new Exception();

        String array[][] = new String[4][4];
        try {
            System.out.println("Сумма элементов " + md.twoArray(array) );
        } catch (MyArraySizeException e){
            System.out.println("Неверный формат массива");
        } catch (MyArrayDataException e) {
            System.out.println(" Неверный элемент в массиве");
        }

    }
}