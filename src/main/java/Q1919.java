import java.util.LinkedList;
import java.util.List;

public class Q1919 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        for (Integer item: A) {
            System.out.print(item + ", ");
        }
        move(A.size(), A, C, B);
        for (Integer item: C) {
            System.out.print(item + ", ");
        }
    }

    public void move(int size, List<Integer> source, List<Integer> target, List<Integer> other) {
        if (size == 1) {
            target.add(source.remove(source.size() - 1));
            return;
        }

        move(size - 1, source, other, target);
        move(1, source, target, other);
        move(size - 1, other, target, source);
    }

    public static void main(String[] args) {
        Q1919 question = new Q1919();
        LinkedList<Integer> source = new LinkedList<Integer>();
        source.add(2);
        source.add(1);
        source.add(0);
        question.hanota(
                source,
                new LinkedList<Integer>(),
                new LinkedList<Integer>()
        );
    }
}
