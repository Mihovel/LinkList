public class Main {
    private static int size = 0;

    private static LinkList addElementToEnd(LinkList linkListPointerOnEnd, String numberToEnd) {
        linkListPointerOnEnd.setNext(numberToEnd);
        size++;
        return linkListPointerOnEnd.next;
    }

    private static void printForward(LinkList linkListPointerOnStart) {
        while (linkListPointerOnStart.hasNext()) {
            linkListPointerOnStart.getCurrent();
            linkListPointerOnStart = linkListPointerOnStart.next;
        }
        System.out.println(linkListPointerOnStart.current);
    }

    //почему нумерация элементов с 0?
    private static LinkList swap(LinkList linkListPointerOnStart, int numberToSwap1, int numberToSwap2) {
        if ((numberToSwap1 > size) || (numberToSwap2 > size)) {
            return null;
        } else {
            String toSwap1;
            String toSwap2;
            for (int i = 1; i <= Math.min(numberToSwap1, numberToSwap2); i++) {
                linkListPointerOnStart = linkListPointerOnStart.next;
            }
            toSwap1 = linkListPointerOnStart.current;
            for (int j = Math.min(numberToSwap1, numberToSwap2); j < Math.max(numberToSwap1, numberToSwap2);
                 j++) {
                linkListPointerOnStart = linkListPointerOnStart.next;
            }
            toSwap2 = linkListPointerOnStart.current;
            linkListPointerOnStart.current = toSwap1;
            for (int j = Math.max(numberToSwap1, numberToSwap2); j > Math.min(numberToSwap1, numberToSwap2);
                 j--) {
                linkListPointerOnStart = linkListPointerOnStart.previous;
            }
            linkListPointerOnStart.current = toSwap2;
            for (int j = Math.min(numberToSwap1, numberToSwap2); j > 0; j--) {
                linkListPointerOnStart = linkListPointerOnStart.previous;
            }
        }
        return linkListPointerOnStart;
    }


    public static void main(String[] args) {
        LinkList linkListPointerOnEnd = new LinkList(null, "1", null);
        LinkList linkListPointerOnStart = linkListPointerOnEnd;
        size++;
        linkListPointerOnEnd = addElementToEnd(linkListPointerOnEnd, "2");
        linkListPointerOnEnd = addElementToEnd(linkListPointerOnEnd, "3");
        linkListPointerOnEnd = addElementToEnd(linkListPointerOnEnd, "4");
        linkListPointerOnEnd = addElementToEnd(linkListPointerOnEnd, "5");
        //почему строка 56 не учитывается.Вернее учитывается, но идея предлагает ее убрать
        linkListPointerOnEnd = addElementToEnd(linkListPointerOnEnd, "6");
        printForward(linkListPointerOnStart);
        int toSwap1 = 0;
        int toSwap2 = 2;
        System.out.println("Swap");
        printForward(swap(linkListPointerOnStart, toSwap1, toSwap2));
    }
}
