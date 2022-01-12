package homework2;

public class Exception {
    public static int twoArray(String a[][]) throws MyArrayDataException, MyArraySizeException {

        int index1 = 0;
        int index2 = 0;
        int sum = 0;


        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[i][j] = String.valueOf((int) (Math.random() * 100));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyArraySizeException("Не верный формат");
        }

        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    index1 = i;
                    index2 = j;
                    sum = sum + Integer.parseInt(a[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Не верный формат в ячейке" + "[" + index1 + "]" + "[" + index2 + "]");
        }
        return sum;
    }
}