package by.epam.learn.classes;

class ClassesDemo {

    public static void main(String[] args) {
        Book books[] = new Book[10];
        books[0] = new Book("Java8. Руководство для начинающих", "Герберт Шилдт", "Вильямс", 1988, 700, 10.10, Binding.SOFT);
        books[1] = new Book("Java 8. Полное руководство", "Герберт Шилдт", "Осборн", 1989, 900, 20.20, Binding.SOFT);
        books[2] = new Book("Quo vadis", "Генрик Сенкевич", "unknown", 1896, 777, 10000, Binding.SOFT);
        books[3] = new Book("Мастер и Маргарита", "Михаил Булгаков", "Шанъу иньшугуань", 1949, 1900, 42.42, Binding.HARD);
        books[4] = new Book("Собачье сердце", "Михаил Булгаков", "Шанъу иньшугуань", 1998, 1200, 333, Binding.HARD);
        books[5] = new Book("Рассказы", "Антон Чехов", "Шанъу иньшугуань", 2013, 1200, 333, Binding.HARD);
        books[6] = new Book("Дама с собачкой", "Антон Чехов", "Русская мысль", 1959, 399, 333, Binding.HARD);
        books[7] = new Book("Человек в футляре", "Антон Чехов", "Русская мысль", 1899, 787, 333, Binding.HARD);
        books[8] = new Book("Остров Сахалин", "Антон Чехов", "Шанъу иньшугуань", 2000, 666, 666, Binding.HARD);
        books[9] = new Book("Случай на охоте", "Антон Чехов", "Шанъу иньшугуань", 2001, 999, 1313, Binding.HARD);

        Book oneMoreBook = new Book("Белая Гвардия", "Михаил Булгаков", "Шанъу иньшугуань", 2001, 879, 1313, Binding.HARD);
        Book[] twoMoreBooks = new Book[]{
                new Book("Морфий", "Михаил Булгаков", "Русская мысль", 1991, 777, 1003, Binding.SOFT),
                new Book("Чистый Код", "Роберт Мартин", "Осборн", 2001, 888, 1123, Binding.HARD)
        };

        Library library = new Library(books);
        library.addBooks(oneMoreBook);
        library.addBooks(twoMoreBooks);

        System.out.println("\n1. Список книг, заданного автора:");
        library.showSpecificAuthor("Булгаков");

        System.out.println("\n2. Список книг, выпущенных заданным издательством:");
        library.showSpecificPublisher("Осборн");

        System.out.println("\n3. Список книг, выпущенных после заданного года.");
        library.showBooksAfterYear(2000);
    }

}
