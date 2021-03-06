public class User {
    private int i;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return i == that.i;
    }

    // 因为此处取模后，左移 4 为，相当于放大 16 倍。最大为 48
    // 相对于 HashMap#hash(Object) 函数来说，(h = key.hashCode()) ^ (h >>> 16) 结果不变。
    @Override
    public int hashCode() {
        return i % 4 << 4; // 等价于 (i % 4) * 16
    }
}
