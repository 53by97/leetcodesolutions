package monthlychallenege.jun20;

class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().change(5, new int[]{5, 1, 2}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}