INSERT INTO book (id, title, author, publisher, publication_year) VALUES
  (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 1925),
  (2, 'To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', 1960),
  (3, '1984', 'George Orwell', 'Secker and Warburg', 1949),
  (4, 'Pride and Prejudice', 'Jane Austen', 'T. Egerton, Whitehall', 1813),
  (5, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Allen & Unwin', 1954);


INSERT INTO book_copy (id, book_id, available) VALUES
  (1, 1, true),
  (2, 1, true),
  (3, 1, false),
  (4, 2, true),
  (5, 3, true),
  (6, 3, true),
  (7, 3, false),
  (8, 4, true),
  (9, 5, true),
  (10, 5, true),
  (11, 5, true),
  (12, 5, false);

INSERT INTO loan (id, loan_date, expected_return_date, return_date, book_copy_id)
VALUES (1, '2023-04-10', '2023-04-15', '2023-04-18', 1),
       (2, '2023-04-12', '2023-04-17', NULL, 2),
       (3, '2023-04-15', '2023-04-20', NULL, 3),
       (4, '2023-04-16', '2023-04-21', NULL, 4),
       (5, '2023-04-17', '2023-04-22', NULL, 5);
