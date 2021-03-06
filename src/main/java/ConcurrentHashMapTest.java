import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        testPut();
    }
    static class MyEntry{
        String key;
        String value;
        MyEntry next;
        int idx;
        public MyEntry() {
            this.idx = 1;
        }

        public MyEntry(String key, String value, MyEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.idx = 1;
        }
    }
    private static void testPut(){
        MyEntry[] oldTable = new MyEntry[4];

        MyEntry first = new MyEntry();
        first.key = "1";
        first.value = "1";

        MyEntry second = new MyEntry();
        second.key = "2";
        second.value = "2";

        MyEntry third = new MyEntry();
        third.key = "3";
        third.value = "3";
        third.idx = 2;

        MyEntry four = new MyEntry();
        four.key = "4";
        four.value = "4";
        four.idx = 2;

        MyEntry five = new MyEntry();
        five.key = "5";
        five.value = "5";
        five.idx = 2;

        oldTable[0] = first;
        oldTable[0].next = second;
        second.next = third;

        third.next = four;
        four.next = five;

        MyEntry[] newTable = new MyEntry[4*2];


        MyEntry node = new MyEntry();

        for (int i = 0; i < 4 ; i++) {
            MyEntry e = oldTable[i];
            if (e != null) {
                MyEntry next = e.next;
                int idx = next.idx;
                if (next == null)   //  Single node on list
                    newTable[idx] = e;
                else { // Reuse consecutive sequence at same slot
                    MyEntry lastRun = e;
                    int lastIdx = idx;
                    for (MyEntry last = next;
                         last != null;
                         last = last.next) {
                        int k = last.idx;
                        if (k != lastIdx) {
                            lastIdx = k;
                            lastRun = last;
                        }
                    }
                    //将连续的尾节点，直接按顺序拷贝到新数组的的节点
                    newTable[lastIdx] = lastRun;
                    //将头部的一些节点，采用头插法插入到newTable
                    // Clone remaining nodes
                    for (MyEntry p = e; p != lastRun; p = p.next) {
                        String v = p.value;
                        int k = p.idx;
                        MyEntry n = newTable[k];
                        newTable[k] = new MyEntry( p.key, v, n);
                    }
                }
            }
        }
        int nodeIndex = 1; // add the new node
        node.next = (newTable[nodeIndex]);
        newTable[nodeIndex] = node;
        System.out.println(1);
    }
}
