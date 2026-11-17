
import java.util.*;

public class Main {

    static class Permutation {
        int[] values;
        int length;

        Permutation(int capacity) {
            values = new int[Math.max(1, capacity)];
            length = 0;
        }

        void addValue(int value) {
            if (length == values.length) {
                values = Arrays.copyOf(values, values.length * 2);
            }
            values[length++] = value;
        }
    }

    static Permutation mergePermutations(
            Permutation oldPermutation,
            Permutation otherPermutation,
            int rootValue,
            int insertionPosition) {

        int remaining = oldPermutation.length - insertionPosition;

        Permutation result = new Permutation(
                oldPermutation.length + otherPermutation.length + 1
        );

        for (int i = 0; i < insertionPosition; i++) {
            result.addValue(oldPermutation.values[i]);
        }

        result.addValue(rootValue);

        for (int i = 0; i < remaining; i++) {
            result.addValue(otherPermutation.values[i]);
            result.addValue(oldPermutation.values[insertionPosition + i]);
        }

        if (otherPermutation.length > remaining) {
            result.addValue(otherPermutation.values[remaining]);
        }

        return result;
    }

    static Permutation mergePermutationsInPlace(
            Permutation oldPermutation,
            Permutation otherPermutation,
            int rootValue,
            int insertionPosition) {

        int remaining = oldPermutation.length - insertionPosition;

        int[] suffix = Arrays.copyOfRange(
                oldPermutation.values,
                insertionPosition,
                oldPermutation.length
        );

        oldPermutation.length = insertionPosition;
        oldPermutation.addValue(rootValue);

        for (int i = 0; i < remaining; i++) {
            oldPermutation.addValue(otherPermutation.values[i]);
            oldPermutation.addValue(suffix[i]);
        }

        if (otherPermutation.length > remaining) {
            oldPermutation.addValue(otherPermutation.values[remaining]);
        }

        return oldPermutation;
    }

    static int compareLexicographically(
            Permutation first,
            Permutation second) {

        for (int i = 0; i < first.length; i++) {

            if (first.values[i] != second.values[i]) {
                return Integer.compare(
                        first.values[i],
                        second.values[i]
                );
            }
        }

        return 0;
    }

    static Permutation createEmptyPermutation() {
        return new Permutation(1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] leftChild = new int[n + 1];
        int[] rightChild = new int[n + 1];
        int[] subtreeSize = new int[n + 1];

        for (int node = 1; node <= n; node++) {
            leftChild[node] = sc.nextInt();
            rightChild[node] = sc.nextInt();
        }

        Permutation[] minimumPermutation = new Permutation[n + 1];
        Permutation[] maximumPermutation = new Permutation[n + 1];

        for (int node = n; node >= 1; node--) {

            int leftNode = leftChild[node];
            int rightNode = rightChild[node];

            int leftSubtreeSize = subtreeSize[leftNode];
            int rightSubtreeSize = subtreeSize[rightNode];

            subtreeSize[node] = 1 + leftSubtreeSize + rightSubtreeSize;

            boolean optionA = leftSubtreeSize >= rightSubtreeSize;

            boolean optionB = leftSubtreeSize >= 1 &&
                    rightSubtreeSize >= leftSubtreeSize - 1;

            if (!optionA && !optionB) {
                System.out.println("impossible");
                return;
            }

            Permutation minLeft = leftNode == 0
                    ? createEmptyPermutation()
                    : minimumPermutation[leftNode];

            Permutation minRight = rightNode == 0
                    ? createEmptyPermutation()
                    : minimumPermutation[rightNode];

            Permutation maxLeft = leftNode == 0
                    ? createEmptyPermutation()
                    : maximumPermutation[leftNode];

            Permutation maxRight = rightNode == 0
                    ? createEmptyPermutation()
                    : maximumPermutation[rightNode];

            if (optionA && optionB) {

                int positionA = leftSubtreeSize - rightSubtreeSize;

                Permutation minOptionA = mergePermutations(
                        minLeft, minRight, node, positionA
                );

                Permutation maxOptionA = mergePermutations(
                        maxLeft, maxRight, node, positionA
                );

                int positionB = rightSubtreeSize - leftSubtreeSize + 1;

                Permutation minOptionB = mergePermutations(
                        minRight, minLeft, node, positionB
                );

                Permutation maxOptionB = mergePermutations(
                        maxRight, maxLeft, node, positionB
                );

                minimumPermutation[node] =
                        compareLexicographically(minOptionA, minOptionB) <= 0
                                ? minOptionA : minOptionB;

                maximumPermutation[node] =
                        compareLexicographically(maxOptionA, maxOptionB) >= 0
                                ? maxOptionA : maxOptionB;

            } else if (optionA) {

                int insertionPosition =
                        leftSubtreeSize - rightSubtreeSize;

                minimumPermutation[node] = mergePermutationsInPlace(
                        minLeft, minRight, node, insertionPosition
                );

                maximumPermutation[node] = mergePermutationsInPlace(
                        maxLeft, maxRight, node, insertionPosition
                );

            } else {

                int insertionPosition =
                        rightSubtreeSize - leftSubtreeSize + 1;

                minimumPermutation[node] = mergePermutationsInPlace(
                        minRight, minLeft, node, insertionPosition
                );

                maximumPermutation[node] = mergePermutationsInPlace(
                        maxRight, maxLeft, node, insertionPosition
                );
            }

            minimumPermutation[leftNode] = null;
            maximumPermutation[leftNode] = null;

            minimumPermutation[rightNode] = null;
            maximumPermutation[rightNode] = null;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < minimumPermutation[1].length; i++) {
            if (i > 0) answer.append(" ");
            answer.append(minimumPermutation[1].values[i]);
        }

        answer.append("\n");

        for (int i = 0; i < maximumPermutation[1].length; i++) {
            if (i > 0) answer.append(" ");
            answer.append(maximumPermutation[1].values[i]);
        }

        System.out.println(answer);
    }
}
