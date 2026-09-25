class Solution {

    public List<String> braceExpansionII(String expression) {
    Set<String> result = solve(expression, 0, expression.length() - 1);
    List<String> ans = new ArrayList<>(result);
    Collections.sort(ans);

        return ans;
    }

    private Set<String> solve(String s, int left, int right) {

    Set<String> result = new HashSet<>();

        int i = left;

        while (i <= right) {

            if (s.charAt(i) == '{') {

                int count = 1;
                int j = i + 1;

                while (count > 0) {

                    if (s.charAt(j) == '{') {
                        count++;
                    } 
                    else if (s.charAt(j) == '}') {
                        count--;
                    }

                    j++;
                }

                Set<String> current = solve(s, i + 1, j - 2);

                if (result.isEmpty()) {
                    result.addAll(current);
                } 
                else {
                    result = multiply(result, current);
                }

                i = j;
            }

            
            else if (Character.isLetter(s.charAt(i))) {

                Set<String> current = new HashSet<>();
                current.add(String.valueOf(s.charAt(i)));

                if (result.isEmpty()) {
                    result.addAll(current);
                } 
                else {
                    result = multiply(result, current);
                }

                i++;
            }

            else if (s.charAt(i) == ',') {

                Set<String> current = solve(s, i + 1, right);

                result.addAll(current);

                break;
            }
        }

        return result;
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}