
import java.util.*;
public class Main
{

       
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái Latin: ");
        String input = scanner.nextLine();
        scanner.close();

        int countVietnamese = countVietnamese(input);
        System.out.println("Số lượng chữ cái Tiếng Việt có thể tạo thành: " + countVietnamese);
    }

    public static int countVietnamese(String input) {
        String[] vietnameseLetters = {"ă", "â", "ê", "ô", "ơ", "ư", "đ"};
        String[] latinLetters = {"aw", "aa", "ee", "oo", "ow", "w", "dd"};
        
        int count = 0;
        int currentIndex = 0;
        int length = input.length();

        while (currentIndex < length) {
            boolean found = false;
            for (int i = 0; i < vietnameseLetters.length; i++) {
                String latinLetter = latinLetters[i];
                if (currentIndex + latinLetter.length() <= length &&
                    input.substring(currentIndex, currentIndex + latinLetter.length()).equals(latinLetter)) {
                    currentIndex += latinLetter.length();
                    found = true;
                    break;
                }
            }
            if (found) {
                count++;
            } else {
                currentIndex++;
            }
        }
        return count;
    }
}
