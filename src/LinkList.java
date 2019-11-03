public class LinkList implements LinkListMethods {
    LinkList previous;
    String current;
    LinkList next;

    LinkList(LinkList previous, String current, LinkList next) {
        this.previous = previous;
        this.current = current;
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public void getCurrent() {
        System.out.println(current);
    }

    @Override
    public void setNext(String next) {
        this.next = new LinkList(this, next, null);
    }

    //дальше - для себя

    boolean hasPrevious() {
        return this.previous != null;
    }
}
