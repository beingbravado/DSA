public class LC5788 {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i)=='1' || num.charAt(i) == '3' || num.charAt(i) == '5' || num.charAt(i) == '7'
                    || num.charAt(i) == '9') {
                for (int j = 0; j < i; j++) {
                    sb.append(num.charAt(j));
                }
                break;
            }
        }
        return sb.toString();
    }
}
