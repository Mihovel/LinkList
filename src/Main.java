public class Main {
    private static int size = 0;

    //прокрутка указателя в конец списка
    private static LinkList rollBack(LinkList linkList) {
        while (linkList.hasNext()) {
            linkList = linkList.next;
        }
        return linkList;
    }

    //прокрутка указателя на начало списка
    private static LinkList rollStart(LinkList linkList) {
        while (linkList.hasPrevious()) {
            linkList = linkList.previous;
        }
        return linkList;
    }

    private static LinkList addElementToStart(LinkList linkList, String number) {
        linkList = rollStart(linkList);
        linkList.previous = new LinkList(null, number, linkList);
        return linkList;
    }

    //Добавляет элемент после position
    private static LinkList addElementSomeWhere(LinkList linkList, String number, int position) {
        linkList = rollStart(linkList);
        if (position == -1) {
            addElementToStart(linkList, number);
        } else {
            for (int i = 1; i < position; i++) {
                linkList = linkList.next;
            }
            linkList.next = new LinkList(linkList, number, linkList.next);
        }
        size++;
        return linkList;
    }

    private static LinkList deleteElement(LinkList linkList, int posTodDelete) {
        if (posTodDelete == 0) {
            linkList = rollStart(linkList);
            linkList = linkList.next;
            linkList.previous = null;
        } else if (posTodDelete == size - 1) {
            linkList = rollBack(linkList);
            linkList = linkList.previous;
            linkList.next = null;
        } else {
            linkList = rollStart(linkList);
            for (int i = 1; i <= posTodDelete; i++) {
                linkList = linkList.next;
            }
            linkList = linkList.previous;
            linkList.next = linkList.next.next;
        }
        return linkList;
    }

    private static LinkList swap(LinkList linkList, int numberToSwap1, int numberToSwap2) {
        if ((numberToSwap1 > size) || (numberToSwap2 > size)) {
            return null;
        } else {
            linkList = rollStart(linkList);
            String toSwap1;
            String toSwap2;
            for (int i = 0; i < Math.min(numberToSwap1, numberToSwap2); i++) {
                linkList = linkList.next;
            }
            toSwap1 = linkList.current;
            for (int j = Math.min(numberToSwap1, numberToSwap2); j < Math.max(numberToSwap1, numberToSwap2);
                 j++) {
                linkList = linkList.next;
            }
            toSwap2 = linkList.current;
            linkList.current = toSwap1;
            for (int j = Math.max(numberToSwap1, numberToSwap2) - 1; j >= Math.min(numberToSwap1, numberToSwap2);
                 j--) {
                linkList = linkList.previous;
            }
            linkList.current = toSwap2;
        }
        return linkList;
    }

    private static void printForward(LinkList linkList) {
        linkList = rollStart(linkList);
        while (linkList.hasNext()) {
            linkList.getCurrent();
            linkList = linkList.next;
        }
        System.out.println(linkList.current);
    }

    public static void main(String[] args) {
        //тесты. Вроде все работает, но я не чекал
        System.out.println("test addSomeWhere + printForward");
        LinkList linkList = new LinkList(null, "1", null);
        size++;
        linkList = addElementSomeWhere(linkList, "2", size);
        linkList = addElementSomeWhere(linkList, "3", size);
        linkList = addElementSomeWhere(linkList, "4", size);
        linkList = addElementSomeWhere(linkList, "5", size);
        printForward(linkList);

        System.out.println("test swap 0 and 1 element");
        linkList = swap(linkList, 0, 1);
        printForward(linkList);

        //если хотим поменять последний элемент - пишем size - 1
        System.out.println("test swap 0 and size - 1 element");
        linkList = swap(linkList, 0, size - 1);
        printForward(linkList);

        //если хотим поменять последний элемент - пишем size - 1
        System.out.println("test swap 2 and size - 1 element");
        linkList = swap(linkList, 2, size - 1);
        printForward(linkList);

        //если хотим поменять последний элемент - пишем size - 1
        System.out.println("test swap 2 and 3 element");
        linkList = swap(linkList, 2, 3);
        printForward(linkList);

        System.out.println("test delete 0 element");
        linkList = deleteElement(linkList, 0);
        printForward(linkList);

        //если хотим удалить последний элемент - пишем size - 1
        System.out.println("test delete size - 1 element");
        linkList = deleteElement(linkList, size - 1);
        printForward(linkList);

        System.out.println("test delete 1 element");
        linkList = deleteElement(linkList, 1);
        printForward(linkList);
    }
}
