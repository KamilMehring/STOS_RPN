package zad;

public class Stack {
    private String[] elements;
    private int size;

    public Stack() {
        elements = new String[10];
        size = 0;
    }

    public void push(String element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stos jest pusty");
        }
        String top = elements[--size];
        elements[size] = null;
        return top;
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stos jest pusty");
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        String[] newArray = new String[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}
