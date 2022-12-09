public class Main2 {
    public static void main(String[] args) {
        tinhGiaiThua(24);
    }

    public static int tinhGiaiThua(int n) {
        int giaithua = 1;
        if (n <= 0) {
            return 0;
        } else {
            if (n > 25) {
                return -1;
            } else {
                for (int i = 0; i <= n; i++) {
                    giaithua = giaithua * i;
                }
            }
        }
        System.out.println(giaithua);
        return giaithua;
    }
}
