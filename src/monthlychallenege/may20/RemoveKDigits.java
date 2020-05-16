package monthlychallenege.may20;

class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("91432219", 3));
    }

    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        } else if (k == num.length()) {
            return "0";
        }

        StringBuilder result = new StringBuilder(num);

        int j = 1;
        for (int i = 0; i < k; i++) {
            while (j < result.length() - 1 && result.charAt(j) <= result.charAt(j - 1)) {
                j++;
                break;
            }
            result.delete(j-2, j-1);
        }

        if (result.charAt(0) == '0') {
            int d = 1;
            while (result.charAt(d) == '0' && d < result.length() - 1) {
                d++;
            }
            result.delete(0, d);
        }

        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }

    /*public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        } else if (k == num.length()) {
            return "0";
        }

        int pos = 0;
        char[] answer = new char[num.length() - k];
        answer[pos] = num.charAt(0);

        int cnt = 0;
        for (int i = 1; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (answer[pos] > ch) {
                if (pos >= 1) {
                    int cp = pos;
                    while (cp >= 1 && cnt < k && answer[cp - 1] >= answer[cp]) {
                        answer[cp - 1] = answer[cp];
                        cp--;
                        cnt++;
                    }
                    answer[pos] = ch;
                    if (cnt == k) {
                        while (++i < num.length()) {
                            answer[++pos] = num.charAt(i);
                        }
                        break;
                    }
                }
                answer[pos] = ch;
                cnt++;
                if (cnt == k) {
                    while (++i < num.length()) {
                        answer[++pos] = num.charAt(i);
                    }
                    break;
                }
            } else if(answer[pos] == ch) {
                if (pos >= 1) {
                    int cp = pos;
                    while (cp >= 1 && cnt < k && answer[cp - 1] >= answer[cp]) {
                        answer[cp - 1] = answer[cp];
                        cp--;
                        cnt++;
                    }
                    answer[pos] = ch;
                    if (cnt == k) {
                        while (++i < num.length() && pos < answer.length - 1) {
                            answer[++pos] = num.charAt(i);
                        }
                        break;
                    }
                }
                if (pos < answer.length - 1) {
                    answer[++pos] = ch;
                }
            } else if (pos < answer.length - 1){
                answer[++pos] = ch;
            }
        }

        if (answer[0] == '0' && answer.length > 1) {
            int i = 1;
            while (answer[i] == '0' && i < answer.length - 1) {
                i++;
            }
            return String.valueOf(Arrays.copyOfRange(answer, i, answer.length));
        }

        return String.valueOf(answer);
    }*/

    public String removeKdigitsRec(String num, int k) {
        if (k <= 0) {
            return num;
        } else if (k >= num.length()) {
            return "0";
        }
        String reducedNum = removeKdigitsFromNum(num, k);
        while (reducedNum.charAt(0) == '0' && reducedNum.length() != 1) {
            reducedNum = reducedNum.substring(1);
        }
        return reducedNum;
    }

    public String removeKdigitsFromNum(String num, int k) {
        if (k == 0) {
            return num;
        } else if (k == num.length()) {
            return "";
        }

        String incl = removeKdigitsFromNum(num.substring(1), k - 1);
        String excl = num.charAt(0) + removeKdigitsFromNum(num.substring(1), k);

        return incl.compareTo(excl) < 0 ? incl : excl;
    }

}