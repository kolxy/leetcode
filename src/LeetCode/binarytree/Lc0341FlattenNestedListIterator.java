package LeetCode.binarytree;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lc0341FlattenNestedListIterator implements Iterator<Integer>, LcTemplate {

    @Override
    public void run() {

    }

    private Iterator<Integer> itr;
    private int index;
    public Lc0341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        List<Integer> list = flatten(nestedList);
        itr = list.iterator();
        index = 0;
    }

    @Override
    public Integer next() {
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }

    private List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for (NestedInteger node : nestedList) {
            if (node.isInteger()) {
                list.add(node.getInteger());
            } else {
                list.addAll(flatten(node.getList()));
            }
        }
        return list;
    }
}
