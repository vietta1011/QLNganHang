package QLTKNH;
import java.util.Random;
/* class sinh số ngẫu nhiên có 6 chữ số */
public class RandomNumberExample {
    public static String RandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000); // Số ngẫu nhiên trong khoảng từ 0 đến 999999
        String formattedNumber = String.format("%06d", randomNumber); // Định dạng số thành chuỗi 6 chữ số, nếu số có ít hơn 6 chữ số thì sẽ được điền thêm các số 0 ở phía trước
        return formattedNumber;
    }
}