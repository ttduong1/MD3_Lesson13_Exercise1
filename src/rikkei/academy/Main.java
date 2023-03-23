package rikkei.academy;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập chuỗi: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        // Tìm chuỗi tăng dần có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) { // Vòng lặp ngoài
            // Khai báo một linked list trung gian các kí tự của chuỗi tăng dần
            LinkedList<Character> list = new LinkedList<>();
            // Thêm kí tự thứ i vào trong list
            list.add(string.charAt(i));
            for (int j = 0; j < string.length(); j++) { // VÒng lặp bên trong
                // Kiểm tra kí tự tiếp theo có lớn hơn kí tự cuối cùng trong list hay không ?
                if (string.charAt(j) > list.getLast()){
                    // Nếu có thì thêm vào trong list
                    list.add(string.charAt(j));
                }
            }
            // So sánh kích cỡ của list trung gian và list chứ chuỗi tăng dần có kích thước lớn nhất.
            if (list.size() > max.size()){
                // Nếu kích cỡ của list trung gian lớn hơn kích cỡ của list có độ dài lớn nhất thì gán lại max
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        // Hiển thị chuỗi tăng dần dài nhất
        for (Character ch : max) {
            System.out.println(ch);
        }
        System.out.println();

        /** Độ phức tạp của bài toán:
         Theo đề ra:
         1 vòng lặp ngoài = n
         1 vòng lặp trong = n -1
         1 câu lệnh = 1
         Mà : 1 vòng lặp * 1 câu lệnh = 1 * 1 = 1
         => Ta có : T(n) = (n * (n-1)) + (1 + 1)
         => T(n) = O(n^2) + O(1)
         <=> T(n) = O(n^2)
         Vậy độ phức tạp củ bài toán này là O(n^2)
         **/
    }
}