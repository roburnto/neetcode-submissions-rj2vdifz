class Solution {
    public int reverse(int x) {
        String integer = Integer.toString(x);
        String reversed;
        if (x < 0) {
            reversed = '-'
                + new StringBuilder(integer.substring(1, integer.length())).reverse().toString();
        } else {
            reversed = new StringBuilder(integer).reverse().toString();
        }

        long num = Long.parseLong(reversed);
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) num;
    }
}
