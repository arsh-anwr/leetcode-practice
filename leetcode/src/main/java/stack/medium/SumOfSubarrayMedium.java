package stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMedium {
    public int sumSubarrayMins(int[] arr) {
        /**
         [5,7,8,3,1,2,4]

         (i) * (n - i)

         monotonic stack -> either strictly increasing or decreasing.
         | 1 - i = (1)
         | 3 - i = (0)
         |
         |

         left[] = [-1 -1 1 2]
         right[] = [1 4 4 4]

         result = (right[i] (4) - i(1)) * (i(1) - left[i](- 1)) * arr[i];
         3 -> 3
         3 1 -> 1
         3 1 2 -> 1
         3 1 2 4 -> 1

         1 -> 1
         1 2 -> 1
         1 2 4 -> 1

         2 -> 2
         2 4 -> 2

         4 -> 4
         */

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Stack<Integer> st = new Stack();

        Arrays.fill(left, -1);
        Arrays.fill(right, arr.length);

        for (int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                left[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                right[i] = st.peek();
            }
            st.push(i);
        }

        int mod = 1000000007;
        long ans = 0l;

        for (int i = 0; i < arr.length; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            ans %= mod;
        }

        return (int) ans;
    }
}
