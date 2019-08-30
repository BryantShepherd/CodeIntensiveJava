package Test;

public class KeyValue <K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        KeyValue<Integer, String> entry = new KeyValue<Integer, String>(10000, "Harry");
        int phone = entry.getKey();
        String name = entry.getValue();
        System.out.println(phone + " " + name);
        Number[] numbers = new Number[3];
        numbers[0] = new Integer(10);
        numbers[1] = new Double(3.14);
        numbers[2] = new Float(12.2);
    }
}
